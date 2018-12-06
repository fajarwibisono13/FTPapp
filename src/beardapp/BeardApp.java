

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beardapp;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import sun.net.ftp.FtpClient;

/**
 *
 * @author ITOperations
 */
public class BeardApp {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String serverAddress = "ftp.raharja-net.co.id"; 
        int port =21;
        String username ="fajar";
        String password = "f4jar0101";
        
        FTPClient fTPClient = new FTPClient();
         
        try {
            fTPClient.connect(serverAddress, port);
            fTPClient.login(username, password);
            fTPClient.enterLocalPassiveMode();
            fTPClient.setFileType(FTP.BINARY_FILE_TYPE/FTP.ASCII_FILE_TYPE);
           String remoteFilePath = "/mitracomm2/201811/20181127/2000_PDAM_KOTA_SOLO_20181127.ftr";
            File localfile = new File("D:/FTP/2000_PDAM_KOTA_SOLO_20181127.ftr");
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(localfile));
            boolean success = fTPClient.retrieveFile(remoteFilePath, outputStream);
            outputStream.close();
  
            if (success) {
                System.out.println("Ftp file successfully download.");
            }
            
            
        } catch (Exception e) {
            System.out.println("Error occurs in downloading files from ftp Server : " + e.getMessage());
        }
         finally{
            try {
                 if (fTPClient.isConnected()){
                        fTPClient.logout();
                        fTPClient.disconnect();
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
                   
        }
        
        
        // TODO code application logic here
    }
    
}
