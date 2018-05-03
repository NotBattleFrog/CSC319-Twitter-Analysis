/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.project;

import twitter4j.*;
import java.util.ArrayList;
import java.util.List;

public class Search {

    private int totalCount;
    private ArrayList<String> sentence;

    private void searchKeyword() throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query("source:twitter4j yusukey");
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }
    }

    public int getTotalcount() {
        return totalCount;
    }

    public ArrayList<String> getSentence() {
        return sentence;
    }

    private void putKeyword() {

    }

    private void readTextFile() {

    }

    private void printAllSentence() {

    }

}
