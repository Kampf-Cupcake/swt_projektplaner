package swt_projektplaner;

import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author Fabian
 */
public class Auftraggeber {

    private String name;
    private String ansprechpartner;
    private int tel;
    private String strasse;
    private int hausNr;
    private int plz;
    private String ort;
    private int kundenNr;

    protected List<Projekt> projekt = new LinkedList<>();

    public Auftraggeber(String n, String a, int t, String s, int h, int p, String o) {
        this.name = n;
        this.ansprechpartner = a;
        this.tel = t;
        this.strasse = s;
        this.hausNr = h;
        this.plz = p;
        this.ort = o;
        this.kundenNr = -1;
    }

    public String toString() {
        return "Auftraggeber: \nName: " + name + "\nAnsprechpartner: " + ansprechpartner + "\nTelefonnummer: " + tel
                + "\nStrasse: " + strasse + "\nHausnummer: " + hausNr + "\nPostleitzahl: " + plz + "\nOrt: " + ort
                + "\nKundennummer: " + kundenNr;
    }

    public String getName() {
        return name;
    }

    public String getAnsprechpartner() {
        return ansprechpartner;
    }

    public int getTel() {
        return tel;
    }

    public String getStrasse() {
        return strasse;
    }

    public int getHausNr() {
        return hausNr;
    }

    public int getplz() {
        return plz;
    }

    public String getOrt() {
        return ort;
    }

    public List<Projekt> getProjekt() {
        return this.projekt;
    }

}
