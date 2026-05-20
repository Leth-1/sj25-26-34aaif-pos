package at.spengergasse;

public abstract class Vertrag {

    private double summe;

    public Vertrag(double summe) throws VersicherungsException {
        setSumme(summe);
    }

    public double getSumme() {
        return summe;
    }

    public void setSumme(double summe) throws VersicherungsException {
        if (summe <= 0.0) {
            throw new VersicherungsException("Fehler: ");
        }
        this.summe = summe;
    }

    public abstract double berechnePreis();


    @Override
    public String toString() {
        return "Vertrag: " +
                "summe: " + summe + '\n' +
                "Preis" + berechnePreis();
    }
}
