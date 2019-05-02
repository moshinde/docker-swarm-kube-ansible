package com.monica.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monica.microservices.model.CurrencyConversionBean;

public interface CurrencyRepository extends JpaRepository<CurrencyConversionBean, Integer>{

}
