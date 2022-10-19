package com.thon.carrinho.service.impl;

import com.thon.carrinho.enumeration.PaymentForm;
import com.thon.carrinho.model.Carrinho;
import com.thon.carrinho.model.Item;
import com.thon.carrinho.repository.CarrinhoRepository;
import com.thon.carrinho.resouce.dto.ItemDto;
import com.thon.carrinho.service.CarrinhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarrinhoServiceImpl implements CarrinhoService {
  private final CarrinhoRepository carrinhoRepository;
  @Override
  public Item addItemOnCarrinho(ItemDto itemDto) {
    return null;
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
    PaymentForm paymentForm = carrinho.getPaymentForm();
    switch (paymentFormNumber) {
      case 0 -> carrinho.setPaymentForm(PaymentForm.MONEY);
      case 1 -> carrinho.setPaymentForm(PaymentForm.DEBIT_CARD);
      case 2 -> carrinho.setPaymentForm(PaymentForm.PIX);
      default -> carrinho.setPaymentForm(PaymentForm.CREDIT_CARD);
    }


    carrinho.setPaymentForm(paymentForm);
    carrinho.setClosed(true);
    return carrinhoRepository.save(carrinho);

  }
}
