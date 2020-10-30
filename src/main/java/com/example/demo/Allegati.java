package com.example.demo;

import pojo.PreservationConfiguration;

import java.util.ArrayList;
import java.util.List;

public class Allegati {

    private String idDocumento;
    private int terminiConservazioneDocumento;
    List<AllegatiMetadatiSystem> allegatiMetadatiSystems;
    DocumentiMetadatiSystem documentiMetadatiSystem;
    List<AllegatiMetadatiCustom> allegatiMetadatiCustoms;
    List<DocumentiMetadatiCustom> documentiMetadatiCustoms;

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

    public List<Allegati> allegatiList(PreservationConfiguration preservationConfiguration){
        List<Allegati> allegati = new ArrayList<>();

        for (PreservationConfiguration.ClassiDocumentali.ClasseDocumentale lista : preservationConfiguration.getClassiDocumentali().getClasseDocumentale()) {
            setIdDocumento(lista.getId());
            setTerminiConservazioneDocumento(lista.getTerminiConservazione());
            for (PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataSystem.Allegati.Key key : lista.getMappings().getMetadataSystem().getAllegati().getKey()) {
                AllegatiMetadatiSystem allegatiMetadatiSystem = new AllegatiMetadatiSystem();
                allegatiMetadatiSystem.setField(key.getField());
                allegatiMetadatiSystem.setName(key.getName());
                allegatiMetadatiSystems.add(allegatiMetadatiSystem);
            }

            documentiMetadatiSystem.setField(lista.getMappings().getMetadataSystem().getDocPrincipale().getKey().getField());
            documentiMetadatiSystem.setName(lista.getMappings().getMetadataSystem().getDocPrincipale().getKey().getName());



            for (PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataCustom.Allegati.Key key : lista.getMappings().getMetadataCustom().getAllegati().getKey()) {
                AllegatiMetadatiCustom allegatiMetadatiCustom = new AllegatiMetadatiCustom();
                allegatiMetadatiCustom.setField(key.getField());
                allegatiMetadatiCustom.setName(key.getName());
                allegatiMetadatiCustoms.add(allegatiMetadatiCustom);
            }
            for (PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataCustom.DocPrincipale.Key key : lista.getMappings().getMetadataCustom().getDocPrincipale().getKey()) {
                DocumentiMetadatiCustom documentiMetadatiCustom = new DocumentiMetadatiCustom();
                documentiMetadatiCustom.setField(key.getField());
                documentiMetadatiCustom.setName(key.getName());
                documentiMetadatiCustoms.add(documentiMetadatiCustom);
            }
        }


        return allegati;
    }

    public String getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(String idDocumento) {
        this.idDocumento = idDocumento;
    }

    public int getTerminiConservazioneDocumento() {
        return terminiConservazioneDocumento;
    }

    public void setTerminiConservazioneDocumento(int terminiConservazioneDocumento) {
        this.terminiConservazioneDocumento = terminiConservazioneDocumento;
    }


}
