package com.example.demo;



import pojo.PreservationConfiguration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
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

			System.out.println("-------------------------------------------------------");

			System.out.println("Mappa contiene:\n");
			Map<String,Integer> variables = preservationConfiguration.getMap();
			System.out.println(variables.entrySet());

			Allegati allegatiDoc = new Allegati();

			Map<String, List<Allegati>> allegati = preservationConfiguration.getMapAllegati();


			for ( Map.Entry <String, List<Allegati>> allegato  : allegati.entrySet()){
				List<Allegati> appoggio = allegato.getValue();
				Allegati stamp = new Allegati();
				System.out.println("Chiave = " + allegato.getKey() + ", Valore = \n" + stamp.getAllegati(appoggio));
			}




		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		}
	}

}



