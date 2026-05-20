package at.spengergasse;

public class ProduktZertifikat extends UmweltZertifikat {
    private double materialAnteilRecycelt;
    private int lebensdauerJahre;

    public ProduktZertifikat(String id, String name, double co2ProJahr, double recyclingQuote, double materialAnteilRecycelt, int lebensdauerJahre) throws UmweltProjektException {
        super(id, name, co2ProJahr, recyclingQuote);
        setMaterialAnteilRecycelt(materialAnteilRecycelt);
        setLebensdauerJahre(lebensdauerJahre);
    }

    public double getMaterialAnteilRecycelt() {
        return materialAnteilRecycelt;
    }

    public void setMaterialAnteilRecycelt(double materialAnteilRecycelt) throws UmweltProjektException {
        if (materialAnteilRecycelt < 0 || materialAnteilRecycelt > 100) {
            throw new UmweltProjektException("Fehler: muss zwischen 0 und 100");
        }
        this.materialAnteilRecycelt = materialAnteilRecycelt;
    }

    public int getLebensdauerJahre() {
        return lebensdauerJahre;
    }

    public void setLebensdauerJahre(int lebensdauerJahre) throws UmweltProjektException {
        if (lebensdauerJahre <= 0) {
            throw new UmweltProjektException("Fehler: Muss mehr als 0 sein");
        }
        this.lebensdauerJahre = lebensdauerJahre;
    }

    @Override
    public double berechneNachhaltigkeitsScore() throws UmweltProjektException {
        return (getRecyclingQuote() + materialAnteilRecycelt) - (getCo2ProJahr() / lebensdauerJahre);
    }

    @Override
    public String toString() {
        return "ProduktZertifikat: " + super.toString() +
                "Recycling Anteil ist" + materialAnteilRecycelt + "%" +
                ", lebensdauerJahre ist" + lebensdauerJahre;
    }
}
