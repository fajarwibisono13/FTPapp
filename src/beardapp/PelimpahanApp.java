/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beardapp;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import javax.swing.JOptionPane;

/**
 *
 * @author ITOperations
 */
public class PelimpahanApp extends javax.swing.JFrame {
    
    String bulan;
    String tanggal;
    String lengkap = bulan + tanggal;
    
    
    public void download(){
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
                        
                        
                //PDAM DUMMY  
                 /*   String remoteFile2 = ("/mitracomm2/" + bulan +"/"+ tanggal +"/2000_PDAM_KOTA_SOLO_" + tanggal + ".ftr");
                     File downloadFile2 = new File("D:/FTP/2000_PDAM_KOTA_SOLO_20181127.ftr");
                     OutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream(downloadFile2));
                     InputStream inputStream = ftpClient.retrieveFileStream(remoteFile2);
                     
                int returnCode = ftpClient.getReplyCode();
                byte[] bytesArray = new byte[4096];
	        int bytesRead = -1;
	        while ((bytesRead = inputStream.read(bytesArray)) != -1) {
	       outputStream2.write(bytesArray, 0, bytesRead);
	        }if (inputStream != null || returnCode != 550) {
                            ftpClient.completePendingCommand();	
                            System.out.println("Dummy udahke download");
                           // JOptionPane.showMessageDialog(null, "File nya Udah Ke Download.");
                            
			} 
			outputStream2.close();
			inputStream.close();
                */
//----------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------
                        
                        
                
                //PDAM PALYJA
                    String remotePalyja = ("/mitracomm/BRI_SYARIAH/" + bulan +"/RAHARJA_PALYJA_" + tanggal + ".txt");
                    File downloadPalyja= new File("D:/FTP/RAHARJA_PALYJA_"+ tanggal + ".txt");
                    OutputStream outputStreamPalyja = new BufferedOutputStream(new FileOutputStream(downloadPalyja));
                    InputStream inputStreamPalyja = ftpClient.retrieveFileStream(remotePalyja);
            
                     int returnCodePalyja = ftpClient.getReplyCode();
                     byte[] bytesArrayPalyja = new byte[1];
                     int bytesReadPalyja = -1;
                     while ((bytesReadPalyja = inputStreamPalyja.read(bytesArrayPalyja)) != -1) {
                     outputStreamPalyja.write(bytesArrayPalyja, 0, bytesReadPalyja);
	        }
			if (inputStreamPalyja != null || returnCodePalyja != 550) {
                            ftpClient.completePendingCommand();	
                            System.out.println("Palyja Udah Ke Download.");
			} 
                        else{ System.out.println("Palyja Ga ada.");
                        }
			outputStreamPalyja.close();
			inputStreamPalyja.close();
                        
                        
//----------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------




                //PDAM AETRA
                    String remoteAetra = ("/mitracomm/BRI_SYARIAH/" + bulan +"/RAHARJA_AETRA_" + tanggal + ".txt");
                    File downloadAetra= new File("D:/FTP/RAHARJA_AETRA_"+ tanggal + ".txt");
                    OutputStream outputStreamAetra = new BufferedOutputStream(new FileOutputStream(downloadAetra));
                    InputStream inputStreamAetra = ftpClient.retrieveFileStream(remoteAetra);
            
                     int returnCodeAetra = ftpClient.getReplyCode();
                     byte[] bytesArrayAetra = new byte[1];
                     int bytesReadAetra = -1;
                     while ((bytesReadAetra = inputStreamAetra.read(bytesArrayAetra)) != -1) {
                     outputStreamAetra.write(bytesArrayAetra, 0, bytesReadAetra);
	        }
			if (inputStreamAetra != null || returnCodeAetra != 550) {
                            ftpClient.completePendingCommand();	
                            System.out.println("Aetra Udah Ke Download.");
			} 
			outputStreamAetra.close();
			inputStreamAetra.close();
                        
                        
//----------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------
                


                        

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
        
    
   


    /**
     * Creates new form NewJFrame
     */
    public PelimpahanApp() {
        
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unhecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scid = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        tgl = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jumlahPalyja = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PDAM BRIS", "DJI" }));
        scid.setToolTipText("");
        scid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scidActionPerformed(evt);
            }
        });
        scid.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                scidPropertyChange(evt);
            }
        });

        jButton1.setText("Download");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tgl.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglPropertyChange(evt);
            }
        });

        jLabel1.setText("PDAM AETRA");

        jLabel2.setText("PDAM PALYJA");

        jLabel3.setText(":");

        jLabel4.setText(":");

        jLabel5.setText(".....");

        jumlahPalyja.setText(".....");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jumlahPalyja)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scid, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)))
                        .addGap(0, 7, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jumlahPalyja))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tglPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglPropertyChange
        // TODO add your handling code here:
        if (tgl.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
            bulan=format.format(tgl.getDate());
            SimpleDateFormat format2 = new  SimpleDateFormat("yyyyMMdd");
            tanggal = format2.format(tgl.getDate());
            System.out.println(bulan);
            System.out.println(tanggal);
            
        }
        
        /*if (tgl.getDate() != null) {
            SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
            tanggal=format2.format(tgl.getDate());
            System.out.println(tanggal);
            
        }*/
    }//GEN-LAST:event_tglPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        download();
  
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void scidPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_scidPropertyChange
        // TODO add your handling code here:
    String SCID = scid.getSelectedItem().toString();
    
        
      
    }//GEN-LAST:event_scidPropertyChange

    private void scidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scidActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PelimpahanApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PelimpahanApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PelimpahanApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PelimpahanApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PelimpahanApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jumlahPalyja;
    private javax.swing.JComboBox<String> scid;
    private com.toedter.calendar.JDateChooser tgl;
    // End of variables declaration//GEN-END:variables
}
