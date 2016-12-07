package swt_projektplaner;

import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author beust
 */
public class AKommentar {               //In UML

    private String text;
    private GregorianCalendar datum;        //In UML
    private int akommentarNr;

    private Arbeitspaket arbeitspaket;
    private Mitarbeiter verfasser;

    public AKommentar (String t, GregorianCalendar d, Mitarbeiter m, Arbeitspaket ap){
        this.text = t;
        this.datum = d;
        this.verfasser = m;
        this.arbeitspaket = ap;
        this.akommentarNr = -1;
    }

    public String toString() {
        return "Verfasst am " + datum + " von " + verfasser + "\n" + text;   //In UML
    }

    public String getText() {
        return text;
    }
    public void setText(String text){
        this.text = text;
    }
    
    public GregorianCalendar getDatum() {
        return datum;
    }
    public void setDatum(GregorianCalendar date){
        this.datum = date;
    }
      
    public int getAKommentarNr (){
        return akommentarNr;
    }    
    public void setAKommentarNr(int id){
        this.akommentarNr = id;
    }
    
    public Arbeitspaket getArbeitspaket() {
        return this.arbeitspaket;
    }  
    public void setArbeitspaket(Arbeitspaket ap){
        this.arbeitspaket = ap;
    }
    
    public Mitarbeiter getVerfasser() {
        return this.verfasser;
    }
    public void setVerfasser(Mitarbeiter m){
        this.verfasser = m;
    }
}
