package com.br.fabiokoch.webcrawler.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;


//Classe de configuração onde retornará os valores informados no application.yml


@Component
@ConfigurationProperties(prefix = "crawler-info")
@Data
public class ParameterValues implements Serializable {
    private static final long serialVersionUID = 1L;

    private String urlCrawler;

    private String filterLink;

    private String productsClass;

    private String priceClass;

    private String nameClass;

}
