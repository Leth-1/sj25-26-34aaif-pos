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
        if (mitarbeiter <= 0) {
            throw new UmweltProjektException("Fehler: Mitarbeiter ist kleiner als oder ist 0");
        }
        this.mitarbeiter = mitarbeiter;
    }

    @Override
    public double berechneNachhaltigkeitsScore() throws UmweltProjektException {
        if (mitarbeiter <= 0) {
            throw new UmweltProjektException("Fehler: Mitarbeiter 0 oder kleiner");
        }
        return (getRecyclingQuote() * 1.5) - (getCo2ProJahr() / mitarbeiter);
    }

    @Override
    public String toString() {
        return "Betriebszertifikat" + super.toString() + "\n" +
                mitarbeiter + " Mitarbeiter";

    }
}
