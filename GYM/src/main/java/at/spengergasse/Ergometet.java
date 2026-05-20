package at.spengergasse;

public class Ergometet extends Maschine {

    private int maxDrehzahl;

    public Ergometet(String name, double preisEur, int maxDrehzahl) throws Gymexception {
        super(name, preisEur);
        setMaxDrehzahl(maxDrehzahl);
    }

    public int getMaxDrehzahl() {
        return maxDrehzahl;
    }

    public void setMaxDrehzahl(int maxDrehzahl) throws Gymexception {
        if (maxDrehzahl < 5 || maxDrehzahl > 150) {
            throw new Gymexception("Fehler: ss ");
        }
        this.maxDrehzahl = maxDrehzahl;
    }

    @Override
    public int wartungsIntervall() throws Gymexception {
        return 12;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Ergometet ergometet = (Ergometet) o;
        return maxDrehzahl == ergometet.maxDrehzahl;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + maxDrehzahl;
        return result;
    }

    @Override
    public String toString() {
        try {
            return "Ergometet{" + super.toString() + "Wartungsintervall" + wartungsIntervall() + "Monate" +
                    "max Drehzahl: " + maxDrehzahl;
        } catch (Gymexception e) {
            throw new RuntimeException(e);
        }
    }
}
