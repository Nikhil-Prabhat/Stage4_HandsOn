package com.cognizant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		displayDate();
		displayCountryList();
		displayCountry();
		displayCountries();

	}

	public static void displayDate() {
		LOGGER.info("Start");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		try {
			Date date = format.parse("31/12/2018");
			
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LOGGER.info("End");

		
	}
	
	public static void displayCountryList()
	{
		LOGGER.info("Displaying country List");
		ApplicationContext context = new ClassPathXmlApplicationContext("CountryList.xml");
		HashMap<String,String> hashMap = context.getBean("countrydetails",HashMap.class);
		
		for(Map.Entry<String, String> m : hashMap.entrySet())
		{
			LOGGER.info(m.getKey()+": "+m.getValue());
		}
		
		LOGGER.info("End");
		
			
		
	}
	
	
	public static void displayCountry()
	{
		LOGGER.info("In display country method");
		ApplicationContext context = new ClassPathXmlApplicationContext("Country.xml");
		 Country country = context.getBean("country",Country.class);
		 Country anotherCountry = context.getBean("country",Country.class);
		 LOGGER.info("Country:{}" + country.toString());
		 LOGGER.info("End");
	}
	
	public static void displayCountries()
	{
		LOGGER.info("In displayCountries method");
		ApplicationContext context = new ClassPathXmlApplicationContext("Country.xml");
		ArrayList<Country> countriesList = context.getBean("countryList",ArrayList.class);
		
		for(Country country:countriesList)
		{
			LOGGER.info(country+" ");
		}
		
		LOGGER.info("End");
	}

}
