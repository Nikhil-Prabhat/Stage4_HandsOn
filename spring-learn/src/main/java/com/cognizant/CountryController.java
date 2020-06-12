package com.cognizant;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	
	@PostMapping("/countries")
	public Country addCountry(@RequestBody  @Valid Country country)
	{
		LOGGER.info("Start: addCountry");
		
/*		//Create validator factory
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		//Validation is done against the annotations defined in country bean
		Set<ConstraintViolation<Country>> violations = validator.validate(country);
		List<String> errors = new ArrayList<String>();
		
		//Accumulate all errors in an ArrayList of type String
		for(ConstraintViolation<Country> violation: violations)
		{
			errors.add(violation.getMessage());
		}
		
		//Throw an exception so that the  user of this web service receives appropriate error message
		
		if(violations.size() > 0)
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,errors.toString());
		}
	
		*/
		LOGGER.info("End: addCountry");
		return country;
	}
	

}
