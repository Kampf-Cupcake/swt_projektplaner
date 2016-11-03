
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
public class AKommentar {               //In UML-eingetragen EM
     private String text;
    private GregorianCalendar datum;        //In UML-eingetragen EM
    
    protected Arbeitspaket kommentar;
    protected Mitarbeiter verfasser;
    
    public AKommentar (String t, GregorianCalendar d){
        this.text = t;
        this.datum = d;
    }
    
    public String toString(){
        return "Verfasst am "+datum+" von "+verfasser+ "\n"+text;   //In UML-eingetragen EM
    }
}
