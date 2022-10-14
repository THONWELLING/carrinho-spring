package com.thon.carrinho.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@Builder
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", })
@NoArgsConstructor

/*
* Essa classe será uma tabela no banco de dados.
* Essa tabela terá relacionamento com outras 2 tabelas, Product e Carrinho*/
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;


  @OneToOne  // representando que cada Item só pode ter um produto
  private Product product;
  private int quantity;

  @ManyToOne  // aqui representando que o carrinho poderá ter muitos itens/produtos
  @JsonIgnore
  private Carrinho carrinho;
}
