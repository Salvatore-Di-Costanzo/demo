package com.example.demo;

import pojo.PreservationConfiguration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.net.URL;

public class XmlToJavaObj {

    private static final java.util.logging.Logger log =
            java.util.logging.Logger.getLogger(XmlToJavaObj.class.getName());


    UpdownUtil updown = new UpdownUtil();
    JAXBContext jaxbContext     = JAXBContext.newInstance( PreservationConfiguration.class );
    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();


    URL url = new URL( updown.download() );

    PreservationConfiguration employee = (PreservationConfiguration) jaxbUnmarshaller.unmarshal( url );


    public XmlToJavaObj() throws JAXBException, IOException {
        log.info("");
    }
}
