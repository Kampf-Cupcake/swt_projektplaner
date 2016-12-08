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
    private String rang;
    private String benutzername;      //Benutzername = vorname + name
    private String passwort;
    private int personalNr;
    //public BenutzerVerwaltung benverw;
    
    private List<PKommentar> kommentar = new LinkedList<>();
    private List<Notiz> notiz = new LinkedList<>();
    
    private List<Arbeitspaket> geleiteteArbeitspakete = new LinkedList<>();
    private List<Arbeitspaket> arbeitspaket = new LinkedList<>();
    
    private List<Projekt> geleiteteProjekte = new LinkedList<>();
    private List<Projekt> projekt = new LinkedList<>();
    
    public Mitarbeiter(String n, String vn, String r, String bn, String p){
        this.name = n;
        this.vorname = vn;
        this.personalNr = -1;
        this.rang = r;
        this.benutzername = bn;
        this.passwort = p;
    } 
    
    public String toString(){       //UML
        return "Name: "+name+" "+vorname+" "+benutzername+"("+personalNr+")";
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
    public void setName(String n){
        this.name = n;
    }
    
    public String getVorname(){
        return vorname;
    }
    public void setVorname(String vn){
        this.vorname = vn;
    }
    
    public String getRang(){
        return rang;
    }
    public void setRang(String r){
        this.rang = r;
    }

   public String getBenutzername(){
        return benutzername;
    }
    public void setBenutzername(String bn){
        this.benutzername = bn;
    }
    
    public String getPasswort(){
        return passwort;
    }
    public void setPasswort(String pw){
        this.passwort = pw;
    }

    public int getPersonalNr(){
        return personalNr;
    }
    public void setPersonalNr(int pnr){
        this.personalNr = pnr;
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
    public void setgeleiteteProjekte(Projekt p){
        this.geleiteteProjekte.add(p);
    }
    
    public List<Projekt> getProjekt(){
        return this.projekt;
    }
    public void setProjekt (Projekt p){
        this.projekt.add(p);
    }
}
