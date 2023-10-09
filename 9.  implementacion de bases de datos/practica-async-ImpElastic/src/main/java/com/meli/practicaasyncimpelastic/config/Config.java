package com.meli.practicaasyncimpelastic.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.meli.practicaasyncimpelastic.repository")
public class Config {

    @Bean
    public RestClient client(){
        return RestClient.builder(
                new HttpHost("localHost", 9200))
                .build();
    }
}
