package com.cognizant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
	private String code;
	private String name;
	public String getCode() {
		LOGGER.info("Inside country code getter");
		return code;
	}
	public void setCode(String code) {
		this.code = code;
		LOGGER.info("Inside country code setter");
	}
	public String getName() {
		LOGGER.info("Inside country name getter");
		return name;
		
	}
	public void setName(String name) {
		this.name = name;
		LOGGER.info("Inside country name setter");
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	public Country() {
		LOGGER.info("Inside country constructor");
	}
	public Country(String code, String name) {
		super();
		this.code = code;
		this.name = name;
		
		LOGGER.info("Inside country constructor");
	}

	

}
