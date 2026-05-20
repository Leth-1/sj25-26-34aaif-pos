package at.spengergasse;

import java.util.Objects;

public abstract class Maschine {

    private String name;
    private double preisEur;


    public Maschine(String name, double preisEur) throws Gymexception {
        setName(name);
        setPreisEur(preisEur);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Gymexception {
        if (name == null || name.isEmpty()) {
            throw new Gymexception("Fehler: Name is null oder empty");
        }
        this.name = name;
    }

    public double getPreisEur() {
        return preisEur;
    }

    public void setPreisEur(double preisEur) throws Gymexception {
        if (preisEur < 0.0) {
            throw new Gymexception("Fehler: preis ist negativ");
        }
        this.preisEur = preisEur;
    }

    public abstract int wartungsIntervall() throws Gymexception;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Maschine maschine = (Maschine) o;
        return Double.compare(preisEur, maschine.preisEur) == 0 && Objects.equals(name, maschine.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Double.hashCode(preisEur);
        return result;
    }

    @Override
    public String toString() {
        return
                name + preisEur + "Euro";
    }
}
