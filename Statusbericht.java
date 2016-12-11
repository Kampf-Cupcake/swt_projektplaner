package swt_projektplaner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.GregorianCalendar;
import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author Jan Beuster
 */
public class Statusbericht {
    private int prozent;        //In UML
    private int statusberichtID;
    private GregorianCalendar datum;
    private List<Arbeitspaket> arbeitspaket = new LinkedList<Arbeitspaket>();
    private Projekt projekt;
    
    public Statusbericht(int pz, GregorianCalendar d, Projekt p){
        this.prozent = pz;
        this.datum = d;
        this.statusberichtID = -1;
        this.projekt = p;
    }
    
    public int getProzent(){
        return prozent;
    }
    public void setProzent(int p){
        this.prozent = p;
    }
    
    public int getStatusberichtId(){
        return statusberichtID;
    }
    public void setStatusberichtId(int id){
        this.statusberichtID = id;
    }
    
   public GregorianCalendar getDatum() {
        return datum;
    }
    public void setDatum(GregorianCalendar d){
        this.datum = d;
    }
    
    public List<Arbeitspaket> getArbeitspaket(){
        return this.arbeitspaket;
    }
    
    public Projekt getProjekt(){
        return this.projekt;
    }
    public void setProjekt(Projekt p){
        this.projekt = p;
    }
    /* Methode steht in der kleinen Verwaltung
    public double berechneStatus(List<Arbeitspaket> Liste){
        int fertig = 0;
        double status;
        Liste = projekt.getArbeitspaket();      // Verbindung zu Arbeitspaket löschen?
        for(int i = 0; i <= Liste.size(); i++){
            if (Liste.get(i).getFertig() ) fertig++; 
        }
        status = (fertig /Liste.size()) * 100 ;
        return status;
        */
        
    }
}
