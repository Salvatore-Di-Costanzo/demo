package com.example.demo;



import pojo.PreservationConfiguration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
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

			System.out.println("-------------------------------------------------------");

			System.out.println("Mappa contiene:");
			Map<String,Integer> variables = preservationConfiguration.getMap();
			System.out.println(variables.entrySet());

			Allegati allegati = new Allegati();

			allegati.getAllegati(allegati.allegatiList(preservationConfiguration));




		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		}
	}

}



