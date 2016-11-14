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
    
    public List<Projekt> projekt = new LinkedList<>();
    
    
    public Auftraggeber(String n, String a, int t, String s, int h, int p, String o, int k){
        this.name = n;
        this.ansprechpartner = a;
        this.tel = t;
        this.strasse = s;
        this.hausNr = h;
        this.plz = p;
        this.ort = o;
        this.kundenNr = k;
    }
    
    public String toString(){
        return "Auftraggeber: \nName: " + name + "\nAnsprechpartner: " + ansprechpartner + "\nTelefonnummer: " + tel + 
                "\nStrasse: " + strasse + "\nHausnummer: " + hausNr + "\nPostleitzahl: " + plz + "\nOrt: " + ort
                + "\nKundennummer: " + kundenNr;
    }
      
}