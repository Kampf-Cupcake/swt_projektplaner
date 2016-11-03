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
    private String benutzername;      //Benutzername = vorname + name
    private String passwort;
    
    //public BenutzerVerwaltung benverw;
    
    public List<PKommentar> kommentar = new LinkedList<>();
    public List<Notiz> notiz = new LinkedList<>();
    
    public List<Arbeitspaket> geleiteteArbeitspakete = new LinkedList<>();
    public List<Arbeitspaket> arbeitspaket = new LinkedList<>();
    
    public List<Projekt> geleiteteProjekte = new LinkedList<>();
    public List<Projekt> projekt = new LinkedList<>();
    
    public Mitarbeiter(String n, String vn, int pNr, String r, String bn, String p){
        this.name = n;
        this.vorname = vn;
        this.personalNr = pNr;
        this.rang = r;
        this.benutzername = bn;
        this.passwort = p;
    } 
    
    public String toString(){       //UML
        return "Name: "+name+" "+vorname+" ("+personalNr+")";
    }
    
    public void setzKommentar(PKommentar k){    //String oder void?? Wenn void, dann UML ändern
        kommentar.add(k);
      }
    
    public void setzNotiz(Notiz n){
        notiz.add(n);
    }
    
}
