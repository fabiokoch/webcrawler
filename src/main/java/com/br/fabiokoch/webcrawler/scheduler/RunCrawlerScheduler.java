package com.br.fabiokoch.webcrawler.scheduler;

import com.br.fabiokoch.webcrawler.config.ParameterValues;
import com.br.fabiokoch.webcrawler.services.findproduct.CrawlerProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@Configuration
@Slf4j
public class RunCrawlerScheduler {

    @Autowired
    private CrawlerProductService crawlerProductService;

    @Autowired
    private ParameterValues parameterValues;


    //Scheduler responsável por buscar no link informado, produtos no site
    @Scheduled(cron = "${scheduler-crawler.cron}")
    public void findProductsCrawler(){
        log.info("RunCrawlerScheduler.findProductsCrawler, starting crawler scheduler");
        crawlerProductService.getPageLinks(parameterValues.getUrlCrawler());
    }
}
