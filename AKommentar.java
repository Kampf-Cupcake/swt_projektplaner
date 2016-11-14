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

    protected Arbeitspaket kommentar;
    protected Mitarbeiter verfasser;

    public AKommentar(String t, GregorianCalendar d) {
        this.text = t;
        this.datum = d;
        this.akommentarNr = -1;
    }

    public String toString() {
        return "Verfasst am " + datum + " von " + verfasser + "\n" + text;   //In UML
    }

    public String getText() {
        return text;
    }

    public GregorianCalendar getDatum() {
        return datum;
    }

    public Arbeitspaket getKommentar() {
        return this.kommentar;
    }

    public Mitarbeiter getVerfasser() {
        return this.verfasser;
    }
}
