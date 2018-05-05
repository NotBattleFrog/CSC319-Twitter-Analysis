/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

public class Search {
    private String keyword;
    private int totalCount;
    //private String consumerkey, consumersecret, accesstoken, accesstokensecret ;
    //private Configuration con;
    private ArrayList<String> searched;

    public Search() {
        this(null);
    }
    
    public Search(String keyword) {
        this.keyword = keyword;
        searched = new ArrayList<String>();
    }
    
   /* public void buildAcc(String consumerkey, String consumersecret, String accesstoken, String accesstokensecret) {
        con = new Configuration(consumerkey, consumersecret, accesstoken, accesstokensecret);
    }*/

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    
    public int getTotalcount() {
        return totalCount;
    }
    
    public void textSearch(File file) throws FileNotFoundException{
        int count =0;
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while((line = bufferedReader.readLine()) != null) {
            if(line.contains(keyword)){
                count++;
                System.out.println(count+". "+line);
                searched.add(line);
            }
            }   
            totalCount =0;
            bufferedReader.close();         
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + "input.txt" + "'");     
        }
    }
    

      public void searchtw4j(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true).setOAuthConsumerKey("").setOAuthConsumerSecret("")
                                .setOAuthAccessToken("").setOAuthAccessTokenSecret("");
        
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter4j.Twitter twitter =  tf.getInstance();
        
           int count =0;
             try {
                 String sentence;
            Query query = new Query(keyword);
            QueryResult result;
            do {
               result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                  for (Status tweet : tweets) { 
                      
               searched.add(". User : "+ tweet.getUser().getScreenName()+ " ---- " + tweet.getText());
                count++;
                }
            } while ((query = result.nextQuery()) != null );
        
        } catch (TwitterException e) {
        }
             totalCount = count;
    }

      
    public void printAllSentence(){
        int count =0;
           Iterator it = searched.iterator();
             while(it.hasNext()){
         count++;
         System.out.println(count+"."+it.next());
     }

    }

        

   
    
    }
        
      
    


