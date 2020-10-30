package com.example.demo;

import pojo.PreservationConfiguration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.net.MalformedURLException;
import java.net.URL;

public class XmlToJavaObj {


    UpdownUtil updown = new UpdownUtil();
    JAXBContext jaxbContext     = JAXBContext.newInstance( PreservationConfiguration.class );
    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();


    URL url = new URL( updown.download() );

    PreservationConfiguration employee = (PreservationConfiguration) jaxbUnmarshaller.unmarshal( url );

    public XmlToJavaObj() throws JAXBException, MalformedURLException {
    }
}
