package com.thon.carrinho.service;

import com.thon.carrinho.model.Carrinho;
import com.thon.carrinho.model.Item;
import com.thon.carrinho.resouce.dto.ItemDto;

public interface CarrinhoService {
  Item addItemOnCarrinho(ItemDto itemDto);
  Carrinho showCarrinho(Long id);
  Carrinho closeCarrinho(Long id, int paymentForm);
}
