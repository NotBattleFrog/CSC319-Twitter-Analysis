/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc319.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class SearchT4J extends Search {

    private String consumerkey, consumersecret, accesstoken, accesstokensecret;

    public void createCredential() {
        consumerkey = "ur8GJ8VfSdyLqD45DTi3SSCHr";
        consumersecret = "OCYYAjBi5Todbut5755eHlzcdRAwaXbb08mxvixAtzZWZTyOIf";
        accesstoken = "990498015604428800-zWOBer5h1ftu0zz16QN9zKhvPGEFSjW";
        accesstokensecret = "4OdM5lqxqVtr5xd2qPcGKt4zr9Bc6N0TXXhuKhXhf1ZVv";
    }

    public void search(String keyword) {
        this.keyword = keyword;
        createCredential();
        
       ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey(consumerkey).setOAuthConsumerSecret(consumersecret)
                .setOAuthAccessToken(accesstoken).setOAuthAccessTokenSecret(accesstokensecret);
               
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter4j.Twitter twitter = tf.getInstance();
        int count = 0;
        try {
            String sentence;
            Query query = new Query(keyword);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {

                    //System.out.println(count+". User : "+ tweet.getUser().getScreenName()+ " ---- " + tweet.getText());
                    searched.add(". User : " + tweet.getUser().getScreenName() + " ---- " + tweet.getText());
                    count++;
                }
            } while ((query = result.nextQuery()) != null);
            totalCount = count;
            System.out.println("*************************** Search Successful ***************************");
        } catch (TwitterException te) {
        }

    }

}
