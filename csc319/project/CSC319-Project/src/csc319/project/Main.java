/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc319.project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    /**
     * @param args the command line arguments
     */
    private static Map history = new HashMap<String, Integer>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        run();
        /*Search srch = new SearchText();
            srch.search("good");*/
    }

    public static void run() {

        int enter;
        boolean check;
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("------Welcome to Twitter Search Application-----");
        while (true) {

            System.out.println("enter 0 to exit");
            System.out.println("enter 1 to begin searching with Twitter4J");
            System.out.println("enter 2 to begin searching with TextReader");
            System.out.println("enter 3 to Show total counts of each searched keywords");
            enter = 0;
            check = false;
            do {
                System.out.print("Enter a number : ");
                if (sc.hasNextInt()) {
                    enter = sc.nextInt();
                    if (enter >= 4) {
                        System.out.println("Not an option");
                        System.out.println("Please enter 0,1,2,or 3");
                        check = !check;
                    }
                    check = !check;
                } else {
                    System.out.println("Enter a valid Integer value");
                }
                sc.nextLine();
            } while (!check);
            option(enter);

        }

    }

    public static void option(int enter) {
        String keyword = null;
        Search srch;
        WordSuggestion wordSuggest;
        if (enter == 0) {
            System.out.println("Exit.....");
            System.exit(-1);
        } else if (enter == 1 || enter == 2) {
            System.out.print("Please enter a keyword to search : ");

            keyword = sc.nextLine();
            try {
                wordSuggest = new WordSuggestion(keyword);
                keyword = wordSuggest.getWordSuggest();
            } catch (IOException ex) {

            }
            System.out.println("Searching for the word " + keyword + "........");
            srch = searchType(enter);
            srch.search(keyword);
            srch.printAllSentence();
            update(keyword, srch.getTotalcount());

        } else if (enter == 3) {
            System.out.println("----Show total counts of each searched keywords ----");
            showAllHistory();
        }
    }

    public static void update(String sentence, int total) {
        history.put(sentence, total);
    }

    public static void showAllHistory() {
        Set set = history.entrySet();

        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            System.out.println("Keyword : " + entry.getKey() + " | Total tweets : " + entry.getValue());
        }
    }

    public static Search searchType(int enter) {
        if (enter == 1) {
            System.out.println("----Search with Twitter4J----");
            return new SearchT4J();
        } else if (enter == 2) {
            System.out.println("----Search with TextReader----");
            return new SearchText();
        }
        return null;
    }

}
