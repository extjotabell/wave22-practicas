package com.mercadolibre.bootcamp_demo_java_app.api.services;

import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyConversionDTO;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyEnum;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemDTO;
import com.mercadolibre.restclient.Response;
import com.mercadolibre.restclient.RestClient;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Service
public class CurrencyApiService extends RestClientService{

  @Value("${meli.base.url}")
  private String baseUrl;

  private RestClient currencyApiClient;

  public CurrencyApiService() throws IOException{
    super();
  }

  @PostConstruct //No recuerdo haber visto esto
  public void init() throws IOException {
    currencyApiClient = RestClient.builder()
        .withPool(restPool)
        .build();
  }

  public CurrencyConversionDTO getExchangeRate(CurrencyEnum localCurrency, CurrencyEnum exchangedCurrency) throws ParseException, RestException{
    Response response = currencyApiClient.get(baseUrl + "/currency_conversions/search?from=" + localCurrency + "&to=" + exchangedCurrency);
    return response.getData(CurrencyConversionDTO.class);
  }

}
