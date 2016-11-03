import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author Kampf-Kuchen
 */
public class Mitarbeiter {
    private String name;
    private String vorname;
    private int personalNr;
    private String rang;
    private String benutzname;
    private String passwort;
    
    //public BenutzerVerwaltung benverw;
    
    public List<PKommentar> kommentar = new LinkedList<PKommentar>();
    public List<Notiz> notiz = new LinkedList<Notiz>();
    
    public List<Arbeitspaket> geleiteteArbeitspakete = new LinkedList<Arbeitspaket>();
    public List<Arbeitspaket> arbeitspaket = new LinkedList<Arbeitspaket>();
    
    public List<Projekt> geleiteteProjekte = new LinkedList<Projekt>();
    public List<Projekt> projekt = new LinkedList<Projekt>();
    
    public Mitarbeiter(String n, String vn, int pNr, String r, String bn, String p){
        this.name = n;
        this.vorname = vn;
        this.personalNr = pNr;
        this.rang = r;
        this.benutzname = bn;
        this.passwort = p;
    } 
    
    public String toString(){       //UML
        return "Name: "+name+" "+vorname+" ("+personalNr+")";
    }
    
    public void setzKommentar(PKommentar k){    //String oder void?? Wenn void, dann UML ändern-in UML geändert EM
        kommentar.add(k);
      }
    
    public void setzNotiz(Notiz n){             //in UML geändert EM
        notiz.add(n);
    }
    
}
