package com.example.uusinjakso;


import java.util.*;


public class Sarjat{
    private ArrayList<Sarja> lista;
    private Sarja sarja;

    public Sarjat(){
        ArrayList<Sarja> sarjat = new ArrayList();
        this.lista = sarjat;
    }
    public void lisaaSarja(String nimi, String uusinJakso){
        this.lista.add(new Sarja(nimi,uusinJakso));
    }
    @Override
    public  String toString(){
        String tuloste = "";

        if(this.lista.isEmpty()){
            return " tyhjä";
        }
        if(lista.size() == 1 ){
            return lista.get(0).toString();
        }
        for (int i = 1; i < lista.size(); i++) {
            tuloste = tuloste + ", " + lista.get(i);
        }
//
        return tuloste;
    }
    public void listaaSarjat(){
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }
}

