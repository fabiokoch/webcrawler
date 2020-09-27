package com.br.fabiokoch.webcrawler.controller;

import com.br.fabiokoch.webcrawler.dto.ProductDTO;
import com.br.fabiokoch.webcrawler.services.queryproduct.GetProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebCrawlerController {

    @Autowired
    private GetProductService getProductService;

    //API de retorno de todos os produtos
    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return ResponseEntity.ok(getProductService.getAllProducts());
    }

    //API de retorno de todos os produtos ordenados pelo preco
    @GetMapping(value = "/products/price")
    public ResponseEntity<List<ProductDTO>> getAllProductsOrderByPrice() {
        return ResponseEntity.ok(getProductService.getAllProductsOrderByPrice());
    }


}
