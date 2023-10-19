package com.mercadolibre.bootcamp_demo_java_app.integration;

import com.mercadolibre.bootcamp_demo_java_app.api.services.CurrencyConversionApiService;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyConversionDTO;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyEnum;
import com.mercadolibre.bootcamp_demo_java_app.util.MockItemUtils;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class CurrencyConversionApiServiceTest extends IntegrationTest {

    @Autowired
    CurrencyConversionApiService currencyConversionApiService;

    @Test
    void testCurrencyConversion() throws RestException, ParseException, URISyntaxException, IOException {
        CurrencyEnum sourceCurrency = CurrencyEnum.UYU;
        MockItemUtils.mockCurrencyConversion(sourceCurrency);
        Double expectedRatio = Double.valueOf("0.02247191");
        CurrencyConversionDTO expectedCurrenctConversion = new CurrencyConversionDTO(expectedRatio, CurrencyEnum.UYU, CurrencyEnum.USD);

        assertEquals(expectedCurrenctConversion, currencyConversionApiService.getCurrencyConversion(sourceCurrency, CurrencyEnum.USD));
    }
}
