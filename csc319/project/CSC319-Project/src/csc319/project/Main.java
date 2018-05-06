/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc319.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Tiger
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static Map history = new HashMap<String, Integer>();

    public static void main(String[] args) {

    }

    public static void update(String sentence, int total) {
        history.put(sentence, total);
    }

}
