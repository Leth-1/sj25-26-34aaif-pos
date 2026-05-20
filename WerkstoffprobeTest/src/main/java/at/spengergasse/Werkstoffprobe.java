package at.spengergasse;

import java.util.Locale;

public abstract class Werkstoffprobe {
    private String id;
    private String bezeichnung;
    private double dichte;
    private double masse;

    public Werkstoffprobe(String id, String bezeichnung, double dichte, double masse) throws WerkstoffException {
        setId(id);
        setBezeichnung(bezeichnung);
        setDichte(dichte);
        setMasse(masse);
    }

    public abstract double qualitaetsIndex();


    public String getId() {
        return id;
    }

    public void setId(String id) throws WerkstoffException {
        if (id == null || id.isBlank()) {
            throw new WerkstoffException("Fehler: id ist null oder leer");
        }
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) throws WerkstoffException {
        if (bezeichnung == null || bezeichnung.isBlank()) {
            throw new WerkstoffException("Fehler: bezeichnung ist null oder leer");
        }
        this.bezeichnung = bezeichnung;
    }

    public double getDichte() {
        return dichte;
    }

    public void setDichte(double dichte) throws WerkstoffException {
        if (dichte <= 0.0) {
            throw new WerkstoffException("Fehler: dichte ist 0 oder kleiner");
        }
        this.dichte = dichte;
    }

    public double getMasse() {
        return masse;
    }

    public void setMasse(double masse) throws WerkstoffException {
        if (masse <= 0.0) {
            throw new WerkstoffException("Fehler: masse ist 0 oder kleiner");
        }
        this.masse = masse;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH,
                "ID=%s, Bezeichnung=%s, Dichte=%.2f g/cm3, Masse=%.1f kg",
                id, bezeichnung, dichte, masse);
    }
}
