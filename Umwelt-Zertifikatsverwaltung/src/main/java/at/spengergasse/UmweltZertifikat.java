package at.spengergasse;

public abstract class UmweltZertifikat {

    private String id;
    private String name;
    private double co2ProJahr;
    private double recyclingQuote;


    public UmweltZertifikat(String id, String name, double co2ProJahr, double recyclingQuote) throws UmweltProjektException {
        setId(id);
        setName(name);
        setCo2ProJahr(co2ProJahr);
        setRecyclingQuote(recyclingQuote);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws UmweltProjektException {
        if (id == null || id.isEmpty()) {
            throw new UmweltProjektException("Fehler: Darf nicht null oder leer sein!");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws UmweltProjektException {
        if (name.isEmpty()) {
            throw new UmweltProjektException("Fehler: Darf nicht leer sein!");
        }
        this.name = name;
    }

    public double getCo2ProJahr() {
        return co2ProJahr;
    }

    public void setCo2ProJahr(double co2ProJahr) throws UmweltProjektException {
        if (co2ProJahr >= 0) {
            throw new UmweltProjektException("Fehler: Darf nicht kleiner als 0 sein");
        }
        this.co2ProJahr = co2ProJahr;
    }

    public double getRecyclingQuote() {
        return recyclingQuote;
    }

    public void setRecyclingQuote(double recyclingQuote) throws UmweltProjektException {
        if (recyclingQuote < 0 || recyclingQuote > 100) {
            throw new UmweltProjektException("Fehler: wert muss zwischen 0 und 100 sein");
        }
        this.recyclingQuote = recyclingQuote;
    }

    public abstract double berechneNachhaltigkeitsScore() throws UmweltProjektException;

    public double berechneCo2Effizienz(double maxErlaubterCO2) {
        return ((maxErlaubterCO2 - co2ProJahr) / maxErlaubterCO2) * 100;
    }

    @Override
    public String toString() {
        return id + '\n' +
                "name: " + name + '\n' +
                "co2ProJahr: " + co2ProJahr + '\n' +
                "recyclingQuote: " + recyclingQuote;
    }
}
