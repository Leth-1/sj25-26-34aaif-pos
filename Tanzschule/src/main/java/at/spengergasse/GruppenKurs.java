package at.spengergasse;

public class GruppenKurs extends Kurs {
    private double preisPauschal;

    public GruppenKurs(int dauer, double preisPauschal) throws TanzschuleException {
        super(dauer);
        setPreisPauschal(preisPauschal);
    }

    public GruppenKurs(String[] linePart) throws TanzschuleException {

        super(linePart);
        try {
            setPreisPauschal(Double.parseDouble(linePart[2]));
        } catch (TanzschuleException e) {
            throw new TanzschuleException("Fehler..");
        } catch (NumberFormatException e) {
            throw new TanzschuleException("Fehler");
        }
    }

    public double getPreisPauschal() {
        return preisPauschal;
    }

    public void setPreisPauschal(double preisPauschal) throws TanzschuleException {
        if (preisPauschal < 0.0) {
            throw new TanzschuleException("Fehler: Weniger als 0 darf nicht sein!");
        }
    }

    @Override
    public double preis() {
        return preisPauschal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GruppenKurs that = (GruppenKurs) o;
        return Double.compare(preisPauschal, that.preisPauschal) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Double.hashCode(preisPauschal);
        return result;
    }

    public String toCSVString() {
        String delimiter = ";";
        return super.toCSVString() + delimiter + preisPauschal + delimiter;
    }

    @Override
    public String toString() {
        return "GruppenKurs:" + super.toString() +
                "preisPauschal: " + preisPauschal;
    }
}
