package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.PreservationConfiguration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class DemoApplication {


	public static void main(String[] args)
	{
		UpdownUtil util = new UpdownUtil();
		String fileName = util.download();

		jaxbXmlFileToObject(fileName);
	}

	private static void jaxbXmlFileToObject(String fileName) {

		File xmlFile = new File(fileName);

		JAXBContext jaxbContext;
		try
		{
			jaxbContext = JAXBContext.newInstance(PreservationConfiguration.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			PreservationConfiguration employee = (PreservationConfiguration) jaxbUnmarshaller.unmarshal(xmlFile);

			System.out.println(employee);
		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		}
	}

}



