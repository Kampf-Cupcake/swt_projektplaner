package swt_projektplaner;

/**
 *
 * @author beust
 */
import java.util.GregorianCalendar;
import java.util.List;
import java.util.LinkedList;

public class Arbeitspaket {
    private String name;
    private boolean fertig;
    private String beschreibung;
    private GregorianCalendar deadline;
    private int arbeitspaketNr;
    
   private Mitarbeiter leiter;
   private List<Mitarbeiter> team = new LinkedList<Mitarbeiter>();
   private ArbeitspaketVerwaltung verwaltung;
   private Projekt projekt;
   private List<AKommentar> kommentare = new LinkedList<>();    //In UML
   
   private List<Vorwarnung> vorwarnung = new LinkedList<Vorwarnung>();
   private Statusbericht statusbericht;
   
   private List<Arbeitspaket> nachfolgendeArbeitspakete = new LinkedList<Arbeitspaket>();
   private List<Arbeitspaket> benoetigteArbeitspakete = new LinkedList<Arbeitspaket>(); 
   
   public Arbeitspaket(String n, boolean f, String b, GregorianCalendar d, int apnr){
       this.name = n;
       this.fertig = f;
       this.beschreibung = b;
       this.deadline = d;
       this.arbeitspaketNr = apnr;
   }
   public List<Mitarbeiter> getMitarbeiter(){
       return this.team;
   }
    public boolean getFertig(){             /* Hinzufügen ins UML Diagramm */
        return fertig;
    }
}