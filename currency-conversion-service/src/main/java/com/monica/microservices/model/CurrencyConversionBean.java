package com.monica.microservices.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;

@Entity
public class CurrencyConversionBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fromCurrency;
	private String toCurrency;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal calculatedAmount;
	
	
	public CurrencyConversionBean() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFromCurrency() {
		return fromCurrency;
	}


	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}


	public String getToCurrency() {
		return toCurrency;
	}


	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}


	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}


	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}


	public BigDecimal getQuantity() {
		return quantity;
	}


	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}


	public BigDecimal getCalculatedAmount() {
		return calculatedAmount;
	}


	public void setCalculatedAmount(BigDecimal calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}


	public CurrencyConversionBean(String fromCurrency, String toCurrency, BigDecimal conversionMultiple,
			BigDecimal quantity, BigDecimal calculatedAmount) {
		super();
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.calculatedAmount = calculatedAmount;
	}



}
