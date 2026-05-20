package at.spengergasse;

public class BetriebsZertifikat extends UmweltZertifikat {
    private int mitarbeiter;

    public BetriebsZertifikat(String id, String name, double co2ProJahr, double recyclingQuote, int mitarbeiter) throws UmweltProjektException {
        super(id, name, co2ProJahr, recyclingQuote);
        setMitarbeiter(mitarbeiter);
    }

    public int getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(int mitarbeiter) throws UmweltProjektException {
        if (mitarbeiter < 0) {
            throw new UmweltProjektException("Fehler: kleiner als 0");
        }
        this.mitarbeiter = mitarbeiter;
    }

    @Override
    public double berechneNachhaltigkeitsScore() throws UmweltProjektException {
        return (getRecyclingQuote() * 1.5) - (getCo2ProJahr() / mitarbeiter);
    }

    @Override
    public String toString() {
        return "BetriebsZertifikat: " + super.toString() +
                mitarbeiter + "Mitarbeiter";
    }
}
