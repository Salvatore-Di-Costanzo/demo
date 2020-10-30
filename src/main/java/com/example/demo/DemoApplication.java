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
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.Map;


public class DemoApplication {


	public static void main(String[] args)
	{
		UpdownUtil util = new UpdownUtil();
		util.upload();
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

			PreservationConfiguration preservationConfiguration = (PreservationConfiguration) jaxbUnmarshaller.unmarshal(xmlFile);

			System.out.println("-------------------------------------------------------");

			System.out.println(preservationConfiguration.getMaxPDVDocs());
			System.out.println(preservationConfiguration.getMaxPDVSize());

			System.out.println("_------------------------------------------------------");

			System.out.println("Mappa contiene:");
			Map<String,Integer> variables = preservationConfiguration.getMap();
			System.out.println(variables.entrySet());

			Allegati allegati = new Allegati();
			allegati.getAttach(preservationConfiguration);

		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		}
	}

}



