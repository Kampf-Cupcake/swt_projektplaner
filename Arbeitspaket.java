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

    public Arbeitspaket(String n, boolean f, String b, GregorianCalendar d, Projekt p) {
        this.name = n;
        this.fertig = f;
        this.beschreibung = b;
        this.deadline = d;
        this.arbeitspaketNr = -1;
        this.projekt = p;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public boolean getFertig() {
        /* Hinzufügen ins UML Diagramm */
        return fertig;
    }
    public void setFertig(boolean fertig){
        this.fertig = fertig;
    }
    
    public String getBeschreibung(){
        return beschreibung;
    }
    public void setBeschreibung(String b){
        this.beschreibung = b;
    }
    
    public GregorianCalendar getDeadline(){
        return deadline;
    }
    public void setDeadline(GregorianCalendar dl){
        this.deadline = dl;
    }
    
    public int getArbeitspaketNr(){
        return arbeitspaketNr;
    }
    public void setArbeitspaketNr(int apnr){
        this.arbeitspaketNr = apnr;
    }
    
    public List<Mitarbeiter> getMitarbeiter() {
        return this.team;
    }
    public void setMitarbeiter(Mitarbeiter m){
        this.team.add(m);
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
    public void setProjekt(Projekt p){
        this.projekt=p;
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
