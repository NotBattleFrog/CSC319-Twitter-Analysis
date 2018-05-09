/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc319.project;

import static csc319.project.Main.sc;
import java.io.File;
import java.io.IOException;
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
        File dir = new File("C:/Users/Tiger/Documents/NetBeansProjects/CSC319-Project/spellcheck/");

        Directory directory = FSDirectory.open(dir);

        SpellChecker spellChecker = new SpellChecker(directory);

        spellChecker.indexDictionary(
                new PlainTextDictionary(new File("dictionary.txt")));
        if (!spellChecker.exist(keyword)) {

            int maxSuggest = 5;

            String[] suggestions = spellChecker.
                    suggestSimilar(keyword, maxSuggest);

            if (suggestions != null && suggestions.length > 0) {
                System.out.println("Did you mean....");
                for (int i = 1; i < suggestions.length; i++) {

                    System.out.println(i + ". " + suggestions[i]);
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
                        } else {
                            setWordSuggest(suggestions[enter]);
                        }
                        check = true;
                    }
                } while (!check);
            } else {
                System.out.println("No suggestions found for the word:" + keyword);
                setWordSuggest(keyword);
            }

        }
    }

    public String getWordSuggest() {
        return wordSuggest;
    }

    public void setWordSuggest(String wordSuggest) {
        this.wordSuggest = wordSuggest;
    }

}
