/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc319.project;

import java.io.File;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;


/**
 *
 * @author ROL
 */
public class SpellChecker {
    
    File dir = new File("Desktop:/Directory.txt");
    Directory directory = FSDirectory.open(dir);
    
    
}
