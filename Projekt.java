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
        
	public Projekt (String n, String b, GregorianCalendar dl ) {
		this.name = n;
		this.beschreibung = b;
		this.deadline = dl;
                this.projektNr = -1;
	}
	
	public List <Mitarbeiter> getMitarbeiter() {
		return this.mitarbeiter;
	}
	
	public List <Arbeitspaket> getArbeitspaket() {
		return this.arbeitspakete;
	}
        
        public List<PKommentar> getKommentar(){
                return this.kommentare;
        }
        
        public GregorianCalendar getDeadline(){
            return this.deadline;
        }

    public String getname() {
        return name;
    }

    public String getbeschreibung() {
        return beschreibung;
    }

    public GregorianCalendar getdatum() {
        return deadline;
    }

    
}
