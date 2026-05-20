package at.spengergasse;

public class Beinpresse extends Maschine {
    private int maxGewicht;

    public Beinpresse(String name, double preisEur, int maxGewicht) throws Gymexception {
        super(name, preisEur);
        setMaxGewicht(maxGewicht);
    }

    public int getMaxGewicht() {
        return maxGewicht;
    }

    public void setMaxGewicht(int maxGewicht) throws Gymexception {
        if (maxGewicht < 100 || maxGewicht > 500) {
            throw new Gymexception("Fehler: ");
        }
        this.maxGewicht = maxGewicht;
    }

    @Override
    public int wartungsIntervall() throws Gymexception {
        return 6;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Beinpresse that = (Beinpresse) o;
        return maxGewicht == that.maxGewicht;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + maxGewicht;
        return result;
    }

    @Override
    public String toString() {
        try {
            return "Beinpresse: " + super.toString() + "WartungsIntervall: " + wartungsIntervall() + "Monate" +
                    "maxGewicht: " + maxGewicht;
        } catch (Gymexception e) {
            throw new RuntimeException(e);
        }
    }
}
