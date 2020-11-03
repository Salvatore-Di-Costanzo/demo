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


    /// Stampa allegati
    public String getAllegati(List<Allegati> allegati) {

        StringBuilder stringa = new StringBuilder();


        stringa.append("Mappa metadati Contiene:\n");
        for ( Allegati allegato : allegati ) {
            stringa.append(allegato.getIdDocumento() + "\n");
            stringa.append((allegato.getTerminiConservazioneDocumento() + "\n"));
            for(AllegatiMetadatiSystem allegatoMetadataSystem : allegato.getAllegatiMetadatiSystems()) {
                stringa.append(allegatoMetadataSystem.getName() + "\n");
                stringa.append(allegatoMetadataSystem.getField() + "\n");
            }

            stringa.append(allegato.getDocumentiMetadatiSystem().getName() + "\n");
            stringa.append(allegato.getDocumentiMetadatiSystem().getField() + "\n");



            for (AllegatiMetadatiCustom allegatoMetadatiCustom : allegato.getAllegatiMetadatiCustoms()) {
                stringa.append(allegatoMetadatiCustom.getName() + "\n");
                stringa.append(allegatoMetadatiCustom.getField() + "\n");
            }
            for (DocumentiMetadatiCustom documentoMetadatiCustom : allegato.getDocumentiMetadatiCustoms()) {
                stringa.append(documentoMetadatiCustom.getName() + "\n");
                stringa.append(documentoMetadatiCustom.getField() + "\n");
            }
            stringa.append("--------------------------------------------------------------------\n");

        }

        return stringa.toString();
    }

    public List<Allegati> allegatiList(PreservationConfiguration preservationConfiguration){
        List<Allegati> allegati = new ArrayList<>();

        for (PreservationConfiguration.ClassiDocumentali.ClasseDocumentale lista : preservationConfiguration.getClassiDocumentali().getClasseDocumentale()) {
            Allegati allegato = new Allegati();
            allegato.setIdDocumento(lista.getId());
            allegato.setTerminiConservazioneDocumento(lista.getTerminiConservazione());

            for (PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataSystem.Allegati.Key key : lista.getMappings().getMetadataSystem().getAllegati().getKey())
                allegato.allegatiMetadatiSystems.add(new AllegatiMetadatiSystem(key.getName(),key.getField()));


            allegato.documentiMetadatiSystem.setField(lista.getMappings().getMetadataSystem().getDocPrincipale().getKey().getField());
            allegato.documentiMetadatiSystem.setName(lista.getMappings().getMetadataSystem().getDocPrincipale().getKey().getName());


            for (PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataCustom.Allegati.Key key : lista.getMappings().getMetadataCustom().getAllegati().getKey())
                allegato.allegatiMetadatiCustoms.add(new AllegatiMetadatiCustom(key.getName(),key.getField()));


            for (PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataCustom.DocPrincipale.Key key : lista.getMappings().getMetadataCustom().getDocPrincipale().getKey())
                allegato.documentiMetadatiCustoms.add(new DocumentiMetadatiCustom(key.getName(),key.getField()));


            allegati.add(allegato);
        }


        return allegati;
    }

}
