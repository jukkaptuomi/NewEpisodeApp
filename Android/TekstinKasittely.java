package com.example.uusinjakso;


public class TekstinKasittely {

    public TekstinKasittely(){

    }
    public String muokkaaURL(String url){
        char c = url.charAt(url.length() -2);
        boolean isDigit = (c >= '0' && c <= '9');

        if(!isDigit){
            url = url.substring(0, url.length() -2);
        }
        c = url.charAt(url.length() -1);
        isDigit = (c >= '0' && c <= '9');
        if(!isDigit){
            url = url.substring(0, url.length() -1);
        }
        return url;
    }
    public String muokkaaJakso(String url){
        String kausi = "s" + vainNumerot(url.substring(8, 10));
        String jakso = "e" + vainNumerot(url.substring(18, 22));
        String julkaisu = vainNumerot(url.substring(32, 44));
        julkaisu = julkaisu.substring(6)+"."+julkaisu.substring(4,6)+"." + julkaisu.substring(0,4);

        return  kausi + jakso +",  "+ julkaisu;
    }
    private String vainNumerot(String teksti){
        String tuloste = "";
        for (int i = 0; i < teksti.length(); i++) {
            char c = teksti.charAt(i);
            if(c >= '0' && c <= '9'){
                tuloste = tuloste + c;
                if(tuloste.length() == 4 && tuloste.length() == 6 && tuloste.length() == 8){
                    tuloste = tuloste + ".";
                }
            }

        }

        return tuloste;
    }
    private String kaanto(String julkaisu){
        // 0000 00 00
        String vuosi = "";
        String kuukausi = "";
        String paiva = "";

        for (int j = 0; j < julkaisu.length(); j++){
            if(j< 4){
                vuosi = vuosi + julkaisu.charAt(j);
            }
            if(j>3 && j<6 ){
                kuukausi = kuukausi + julkaisu.charAt(j);
            }if(j> 5){
                paiva = paiva + julkaisu.charAt(j);

            }
        }
        return paiva+"."+kuukausi+"."+vuosi;
    }

}
