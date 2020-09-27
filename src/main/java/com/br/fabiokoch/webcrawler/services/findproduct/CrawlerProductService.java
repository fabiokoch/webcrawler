package com.br.fabiokoch.webcrawler.services.findproduct;

import com.br.fabiokoch.webcrawler.config.ParameterValues;
import com.br.fabiokoch.webcrawler.entities.ProductEntity;
import com.br.fabiokoch.webcrawler.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;

@Service
@Slf4j
public class CrawlerProductService {
    private final HashSet<String> links;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ParameterValues parameterValues;

    public CrawlerProductService() {
        links = new HashSet<>();
    }

    //método que irpa buscar os links e gerar as informações de produtos
    public void getPageLinks(String URL) {
        if (!links.contains(URL)) {
            try {
                Document document = Jsoup.connect(URL).get();
                Elements filterLinks = document.select(parameterValues.getFilterLink());

                for (Element page : filterLinks) {
                    if (links.add(URL)) {
                        log.info("CrawlerProductService.getPageLinks, URL:{}", URL);
                    }
                    getPageLinks(page.attr("abs:href"));
                    getProductsCrawler();
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

    //Método que irá capturar as informações encontradas e perisistir no banco de dados
    public void getProductsCrawler() {
        links.forEach(x -> {
            Document document;
            try {
                document = Jsoup.connect(x).get();
                Elements articleLinks = document.select(parameterValues.getProductsClass());
                for (Element article : articleLinks) {
                    Elements productPrice = article.select(parameterValues.getPriceClass());
                    Elements productName = article.select(parameterValues.getNameClass());

                    ProductEntity nameProduct = productRepository.findByNome(productName.text());
                    if (nameProduct == null) {
                        persistProductEntity(productPrice, productName);
                    }
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        });
    }

    private void persistProductEntity(Elements productPrice, Elements productName) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setNome(productName.text());
        productEntity.setPreco(productPrice.text());
        productRepository.save(productEntity);
        log.info("FindProductService.getProductInfo, Find new product: {}", productEntity);
    }
}
