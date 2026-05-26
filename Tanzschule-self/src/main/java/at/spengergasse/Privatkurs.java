package at.spengergasse;

public class Privatkurs extends Kurs {
    private double preisProTag;

    public Privatkurs(int dauer, double preisProTag) throws TanzschuleException {
        super(dauer);
        setPreisProTag(preisProTag);
    }

    public Privatkurs(String[] linepart) throws TanzschuleException {
        super(linepart);
        try {
            setPreisProTag(Double.parseDouble(linepart[2]));
        } catch (NumberFormatException e) {
            throw new TanzschuleException("Feh");
        } catch (TanzschuleException e) {
            throw new TanzschuleException("Fehler");
        }

    }

    public double getPreisProTag() {
        return preisProTag;
    }

    public void setPreisProTag(double preisProTag) throws TanzschuleException {
        if (preisProTag < 0.0) {
            throw new TanzschuleException("Fhelr");
        }
        this.preisProTag = preisProTag;
    }

    @Override
    public double preis() {
        return getDauer() + preisProTag;
    }

    public String ToCSVString() {
        String delimiter = ";";
        return super.ToCSVString() + delimiter + preisProTag;
    }

    @Override
    public String toString() {
        return "Privatkurs: " + super.toString() +
                "preisProTag: " + preisProTag;

    }
}
