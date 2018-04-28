/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc319.project;

import java.io.*;
import java.util.ArrayList;


public class Search {
    private int totalCount;
    private ArrayList<String> sentence;

    
    public int getTotalcount() {
        return totalCount;
    }

    public ArrayList<String> getSentence() {
        return sentence;
    }
    
    private void searchKeyWord(String keyWord){
        
    }
    
    private void putKeyword(){
        
    }
    
    private void readTextFile(){
        String FileName = "Input.txt";
        String line = null;
        try {
            FileReader fileReader = new FileReader("Input.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(  "Unable to open file " + "Input.txt" );                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + "input.txt" + "'");     
        }
    }
    
    private void printAllSentence(){
        
    }
    
    
    
    
}
