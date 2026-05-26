package at.spengergasse;

public class Gruppenkurs extends Kurs {

    private double preisPauschal;

    public Gruppenkurs(int dauer, double preisPauschal) throws TanzschuleException {
        super(dauer);
        setPreisPauschal(preisPauschal);
    }

    public Gruppenkurs(String[] linepart) throws TanzschuleException {
        super(linepart);
        try {
            setPreisPauschal(Double.parseDouble(linepart[2]));
        } catch (NumberFormatException e) {
            throw new TanzschuleException("Feh");
        } catch (TanzschuleException e) {
            throw new TanzschuleException("Fehler");
        }
    }

    public double getPreisPauschal() {
        return preisPauschal;
    }

    public void setPreisPauschal(double preisPauschal) throws TanzschuleException {
        if (preisPauschal < 0.0) {
            throw new TanzschuleException("Fe");
        }
        this.preisPauschal = preisPauschal;
    }

    @Override
    public double preis() {
        return preisPauschal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Gruppenkurs that = (Gruppenkurs) o;
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
        return super.ToCSVString() + delimiter + preisPauschal + delimiter;
    }

    @Override
    public String toString() {
        return "Gruppenkurs:" + super.toString() +
                "preisPauschal: " + preisPauschal;
    }
}
