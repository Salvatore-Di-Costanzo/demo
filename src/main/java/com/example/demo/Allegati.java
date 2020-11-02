package com.example.demo;

import pojo.PreservationConfiguration;

import java.util.ArrayList;
import java.util.List;

public class Allegati {

    private String idDocumento;
    private int terminiConservazioneDocumento;
    List<AllegatiMetadatiSystem> allegatiMetadatiSystems = new ArrayList<>();
    DocumentiMetadatiSystem documentiMetadatiSystem = new DocumentiMetadatiSystem();
    List<AllegatiMetadatiCustom> allegatiMetadatiCustoms = new ArrayList<>();
    List<DocumentiMetadatiCustom> documentiMetadatiCustoms = new ArrayList<>();


    /// Modifica per andare a prendere e info direttamente dai campi della classe
    public void getAttach(PreservationConfiguration preservationConfiguration) {

        System.out.println("Mappa metadati Contiene:");
        for (PreservationConfiguration.ClassiDocumentali.ClasseDocumentale lista : preservationConfiguration.getClassiDocumentali().getClasseDocumentale()) {
            System.out.println(getIdDocumento());
            System.out.println(getTerminiConservazioneDocumento());
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
            Allegati allegato = new Allegati();
            allegato.setIdDocumento(lista.getId());
            allegato.setTerminiConservazioneDocumento(lista.getTerminiConservazione());
            for (PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataSystem.Allegati.Key key : lista.getMappings().getMetadataSystem().getAllegati().getKey()) {
                allegato.allegatiMetadatiSystems.add(new AllegatiMetadatiSystem(key.getName(),key.getField()));
            }

            allegato.documentiMetadatiSystem.setField(lista.getMappings().getMetadataSystem().getDocPrincipale().getKey().getField());
            allegato.documentiMetadatiSystem.setName(lista.getMappings().getMetadataSystem().getDocPrincipale().getKey().getName());


            for (PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataCustom.Allegati.Key key : lista.getMappings().getMetadataCustom().getAllegati().getKey()) {
                allegato.allegatiMetadatiCustoms.add(new AllegatiMetadatiCustom(key.getName(),key.getField()));
            }

            for (PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataCustom.DocPrincipale.Key key : lista.getMappings().getMetadataCustom().getDocPrincipale().getKey()) {
                allegato.documentiMetadatiCustoms.add(new DocumentiMetadatiCustom(key.getName(),key.getField()));
            }

            allegati.add(allegato);
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

    public List<AllegatiMetadatiSystem> getAllegatiMetadatiSystems() {
        return allegatiMetadatiSystems;
    }

    public void setAllegatiMetadatiSystems(List<AllegatiMetadatiSystem> allegatiMetadatiSystems) {
        this.allegatiMetadatiSystems = allegatiMetadatiSystems;
    }

    public DocumentiMetadatiSystem getDocumentiMetadatiSystem() {
        return documentiMetadatiSystem;
    }

    public void setDocumentiMetadatiSystem(DocumentiMetadatiSystem documentiMetadatiSystem) {
        this.documentiMetadatiSystem = documentiMetadatiSystem;
    }

    public List<AllegatiMetadatiCustom> getAllegatiMetadatiCustoms() {
        return allegatiMetadatiCustoms;
    }

    public void setAllegatiMetadatiCustoms(List<AllegatiMetadatiCustom> allegatiMetadatiCustoms) {
        this.allegatiMetadatiCustoms = allegatiMetadatiCustoms;
    }

    public List<DocumentiMetadatiCustom> getDocumentiMetadatiCustoms() {
        return documentiMetadatiCustoms;
    }

    public void setDocumentiMetadatiCustoms(List<DocumentiMetadatiCustom> documentiMetadatiCustoms) {
        this.documentiMetadatiCustoms = documentiMetadatiCustoms;
    }

    /// Modifica per andare a prendere e info direttamente dai campi della classe
    public void getAllegati(List<Allegati> allegati) {

        System.out.println("Mappa metadati Contiene:");
        for ( Allegati allegato : allegati ) {
            System.out.println(allegato.getIdDocumento());
            System.out.println(allegato.getTerminiConservazioneDocumento());
            for(AllegatiMetadatiSystem allegatoMetadataSystem : allegato.getAllegatiMetadatiSystems()) {
                allegatoMetadataSystem.getName();
                allegatoMetadataSystem.getField();
            }

            System.out.println(allegato.getDocumentiMetadatiSystem().getName());
            System.out.println(allegato.getDocumentiMetadatiSystem().getField());



            for (AllegatiMetadatiCustom allegatoMetadatiCustom : allegato.getAllegatiMetadatiCustoms()) {
                System.out.println(allegatoMetadatiCustom.getName());
                System.out.println(allegatoMetadatiCustom.getField());
            }
            for (DocumentiMetadatiCustom documentoMetadatiCustom : allegato.getDocumentiMetadatiCustoms()) {
                System.out.println(documentoMetadatiCustom.getName());
                System.out.println(documentoMetadatiCustom.getField());
            }
            System.out.println("--------------------------------------------------------------------");
        }
    }






}
