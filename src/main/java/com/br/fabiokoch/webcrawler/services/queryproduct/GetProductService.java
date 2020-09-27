package com.br.fabiokoch.webcrawler.services.queryproduct;

import com.br.fabiokoch.webcrawler.dto.ProductDTO;
import com.br.fabiokoch.webcrawler.entities.ProductEntity;
import com.br.fabiokoch.webcrawler.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GetProductService {

    @Autowired
    private ProductRepository productRepository;

    //Método que retorna todos os produtos
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> productDTOS = new ArrayList<>();
        List<ProductEntity> productEntities = productRepository.findAll();
        for (ProductEntity p : productEntities) {
            ProductDTO pr = ProductDTO.builder()
                    .nome(p.getNome())
                    .preco(p.getPreco())
                    .build();
            productDTOS.add(pr);
        }
        log.info("GetProductService.getAllProducts: {}", productDTOS);
        return productDTOS;
    }

    //Método que retorna todos os produtos ordenado pelo preço
    public List<ProductDTO> getAllProductsOrderByPrice() {
        List<ProductDTO> productDTOS = new ArrayList<>();
        List<ProductEntity> productEntities = productRepository.findAllByOrderByPreco();
        for (ProductEntity p : productEntities) {
            ProductDTO pr = ProductDTO.builder()
                    .nome(p.getNome())
                    .preco(p.getPreco())
                    .build();
            productDTOS.add(pr);
        }
        log.info("GetProductService.getAllProductsOrderByPrice: {}", productDTOS);
        return productDTOS;
    }

}
