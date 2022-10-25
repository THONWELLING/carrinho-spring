package com.thon.carrinho.service.impl;

import com.thon.carrinho.enumeration.PaymentForm;
import com.thon.carrinho.model.Carrinho;
import com.thon.carrinho.model.Item;
import com.thon.carrinho.model.Restaurant;
import com.thon.carrinho.repository.CarrinhoRepository;
import com.thon.carrinho.repository.ItemRepository;
import com.thon.carrinho.repository.ProductRepository;
import com.thon.carrinho.resouce.dto.ItemDto;
import com.thon.carrinho.service.CarrinhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarrinhoServiceImpl implements CarrinhoService {
  private final CarrinhoRepository carrinhoRepository;
  private final ProductRepository productRepository;
  private final ItemRepository itemRepository;

  @Override
  public Item addItemOnCarrinho(ItemDto itemDto) {
    //Pegando o carrinho
    Carrinho carrinho = showCarrinho(itemDto.getCarrinhoId());

    //Verificando se o carrinho está fechado
    if (carrinho.isClosed()) {
      throw new RuntimeException("Carrinho está fechado.");
    }

    //Criar um iten
    Item itemToAdd = Item.builder()
        .quantity(itemDto.getQuantity())
        .carrinho(carrinho)
        .product(productRepository.findById(itemDto.getProductId()).orElseThrow(() -> {
          throw new RuntimeException("Esse Produto Não existe!!!");
        }))
        .build();

    /*
    Criando a regra de negócio como a do ifood:
    * Cada carrinho só pode ter itens do mesmo restaurante para inserir itens de outro restaurante
    * precisa de um novo pedido /carrinho
    */

    List<Item> carrinhoItems = carrinho.getItems(); // Pegando a lista de itens do carrinho

    // Se a lista está vazia simplesmente adiciono
    if (carrinhoItems.isEmpty()) {
      carrinhoItems.add(itemToAdd);
    } else {
      /*
      * pegando o 1º elemento da lista.associando qual é o produto e qual é o restaurante e atribuindo a uma variavel
       */
      Restaurant currentRestaurant = carrinhoItems.get(0).getProduct().getRestaurant();
      Restaurant restaurantOfNewProduct = itemToAdd.getProduct().getRestaurant(); //Pegando o restaurante do produto que quero adicionar
      if (currentRestaurant.equals(restaurantOfNewProduct)) {
        carrinhoItems.add(itemToAdd);
      } else {
        throw new RuntimeException("Não é possível adicionar itens de restaurantes diferentes.");
      }
    }

    List<Double> itemsValues = new ArrayList<>();
    for (Item carrinhoItem : carrinhoItems) {
      double totalItemValue =
        carrinhoItem.getProduct().getUnityValue() * carrinhoItem.getQuantity();
      itemsValues.add(totalItemValue);
    }

    double totalValueCarrinho = itemsValues.stream()
            .mapToDouble(totalUnityItemValue -> totalUnityItemValue)
            .sum();

    carrinho.setTotal(totalValueCarrinho);
    carrinhoRepository.save(carrinho);
    return itemToAdd;
  }

  @Override
  public Carrinho showCarrinho(Long id) {
    return carrinhoRepository.findById(id).orElseThrow(() -> {
      throw new RuntimeException("Esse Carrinho não existe");
    });
  }

  @Override
  public Carrinho closeCarrinho(Long id, int paymentFormNumber) {
    Carrinho carrinho = showCarrinho(id);
    //verificando se o carrinho tem itens ou está vazio.
    if (carrinho.getItems().isEmpty()) {
      throw new RuntimeException("Inclua itens no carrinho!!");
    }
    //verificando a forma de pagamento
    PaymentForm paymentForm =
      paymentFormNumber == 0 ? PaymentForm.CARD : PaymentForm.PIX;

    carrinho.setPaymentForm(paymentForm);
    carrinho.setClosed(true);
    return carrinhoRepository.save(carrinho);

  }
}
