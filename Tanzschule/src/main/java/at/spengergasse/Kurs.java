package at.spengergasse;

public abstract class Kurs implements Comparable<Kurs> {
    int dauer;
    String name;


    public Kurs(int dauer) throws TanzschuleException {
        setDauer(dauer);
    }

    public Kurs(String[] linePart) throws TanzschuleException {
        try {
            setDauer(Integer.parseInt(linePart[1]));
        } catch (TanzschuleException e) {
            throw new TanzschuleException("fehler");
        } catch (NumberFormatException e) {
            throw new TanzschuleException("Fehler:");
        }
    }

    public int getDauer() {
        return dauer;
    }

    public void setDauer(int dauer) throws TanzschuleException {
        if (dauer < 0.0) {
            throw new TanzschuleException("Fehler: darf nicht weniger als 0 sein");
        }
    }

    public abstract double preis();

    @Override
    public int compareTo(Kurs others) {
        return Double.compare(this.preis(), others.preis());
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;

        Kurs kurs = (Kurs) o;
        return dauer == kurs.dauer;
    }

    @Override
    public int hashCode() {
        return dauer;
    }

    public String toCSVString() {
        String delimiter = ";";
        return getClass().getSimpleName() + delimiter + dauer + delimiter;
    }

    @Override
    public String toString() {
        return "Kurs: " +
                "dauer: " + dauer;
    }
}
