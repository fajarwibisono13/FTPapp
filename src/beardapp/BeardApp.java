

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beardapp;
import com.sun.security.ntlm.Client;
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
                    
		String server = "ftp.raharja-net.co.id";
		int port = 21;
		String user = "fajar";
		String pass = "f4jar0101";
		FTPClient ftpClient = new FTPClient();
		try {

			ftpClient.connect(server, port);
			ftpClient.login(user, pass);
			ftpClient.enterLocalPassiveMode();
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

	        String remoteFile2 = "/mitracomm2/201811/20181127/2000_PDAM_KOTA_SOLO_20181127.ftr";
	        File downloadFile2 = new File("D:/FTP/2000_PDAM_KOTA_SOLO_20181127.ftr");
	        OutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream(downloadFile2));
	        InputStream inputStream = ftpClient.retrieveFileStream(remoteFile2);
                int returnCode = ftpClient.getReplyCode();
                
	        byte[] bytesArray = new byte[4096];
	        int bytesRead = -1;
	        while ((bytesRead = inputStream.read(bytesArray)) != -1) {
	        	outputStream2.write(bytesArray, 0, bytesRead);
	        }

	 
			if (inputStream != null || returnCode != 550) {
                            ftpClient.completePendingCommand();	
                            System.out.println("File nya Udah Ke Download.");
			} 
			outputStream2.close();
			inputStream.close();

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
	}
}
