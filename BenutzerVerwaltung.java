package swt_projektplaner;

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
public class BenutzerVerwaltung {
    
    protected List<Mitarbeiter> mitarbeiter = new LinkedList<>();
    
    public void erstelleProfil(String name, String vorname, String passwort, String Rang){
       

      //  mitarbeiter.add( new Mitarbeiter(name, vorname, 3, Rang, vorname + name, passwort));

        //mitarbeiter.add( new Mitarbeiter(name, vorname, 3, Rang, vorname + name, passwort));

        System.out.println(mitarbeiter);    //Test
        
    }
    
    public void aendereRang(){
        
    }
    
   //public void aendereBenutzername(){     //Fällt möglicherweise weg
        
    //}
    
    public void aenderePasswort(String passwort){
        
    }
    
    public void aendereName(){
        
    }
    
    public List<Mitarbeiter> getMitarbeiter(){
        return this.mitarbeiter;
    }

}
