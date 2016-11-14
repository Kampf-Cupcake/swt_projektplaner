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

    protected Mitarbeiter leiter;
    protected List<Mitarbeiter> team = new LinkedList<Mitarbeiter>();
    protected ArbeitspaketVerwaltung verwaltung;
    protected Projekt projekt;
    protected List<AKommentar> kommentare = new LinkedList<>();    //In UML

    protected List<Vorwarnung> vorwarnung = new LinkedList<Vorwarnung>();
    protected Statusbericht statusbericht;

    protected List<Arbeitspaket> nachfolgendeArbeitspakete = new LinkedList<Arbeitspaket>();
    protected List<Arbeitspaket> benoetigteArbeitspakete = new LinkedList<Arbeitspaket>();

    public Arbeitspaket(String n, boolean f, String b, GregorianCalendar d) {
        this.name = n;
        this.fertig = f;
        this.beschreibung = b;
        this.deadline = d;
        this.arbeitspaketNr = -1;
    }

    public String getName() {
        return name;
    }

    public boolean getFertig() {
        /* Hinzufügen ins UML Diagramm */
        return fertig;
    }

    public String getBeschreibung(){
        return beschreibung;
    }
    
    public GregorianCalendar getDeadline(){
        return deadline;
    }
    
    public List<Mitarbeiter> getMitarbeiter() {
        return this.team;
    }
    
    public Mitarbeiter getLeiter(){
        return this.leiter;
    }
    
    public ArbeitspaketVerwaltung getVerwaltung(){
        return this.verwaltung;
    }
    
    public Projekt getProjekt(){
        return this.projekt;
    }
    
    public List<AKommentar> getAKommentar(){
        return this.kommentare;
    }
    
    public List<Vorwarnung> getVorwarnung(){
            return this.vorwarnung;
    }
    
    public Statusbericht getStatusbericht(){
        return this.statusbericht;
    }
    
    public List<Arbeitspaket> getnachfolgendeArbeitspakete(){
        return this.nachfolgendeArbeitspakete;
    }
    
    public List<Arbeitspaket> getbenoetigteArbeitspakete(){
        return this.benoetigteArbeitspakete;
    }

}
