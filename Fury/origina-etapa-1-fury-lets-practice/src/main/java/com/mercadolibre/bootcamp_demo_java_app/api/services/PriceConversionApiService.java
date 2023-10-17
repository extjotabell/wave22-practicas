package com.mercadolibre.bootcamp_demo_java_app.api.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyEnum;
import com.mercadolibre.restclient.Response;
import com.mercadolibre.restclient.RestClient;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class PriceConversionApiService extends RestClientService {

    @Value("${meli.base.url}")
    private String baseUrl;

    private String priceConversionApiBaseUrl;

    private RestClient priceConversionApiClient;

    public PriceConversionApiService() throws IOException {
        super();
    }

    @PostConstruct
    public void init() throws IOException {
        priceConversionApiBaseUrl = String.format("%s/currency_conversions", baseUrl);
        priceConversionApiClient = RestClient.builder()
                .withPool(restPool)
                .build();
    }

    public Double getUsdRatio(CurrencyEnum from) throws ParseException, RestException {
        String currentItemUrl = String.format("%s/search?from=%s&to=%s", priceConversionApiBaseUrl, from, CurrencyEnum.USD);
        Response resp = priceConversionApiClient.get(currentItemUrl);
        JsonNode response = resp.getData(JsonNode.class);
        return response.get("ratio").asDouble();
    }

}
