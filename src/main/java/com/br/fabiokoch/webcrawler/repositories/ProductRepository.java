package com.br.fabiokoch.webcrawler.repositories;


import com.br.fabiokoch.webcrawler.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Classe de reposítório responsável por as consultas e persistências no banco de dados

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    ProductEntity findByNome(String nome);

    List<ProductEntity> findAllByOrderByPreco();

}

