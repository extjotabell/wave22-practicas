package com.mercadolibre.bootcamp_demo_java_app.controller;

import com.mercadolibre.bootcamp_demo_java_app.dtos.ItemPriceDTO;
import com.mercadolibre.bootcamp_demo_java_app.services.ItemsService;
import com.mercadolibre.restclient.exception.ParseException;
import com.mercadolibre.restclient.exception.RestException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemPriceController {
	ItemsService itemsService;
	
	@Autowired
	public ItemPriceController(ItemsService itemsService) {
		this.itemsService = itemsService;
	}

	@GetMapping("/prices/{itemId}")
	public Double getItemPrice(@PathVariable String itemId) throws ParseException, RestException {
		return itemsService.getItemPrice(itemId);
	}

	@GetMapping("/pricesUSD/{itemId}")
	public ResponseEntity<ItemPriceDTO> getItemPriceInUSD(@PathVariable String itemId) throws ParseException, RestException{
		return new ResponseEntity<>(itemsService.getItemPriceInUSD(itemId), HttpStatus.OK);
	}

}
