package com.thon.carrinho.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor  // (Lombok) Criando um contrutor com todos os atributos
@Builder  // um padrão do design patters que vai nos ajudar na hora de criar o objeto
@Data  //(Lombok) Criando todos os getters e setters além disso para ter o equals e o hashCode para fazer comparações
@Entity  //indicando que essa classe será uma tabela no banco de dados
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", })
@NoArgsConstructor  //(Lombok) Criando um contrutor sem atributos

public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;

  @Embedded
  private Address address;
}
