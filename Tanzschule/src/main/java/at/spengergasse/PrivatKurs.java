package at.spengergasse;

public class PrivatKurs extends Kurs {
    private double preisProTag;

    public PrivatKurs(int dauer, double preisProTag) throws TanzschuleException {
        super(dauer);
        setPreisProTag(preisProTag);
    }

    public PrivatKurs(String[] linePart) throws TanzschuleException {
        super(linePart);
        try {
            setPreisProTag(Double.parseDouble(linePart[2]));
        } catch (TanzschuleException e){
            throw new TanzschuleException("Fehler");
        } catch (NumberFormatException e){
            throw new TanzschuleException("Fehler.");
        }
    }

    public double getPreisProTag() {
        return preisProTag;
    }

    public void setPreisProTag(double preisProTag) throws TanzschuleException {
        if (preisProTag < 0.0) {
            throw new TanzschuleException("Fehler: darf nicht negativ sein");
        }
    }

    @Override
    public double preis() {
        return dauer * preisProTag;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PrivatKurs that = (PrivatKurs) o;
        return Double.compare(preisProTag, that.preisProTag) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Double.hashCode(preisProTag);
        return result;
    }

    public String toCSVToString() {
        String delimiter = ";";
        return super.toCSVString() + delimiter + preisProTag + delimiter;
    }


    @Override
    public String toString() {
        return "PrivatKurs: " + super.toString() + "preisProTag: " + preisProTag;
    }
}
