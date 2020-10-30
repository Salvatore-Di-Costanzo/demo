package com.example.demo;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class UpdownUtil {

    // Upload sul server FTP

    public String upload() {
        //Impostazioni server FTP di prova - durata permanenza archivio 30 min
        String server = "ftp.dlptest.com";
        String user = "dlpuser@dlptest.com";
        String pass = "eUj8GeW55SvYaswqUyDSm5v6N";

        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(server);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // Upload usando InputStream
            File LocalFile = new File("C:\\Users\\eiandolo\\Downloads\\commessa.xml");

            String RemoteFile = "commessa.xml";
            InputStream inputStream = new FileInputStream(LocalFile);

            System.out.println("Inizio l'Upload dell'archivio");
            boolean done = ftpClient.storeFile(RemoteFile, inputStream);
            inputStream.close();
            if (done) {
                System.out.println("L'archivio è stato correttamente caricato.");
            }
            return "Upload Terminato";

        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return "Upload Fallito";
    }


    // Download dal server FTP


    public String download() {
        //Impostazioni server FTP di prova - durata permanenza archivio 30 min
        String server = "ftp.dlptest.com";
        String user = "dlpuser@dlptest.com";
        String pass = "eUj8GeW55SvYaswqUyDSm5v6N";

        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect(server);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);


            // APPROACH #1: using retrieveFile(String, OutputStream)
            String remoteFile = "/commessa.xml";
            File downloadFile = new File("C:\\Users\\eiandolo\\Desktop\\download\\commessa.xml");
            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile));
            boolean success = ftpClient.retrieveFile(remoteFile, outputStream1);
            outputStream1.close();

            if (success) {
                System.out.println("File scaricato correttamente");

                return downloadFile.toString();
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return "Download Fallito";
    }


    // Eliminazione dal Server FTP

    public String delete() {

        //Impostazioni server FTP di prova - durata permanenza archivio 30 min
        String server = "ftp.dlptest.com";
        String user = "dlpuser@dlptest.com";
        String pass = "eUj8GeW55SvYaswqUyDSm5v6N";

        FTPClient client = new FTPClient();
        try {

            client.connect(server);

            client.login(user, pass);

            // Setto il nome del file da eliminare sul Server FTP

            String filename = "/Batch class.zip";

            // Eliminazione File

            boolean exist = client.deleteFile(filename);
            client.logout();

            // Norifichiamo all'utente il risultato
            if (exist)
                return "File '" + filename + "' eliminato...";
            else
                return "File '" + filename + "' non esiste...";
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "Eliminazione Fallita";
    }


}