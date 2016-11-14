package swt_projektplaner;

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
    
    protected List<PKommentar> kommentar = new LinkedList<>();
    protected List<Notiz> notiz = new LinkedList<>();
    
    protected List<Arbeitspaket> geleiteteArbeitspakete = new LinkedList<>();
    protected List<Arbeitspaket> arbeitspaket = new LinkedList<>();
    
    protected List<Projekt> geleiteteProjekte = new LinkedList<>();
    protected List<Projekt> projekt = new LinkedList<>();
    
    public Mitarbeiter(String n, String vn, String r, String bn, String p){
        this.name = n;
        this.vorname = vn;
        this.personalNr = -1;
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
    
    public String getName(){
        return name;
    }
    
    public String getVorname(){
        return vorname;
    }
    
    public String getRang(){
        return rang;
    }

    public String getBenutzername(){
        return benutzername;
    }
    
    public String getPasswort(){
        return passwort;
    }

    public List<PKommentar> getPKommentar(){
        return this.kommentar;
    }
    
    public List<Notiz> getNotiz(){
        return this.notiz;
    }
    
    public List<Arbeitspaket> getgeleiteteArbeitspakete(){
        return this.geleiteteArbeitspakete;
    }
    
    public List<Arbeitspaket> getArbeitspaket(){
        return this.arbeitspaket;
    }
    
    public List<Projekt> getgeleiteteProjekt(){
        return this.geleiteteProjekte;
    }
    
    public List<Projekt> getProjekt(){
        return this.projekt;
    }
}
