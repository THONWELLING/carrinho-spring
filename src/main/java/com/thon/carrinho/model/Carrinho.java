package com.thon.carrinho.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.thon.carrinho.enumeration.PaymentForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor  // (Lombok) Criando um contrutor com todos os atributos
@Builder  // um padrão do design patters que vai nos ajudar na hora de criar o objeto
@Data  //(Lombok) Criando todos os getters e setters
@Entity  //indicando que essa classe será uma tabela no banco de dados
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", })
@NoArgsConstructor  //(Lombok) Criando um contrutor sem atributos

public class Carrinho {
  @Id  //indicando que o id vai ser o primaryKey
  @GeneratedValue(strategy = GenerationType.AUTO)  //gerando os IDs auto incrementados
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)

  @JsonIgnore  //ignorar qualquer erro de serialização relacionado ao json na utilização back/front
  private Client client;
  @OneToMany(cascade = CascadeType.ALL)
  private List<Item> items;
  private Double total;

  @Enumerated
  private PaymentForm paymentForm;
  private boolean closed;


}
