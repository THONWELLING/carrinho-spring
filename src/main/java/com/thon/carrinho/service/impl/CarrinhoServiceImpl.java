package com.thon.carrinho.service.impl;

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
  public Carrinho closeCarrinho(Long id, int paymentForm) {
    return null;
  }
}
