package com.example.uusinjakso;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.MalformedURLException;


public class URLyhteys {
    private String url;
    private String inputLine;
    private TekstinKasittely teksinKasittely;

    public URLyhteys(){
        this.url = "http://api.tvmaze.com/singlesearch/shows?q=";
        this.inputLine = "";
        this.teksinKasittely = new TekstinKasittely();
    }
    public String haeSarja(String syote){
        try {
            URL url = new URL(this.url + syote);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));


            String URLne = "";

            while ((inputLine = in.readLine()) != null)
                URLne = inputLine.substring(inputLine.indexOf("previousepisode\":{\"href\":\"") + 26, inputLine.indexOf("previousepisode\":{\"href\":\"") + 64);
            return this.teksinKasittely.muokkaaURL(URLne);

        }catch(Exception e){
            return (e.toString());
        }
    }

    public String haeUusin(String URLsarja){
        try {
            URL sarja = new URL(URLsarja);
            BufferedReader in2 = new BufferedReader(new InputStreamReader(sarja.openStream()));

            String uusiJakso = "";

            while ((inputLine = in2.readLine()) != null)
                uusiJakso = inputLine.substring(inputLine.indexOf("season"), inputLine.indexOf("season") + 45);


            return this.teksinKasittely.muokkaaJakso(uusiJakso);
        }catch(Exception e){
            return e.toString();
        }
    }

}


