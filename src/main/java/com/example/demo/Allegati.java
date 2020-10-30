package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import pojo.PreservationConfiguration;

public class Allegati {


    public void getAttach(PreservationConfiguration preservationConfiguration) {

        System.out.println("Mappa metadati Contiene:");
        for (PreservationConfiguration.ClassiDocumentali.ClasseDocumentale lista : preservationConfiguration.getClassiDocumentali().getClasseDocumentale()) {
            System.out.println(lista.getId());
            System.out.println(lista.getTerminiConservazione());
            for (PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataSystem.Allegati.Key key : lista.getMappings().getMetadataSystem().getAllegati().getKey()) {
                System.out.println(key.getField());
                System.out.println(key.getName());
            }

            System.out.println(lista.getMappings().getMetadataSystem().getDocPrincipale().getKey().getField());
            System.out.println(lista.getMappings().getMetadataSystem().getDocPrincipale().getKey().getName());


            for (PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataCustom.Allegati.Key key : lista.getMappings().getMetadataCustom().getAllegati().getKey()) {
                System.out.println(key.getField());
                System.out.println(key.getName());
            }
            for (PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataCustom.DocPrincipale.Key key : lista.getMappings().getMetadataCustom().getDocPrincipale().getKey()) {
                System.out.println(key.getField());
                System.out.println(key.getName());
            }
            System.out.println("--------------------------------------------------------------------");
        }
    }
}
