/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author Jan Beuster
 */
public class Statusbericht {
    private int prozent;        //In UML-geändert EM
    
    private List<Arbeitspaket> arbeitspaket = new LinkedList<Arbeitspaket>();
    private Projekt projekt;
    
    public Statusbericht(int p){
        this.prozent = p;
    }
    
    public double berechneStatus(List<Arbeitspaket> Liste){
        int fertig = 0;
        double status;
        Liste = projekt.getArbeitspaket();      // Verbindung zu Arbeitspaket löschen?
        for(int i = 0; i <= Liste.size(); i++){
            if (Liste.get(i).getFertig() ) fertig++; 
        }
        status = (fertig /Liste.size()) * 100 ;
        return status;
        
        
    }
}
