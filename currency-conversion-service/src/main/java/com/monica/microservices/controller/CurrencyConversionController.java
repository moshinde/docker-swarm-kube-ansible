package com.monica.microservices.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.monica.microservices.model.CurrencyConversionBean;
import com.monica.microservices.repository.CurrencyRepository;
@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyRepository currencyRepository;
	@Autowired
	private Environment environment;	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) throws IOException {
		
		ResponseEntity<CurrencyConversionBean> responseEntity= new RestTemplate().getForEntity("http://"+environment.getProperty("EXCHANGE_SERVICE_HOST")+":8300/currency-exchange/from/"+from+"/to/"+to, CurrencyConversionBean.class);
		CurrencyConversionBean response = responseEntity.getBody();
		CurrencyConversionBean currency=new CurrencyConversionBean(from, to, response.getConversionMultiple(), quantity, quantity.multiply(response.getConversionMultiple()));
		currencyRepository.save(currency);
		return currency;
	}
	
	@GetMapping("/currency-converter/fromDB")
	public List<CurrencyConversionBean> getFromDB(){
		return currencyRepository.findAll();
	}
	
}