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
    private String tel;
    private String strasse;
    private String hausNr;
    private int plz;
    private String ort;
    private int kundenNr;

    private List<Projekt> projekt = new LinkedList<>();

    public Auftraggeber(String n, String a, String t, String s, String h, int p, String o) {
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
    public void setName(String name){
        this.name = name;
    }

    public String getAnsprechpartner() {
        return ansprechpartner;
    }
    public void setAnsprechpartner(String ap){
        this.ansprechpartner = ap;
    }

    public String getTel() {
        return tel;
    }
    public void setTel(String tel){
        this.tel = tel;
    }

    public String getStrasse() {
        return strasse;
    }
    public void setStrasse(String str){
        this.strasse = str;
    }
    
    public String getHausNr() {
        return hausNr;
    }
    public void setHausNr(String hnr){
        this.hausNr = hnr;
    }

    public int getPlz() {
        return plz;
    }
    public void setPlz(int plz){
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }
    public void setOrt(String o){
        this.ort = o;
    }

    public int getKundenNr(){
        return kundenNr;
    }
    public void setKundenNr(int knr){
        this.kundenNr = knr;
    }
    
    public List<Projekt> getProjekt() {
        return this.projekt;
    }
    public void setProjekt(Projekt p){
        this.projekt.add(p);
    }

}
