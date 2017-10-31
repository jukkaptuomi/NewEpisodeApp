package com.example.uusinjakso;


public class Sarja {
    private String nimi;
    private String uusinJakso;


    public Sarja(String nimi,String uusinJakso){
        this.nimi = nimi;
        this.uusinJakso = uusinJakso;
    }
    public String haeJakso(){
        return this.uusinJakso;
    }
    @Override
    public String toString(){
        return this.nimi + "  uusin jakso: " + this.uusinJakso;
    }


}