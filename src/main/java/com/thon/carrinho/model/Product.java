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
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private double unityValue;

  @Builder.Default // sempre que criarmos um produto estará setado que está disponível por padrão
  private Boolean available = true;

  @ManyToOne // Aqui etamos dizendo que muitos produtos podm pertencer à 1 restaurante
  @JsonIgnore
  private Restaurant restaurant;
}
