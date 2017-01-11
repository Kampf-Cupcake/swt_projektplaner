package swt_projektplaner;

import java.sql.Date;
import java.util.List;
import java.util.LinkedList;
import java.util.GregorianCalendar;

/**
 *
 * @author Evelyne
 */
public class Projekt {

    private List<Mitarbeiter> mitarbeiter = new LinkedList<>();
    private List<Arbeitspaket> arbeitspakete = new LinkedList<>();
    private List<Auftraggeber> auftraggeber = new LinkedList<>();
    private List<Vorwarnung> vorwarnungen = new LinkedList<>();
    private List<Statusbericht> statusberichte = new LinkedList<>();
    private List<PKommentar> kommentare = new LinkedList<>();

    //private Projektverwaltung pv;
    private String name;
    private String beschreibung;
    private GregorianCalendar deadline;    //UML
    private int projektNr;

    public Projekt(String n, String b, GregorianCalendar dl) {
        this.name = n;
        this.beschreibung = b;
        this.deadline = dl;
        this.projektNr = -1;
    }

    public List<Mitarbeiter> getMitarbeiter() {
        return this.mitarbeiter;
    }
    public void setMitarbeiter(Mitarbeiter ma) {
        this.mitarbeiter.add(ma);
    }
    
    public List<Arbeitspaket> getArbeitspaket() {
        return this.arbeitspakete;
    }

    public List<PKommentar> getKommentar() {
        return this.kommentare;
    }

    public GregorianCalendar getDeadline() {
        return this.deadline;
    }
    public void setDeadline(GregorianCalendar dl){
        this.deadline=dl;
    }
    
    public String getname() {
        return name;
    }
    public void setName(String n){
        this.name=n;
    }
    
    public String getbeschreibung() {
        return beschreibung;
    }
   public void setBeschreibung(String beschreibung){
        this.beschreibung=beschreibung;
    }

   public int getProjektNr() {
        return projektNr;
    }
   public void setProjektNr(int pnr){
        this.projektNr=pnr;
    }
   
   public void addArbeitspaket(Arbeitspaket arbeitspaket){
       arbeitspakete.add(arbeitspaket);
   }
   
   public void setArbeitspakete(List<Arbeitspaket> ap){
       arbeitspakete = ap;
   }
   public void removeArbeitspaket(Arbeitspaket ap){
       arbeitspakete.remove(ap);
   }
    
   public List<Auftraggeber> getAuftraggeber(){
       return this.auftraggeber;
   }
   public void setAuftraggeber(Auftraggeber ag){
       
       this.auftraggeber.add(ag);
       System.out.println(auftraggeber.get(auftraggeber.size()-1));
   }
   
   public List<Statusbericht> getStatusberichte(){
       return statusberichte;
   }
   public void setStatusbericht(Statusbericht sb){
       this.statusberichte.add(sb);
   }
 
}
