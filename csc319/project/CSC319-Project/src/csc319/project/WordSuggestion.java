/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc319.project;

import static csc319.project.Main.sc;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.apache.lucene.search.spell.NGramDistance;

import org.apache.lucene.search.spell.PlainTextDictionary;
import org.apache.lucene.search.spell.SpellChecker;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class WordSuggestion {

    private String wordSuggest;

    public WordSuggestion(String keyword) throws IOException {
        Scanner sc = new Scanner(System.in);
        File dir = new File("../CSC319-Project/spellcheck/");

        Directory directory = FSDirectory.open(dir);

        SpellChecker spellChecker = new SpellChecker(directory);

        spellChecker.indexDictionary(
                new PlainTextDictionary(new File("dictionary.txt")));
        String key1 = keyword.toLowerCase();
        String key2 = keyword.toUpperCase();

        if (!spellChecker.exist(key1) && !spellChecker.exist(key2)) {
            int maxSuggest = 5;
            String[] suggest1 = spellChecker.suggestSimilar(key1, maxSuggest);
            String[] suggest2 = spellChecker.suggestSimilar(key2, maxSuggest);
            String[] suggestions = addArrays(suggest1, suggest2);
                    
            if (suggestions != null && suggestions.length > 0) {
                System.out.println("Did you mean....");
                for (int i = 0; i < suggestions.length; i++) {
                    System.out.println((i + 1) + ". " + suggestions[i]);
                }
                System.out.println("Enter 0 if you wish to use the entered keyword or enter the number of the correct word");
                int enter = 0;
                boolean check = false;
                do {
                    System.out.print("Enter a number : ");
                    if (sc.hasNextInt()) {
                        enter = sc.nextInt();
                        if (enter == 0) {
                            setWordSuggest(keyword);
                        } else if (enter <= suggestions.length) {
                            spellChecker.setAccuracy(1);
                            setWordSuggest(suggestions[enter - 1]);
                        } else {
                            System.out.println("Not an option");
                            check = !check;
                        }
                        check = !check;
                    } else {
                        System.out.println("Enter a valid Integer value");
                    }
                    sc.nextLine();
                } while (!check);
            } else {
                System.out.println("No suggestions found for the word : " + keyword);
                setWordSuggest(keyword);
            }

        } else {
            setWordSuggest(keyword);
        }
    }

    public String[] addArrays(String[] first, String[] second) {
        List<String> both = new ArrayList<String>(first.length + second.length);
        Collections.addAll(both, first);
        Collections.addAll(both, second);
        return both.toArray(new String[both.size()]);
    }

    public String getWordSuggest() {
        return wordSuggest;
    }

    public void setWordSuggest(String wordSuggest) {
        this.wordSuggest = wordSuggest;
    }

}
