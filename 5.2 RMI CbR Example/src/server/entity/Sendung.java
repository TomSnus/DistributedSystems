package server.entity;

import java.io.Serializable;
import java.util.Date;

public class Sendung implements Serializable {
    
    private String titel;
    private String beschreibung;
    private Date start = new Date(), ende = new Date();

    public Sendung(String titel, String beschreibung) {
        this.titel = titel;
        this.beschreibung = beschreibung;
    }

    public Sendung() {
        
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnde() {
        return ende;
    }

    public void setEnde(Date ende) {
        this.ende = ende;
    }

    @Override
    public String toString() {
        return "Sendung{" + "titel=" + titel + ", beschreibung=" + beschreibung + '}';
    }
    
    
    
}
