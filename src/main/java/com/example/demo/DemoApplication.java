package com.example.demo;



import pojo.PreservationConfiguration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;


public class DemoApplication {

	private static final java.util.logging.Logger log =
			java.util.logging.Logger.getLogger(DemoApplication.class.getName());

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

			log.info("-------------------------------------------------------");

			log.info("MaxPDVDocs: " + preservationConfiguration.getMaxPDVDocs());
			log.info("MaxPDVSize: " +preservationConfiguration.getMaxPDVSize());

			log.info("-------------------------------------------------------");

			Map<String,Integer> variables = preservationConfiguration.getMap();
			log.log(Level.SEVERE, () -> "Mappa contiene:\n" + variables.entrySet());



			Map<String, List<Allegati>> allegati = preservationConfiguration.getMapAllegati();


			for ( Map.Entry <String, List<Allegati>> allegato  : allegati.entrySet()){
				List<Allegati> appoggio = allegato.getValue();
				Allegati stamp = new Allegati();
				log.info("Chiave = " + allegato.getKey() + ", Valore = \n" + stamp.getAllegati(appoggio));
			}


		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		}
	}

}



