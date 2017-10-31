package com.example.uusinjakso;
import java.util.Scanner;
/**
 *
 * @author jukkatuomi
 */
public class KayttoLiittyma {
    private Scanner lukija;
    private Sarjat lista;
    private URLyhteys yhteys;
    private String nimi;

    public KayttoLiittyma(Scanner lukija){
        this.lista = new Sarjat();
        this.yhteys  = new URLyhteys();
        this.lukija = lukija;
    }
    public void aja() throws Exception{
        while(true){
            System.out.println("1 - liää sarja \n" +
                    "2 - listaa sarjat \n " +
                    "3 - lopeta");
            int valinta = Integer.parseInt(lukija.nextLine());
            if(valinta == 3){
                break;
            }
            valinnat(valinta);
        }
    }
    public void valinnat(int valinta) throws Exception{
        if(valinta == 1){
            lisaaSarja();
        }
        if(valinta == 2){
            listaa();
        }
        if(valinta == 3){

        }
    }
    public void lisaaSarja() throws Exception{
        System.out.print("Mikä sarja? ");
        this.nimi = lukija.nextLine();
        String yhteys2 = yhteys.haeSarja(this.nimi);
        yhteys.haeUusin(yhteys2);
        lista.lisaaSarja(this.nimi, yhteys.haeUusin(yhteys2));

    }
    public void listaa(){
        lista.listaaSarjat();
    }
}
