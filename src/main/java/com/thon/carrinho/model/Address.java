package com.thon.carrinho.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@AllArgsConstructor
@Builder
@Data
@Embeddable  //Para simplificar a classe Address para informar que esta classe não vai ser uma tabela do banco de dados vamos usar essa classe em outras classes que também terão endereço
@NoArgsConstructor

public class Address {
  private String cep;
  private String complement;
}
