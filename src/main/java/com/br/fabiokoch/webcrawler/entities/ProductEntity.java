package com.br.fabiokoch.webcrawler.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;


//Classe de entidade responsável por fazer a persistência dos dados no banco de dados

@Entity
@Table(name = "PRODUCT")
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_ID")
    @SequenceGenerator(name = "PRODUCT_ID", sequenceName = "PRODUCT_ID", allocationSize = 1)
    private Long id;

    private String nome;

    private String URL;

    private String categoria;

    private String peso;

    private String cor;

    private String desconto;

    private String classificacao;

    private String preco;

}
