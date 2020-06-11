package com.cognizant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

	
	public String sayHello() {
		return "Hello World!";
	}

	public Country getCountryIndia() {

		ApplicationContext context = new ClassPathXmlApplicationContext("Country.xml");
		Country country = context.getBean("country", Country.class);
		return country;

	}
	
	public List<Country> getAllCountries()
	{
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Country.xml");
		ArrayList<Country> countriesList = context.getBean("countryList",ArrayList.class);
		
		return countriesList;
		
	}
	
	public Country getCountry(String code) throws CountryNotFoundException 
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("CountryList.xml");
		HashMap<String,String> hashMap = context.getBean("countrydetails",HashMap.class);
		
		Country country = null;
		
		
		if(hashMap.containsKey(code))
		{
			String name=hashMap.get(code);
			country = new Country(code,name);
		}
		else
		{
			throw new CountryNotFoundException();
		}
		
		return country;
		
	}

}
