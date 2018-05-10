/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc319.project;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.SavedSearch;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public abstract class Search {

    protected String keyword;
    protected int totalCount;
    protected ArrayList<String> searched;

    public Search() {
        searched = new ArrayList<String>();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getTotalcount() {
        return totalCount;
    }

    public void printAllSentence() {
        int count = 0;
        Iterator it = searched.iterator();
        while (it.hasNext()) {
            count++;
            System.out.println(count + "." + it.next());
        }

    }

    void search(String keyword) {
    }

}
