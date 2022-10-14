package com.thon.carrinho.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor  // (Lombok) Criando um contrutor com todos os atributos
@Builder  // um padrão do design patters que vai nos ajudar na hora de criar o objeto
@Data  //(Lombok) Criando todos os getters e setters além disso para ter o equals e o hashCode para fazer comparações
@Entity  //indicando que essa classe será uma tabela no banco de dados
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", })
@NoArgsConstructor  //(Lombok) Criando um contrutor sem atributos

public class Restaurant {
  @Id //indicando que o id vai ser o primaryKey
  @GeneratedValue(strategy = GenerationType.AUTO)  //gerando os IDs auto-incrementados
  private Long id;
  private String name;

  @OneToMany(cascade = CascadeType.ALL)
  private List<Product> menu;

  @Embedded
  private Address address;
}
