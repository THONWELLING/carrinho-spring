package com.thon.carrinho.resouce;


import com.thon.carrinho.model.Carrinho;
import com.thon.carrinho.model.Item;
import com.thon.carrinho.resouce.dto.ItemDto;
import com.thon.carrinho.service.CarrinhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ifood/carrinho")
@RequiredArgsConstructor
public class CarrinhoController {

  private final CarrinhoService carrinhoService;

  @PostMapping
  public Item addOnCarrinho(@RequestBody ItemDto itemDto) {
    return carrinhoService.addItemOnCarrinho(itemDto);
  }

  @GetMapping("/{id}")
  public Carrinho showCarrinho(@PathVariable("id") Long id) {
    return carrinhoService.showCarrinho(id);
  }

  @PatchMapping("/closeCarrinho/{carrinhoId}")
  public Carrinho closeCarrinho(@PathVariable("carrinhoId") Long carrinhoId,
                                @RequestParam("paymentForm") int paymentForm) {

    return carrinhoService.closeCarrinho(carrinhoId, paymentForm);
  }
}
