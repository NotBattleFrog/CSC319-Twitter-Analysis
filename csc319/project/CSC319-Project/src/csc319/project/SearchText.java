/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc319.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class SearchText extends Search {

    private File file;

    public void search(String keyword) {
        this.keyword = keyword;
        FileChooserV1 fc = new FileChooserV1();
        fc.choose();
        File chosen = fc.getFile();
        int count = 0;
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(chosen));
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(keyword)) {
                    count++;
                    System.out.println(count + ". " + line);
                    searched.add(line);
                }
            }
            totalCount = count;
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println("Error reading file");
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

}
