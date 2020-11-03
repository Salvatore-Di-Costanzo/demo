package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.PreservationConfiguration;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;

class AllegatiTest {

    private Allegati allegatiUnderTest;

    @BeforeEach
    void setUp() {
        allegatiUnderTest = new Allegati();
        allegatiUnderTest.allegatiMetadatiSystems = Arrays.asList(new AllegatiMetadatiSystem("name", "field"));
        allegatiUnderTest.documentiMetadatiSystem = mock(DocumentiMetadatiSystem.class);
        allegatiUnderTest.allegatiMetadatiCustoms = Arrays.asList(new AllegatiMetadatiCustom("name", "field"));
        allegatiUnderTest.documentiMetadatiCustoms = Arrays.asList(new DocumentiMetadatiCustom("name", "field"));
    }

    @Test
    void testGetAllegati() {
        // Setup
        final List<Allegati> allegati = Arrays.asList(new Allegati());

        // Run the test
        final String result = allegatiUnderTest.getAllegati(allegati);

        // Verify the results
        Assert.assertNotNull(result);
        Assert.assertEquals("Mappa metadati Contiene:\n"+
                "null\n" +
                "0\n"+
                "null\n"+
                "null\n"+
                "--------------------------------------------------------------------\n",result);
    }

    @Test
    void testAllegatiList() {
        // Setup
        final PreservationConfiguration preservationConfiguration = new PreservationConfiguration();
        preservationConfiguration.setMaxPDVSize(0);
        preservationConfiguration.setMaxPDVDocs(0);
        final PreservationConfiguration.ClassiDocumentali value = new PreservationConfiguration.ClassiDocumentali();
        final PreservationConfiguration.ClassiDocumentali.ClasseDocumentale classeDocumentale = new PreservationConfiguration.ClassiDocumentali.ClasseDocumentale();
        classeDocumentale.setId("value");
        classeDocumentale.setTerminiConservazione(0);
        final PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings value1 = new PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings();
        final PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataSystem value2 = new PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataSystem();
        final PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataSystem.DocPrincipale value3 = new PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataSystem.DocPrincipale();
        final PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataSystem.DocPrincipale.Key value4 = new PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataSystem.DocPrincipale.Key();
        value4.setField("value");
        value4.setName("value");
        value4.setValuetype("value");
        value4.setFieldtype("value");
        value4.setMandatoryForPreservation(false);
        value4.setPreservationPurpose((short) 0);
        value3.setKey(value4);
        value2.setDocPrincipale(value3);
        final PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataSystem.Allegati value5 = new PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataSystem.Allegati();
        final PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataSystem.Allegati.Key key = new PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataSystem.Allegati.Key();
        key.setField("value");
        key.setName("value");
        key.setValuetype("value");
        key.setFieldtype("value");
        key.setMandatoryForPreservation((short) 0);
        key.setPreservationPurpose(false);
        value5.getKey().addAll(Arrays.asList(key));
        value2.setAllegati(value5);
        value1.setMetadataSystem(value2);
        final PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataCustom value6 = new PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataCustom();
        final PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataCustom.DocPrincipale value7 = new PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataCustom.DocPrincipale();
        final PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataCustom.DocPrincipale.Key key1 = new PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataCustom.DocPrincipale.Key();
        key1.setField("value");
        key1.setName("value");
        key1.setValuetype("value");
        key1.setFieldtype("value");
        key1.setMandatoryForPreservation(false);
        key1.setPreservationPurpose(false);
        value7.getKey().addAll(Arrays.asList(key1));
        value6.setDocPrincipale(value7);
        final PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataCustom.Allegati value8 = new PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataCustom.Allegati();
        final PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataCustom.Allegati.Key key2 = new PreservationConfiguration.ClassiDocumentali.ClasseDocumentale.Mappings.MetadataCustom.Allegati.Key();
        key2.setField("value");
        key2.setName("value");
        key2.setValuetype("value");
        key2.setFieldtype("value");
        key2.setMandatoryForPreservation(false);
        key2.setPreservationPurpose(false);
        value8.getKey().addAll(Arrays.asList(key2));
        value6.setAllegati(value8);
        value1.setMetadataCustom(value6);
        classeDocumentale.setMappings(value1);
        value.getClasseDocumentale().addAll(Arrays.asList(classeDocumentale));
        preservationConfiguration.setClassiDocumentali(value);

        // Run the test
        final List<Allegati> result = allegatiUnderTest.allegatiList(preservationConfiguration);

        Allegati allegato = new Allegati();

        // Verify the results
        Assert.assertNotNull(result);
        Assert.assertEquals("Mappa metadati Contiene:\n" +
                "value\n" +
                "0\n" +
                "value\n" +
                "value\n" +
                "value\n" +
                "value\n" +
                "value\n" +
                "value\n" +
                "value\n" +
                "value\n" +
                "--------------------------------------------------------------------\n",allegato.getAllegati(result));
    }
}
