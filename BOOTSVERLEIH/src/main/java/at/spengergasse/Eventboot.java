package at.spengergasse;

public class Eventboot extends Boot {
    private double preisPauschal;

    public Eventboot(int maxPersonen, String bezeichnung, double preisPauschal) throws BootException {
        super(maxPersonen, bezeichnung);
        this.preisPauschal = preisPauschal;
    }


    public double getPreisPauschal() {
        return preisPauschal;
    }

    public void setPreisPauschal(double preisPauschal) throws BootException {
        if (preisPauschal < 0.0) {
            throw new BootException("Fehler: Muss positiv sein");
        }
        this.preisPauschal = preisPauschal;
    }

    @Override
    public double preis() {
        return preisPauschal;
    }

    @Override
    public String toString() {
        return "Eventboot{" + super.toString() +
                "preisPauschal=" + preisPauschal;
    }
}
