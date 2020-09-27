package com.br.fabiokoch.webcrawler.dto;

import lombok.Builder;
import lombok.Data;


//Classe de DTO responsável por mapear os valores encontrados

@Data
@Builder
public class ProductDTO {

    private String nome;

    private String URL;

    private String categoria;

    private String peso;

    private String cor;

    private String desconto;

    private String classificacao;

    private String preco;
}
