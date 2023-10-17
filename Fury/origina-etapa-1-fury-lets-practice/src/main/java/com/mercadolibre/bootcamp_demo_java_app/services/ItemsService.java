package com.mercadolibre.bootcamp_demo_java_app.services;

import com.mercadolibre.bootcamp_demo_java_app.api.services.ItemsApiService;
import com.mercadolibre.bootcamp_demo_java_app.api.services.PriceConversionApiService;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemDTO;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemUsdDTO;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemsService {
    private static final Logger log = LoggerFactory.getLogger(ItemsService.class);

    private ItemsApiService itemsApiService;

    private PriceConversionApiService priceConversionApiService;

    public Double getItemPrice(String itemId) throws ParseException, RestException {
        ItemDTO itemInfo = itemsApiService.getItemInfo(itemId);
        if (log.isDebugEnabled()) {
            log.debug("Item info lookup: {}", itemInfo);
        }
        return itemInfo.getPrice();
    }

    public ItemUsdDTO getItemUsdDTO(String itemId) throws RestException, ParseException {
        ItemDTO itemInfo = itemsApiService.getItemInfo(itemId);
        Double ratio = priceConversionApiService.getUsdRatio(itemInfo.getCurrencyId());
        return new ItemUsdDTO(itemId, itemInfo.getPrice() * ratio);
    }
}
