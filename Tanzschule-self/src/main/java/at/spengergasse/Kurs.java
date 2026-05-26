package at.spengergasse;

public abstract class Kurs {
    private int dauer;

    public Kurs(int dauer) throws TanzschuleException {
        setDauer(dauer);
    }

    public Kurs(String[] linepart) {
        Double.parseDouble(linepart[1]);
    }

    public int getDauer() {
        return dauer;
    }

    public void setDauer(int dauer) throws TanzschuleException {
        if (dauer < 0 || dauer > 100){
            throw new TanzschuleException("Feh");
        }
    }

    public abstract double preis();

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

    public String ToCSVString() {
        String delimiter = ";";
        return getClass().getSimpleName() + delimiter + dauer + delimiter;
    }

    @Override
    public String toString() {
        return "Kurs:" +
                "dauer: " + dauer;
    }
}
