package com.mercadolibre.bootcamp_demo_java_app.services;

import com.mercadolibre.bootcamp_demo_java_app.api.services.CurrencyApiService;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyConversionDTO;
import com.mercadolibre.bootcamp_demo_java_app.dtos.CurrencyEnum;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemPriceDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.bootcamp_demo_java_app.api.services.ItemsApiService;
import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemDTO;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;

@Service
public class ItemsService {
	private static final Logger log = LoggerFactory.getLogger(ItemsService.class);
	private ItemsApiService itemsApiService;

	@Autowired
	private CurrencyApiService currencyApiService;
	
	@Autowired
	public ItemsService(ItemsApiService itemsApiService) {
		this.itemsApiService = itemsApiService;
	}
	
	public Double getItemPrice(String itemId) throws ParseException, RestException {
		ItemDTO itemInfo = itemsApiService.getItemInfo(itemId);
		if (log.isDebugEnabled()) {
			log.debug("Item info lookup: {}",itemInfo);
		}
		return itemInfo.getPrice();
	}

	public ItemPriceDTO getItemPriceInUSD(String itemId) throws ParseException, RestException {
		ItemDTO itemInfo = itemsApiService.getItemInfo(itemId);
		CurrencyConversionDTO currencyConversionDTO = currencyApiService.getExchangeRate(itemInfo.getCurrencyId(), CurrencyEnum.USD);

		Double priceInUSD = itemInfo.getPrice() * currencyConversionDTO.getRatio();
		// No se si construir el ItemPriceDTO así es claro. Sino, podría settear cada atributo en una linea, pero creo un objeto incompleto.
		return new ItemPriceDTO(itemInfo.getItemId(), itemInfo.getTitle(), itemInfo.getPrice(), priceInUSD, currencyConversionDTO.getRatio());
	}

}
