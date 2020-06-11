package com.cognizant;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	@Autowired
	private CountryService service;

	@GetMapping("/hello")
	public String sayHello() {
		LOGGER.info("Start: sayHello() method");
		String str = service.sayHello();
		LOGGER.info("End: sayHello() method");
		return str;

	}
	
	@GetMapping("/country")
	public Country getCountryIndia()
	{
		LOGGER.info("Start: getCountryIndia()");
		Country country =service.getCountryIndia();
		LOGGER.info("End: getCountryIndia()");
		return country;
	}
	
	@GetMapping("/countries")
	public List<Country> getAllCountries()
	{
		LOGGER.info("Start: getAllCountries()");
		List<Country> allCountries = service.getAllCountries();
		LOGGER.info("End: getAllCountries()");
		return allCountries;
	}
	
	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable("code") String code) throws CountryNotFoundException
	{
		LOGGER.info("Start: getCountry()");
		Country country = service.getCountry(code);
		LOGGER.info("End: getACountry()");
		return country;
	}
	

}
