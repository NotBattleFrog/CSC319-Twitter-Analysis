/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc319.project;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Tiger
 */
public class FileChooserV1 {
    private JFileChooser filechooser;
    private File file;
    
     
     public void choose(){
           System.out.print("Choosing a File........");
          filechooser = new JFileChooser();
         FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
          filechooser.setFileFilter(filter);
            //filechooser.setVisible(true);
           filechooser.setCurrentDirectory(new File("C:/Users/Tiger/Desktop"));
           filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
           if(filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                 System.out.println("ok");
            file =filechooser.getSelectedFile();   
             System.out.println("File Successfully retrieved");
             System.out.println("----------------------------");
             System.out.println("File name : "+ file.getName());
             System.out.println("File Path : "+ file.getAbsolutePath());
               System.out.println("----------------------------");
           }
           else{
            System.out.println("Failed to Retrieve the File");
             file = null;
           }
     }


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
}

    


