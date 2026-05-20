package at.spengergasse;

import java.util.Objects;

public abstract class Boot implements Comparable<Boot> {
    private int maxPersonen;
    private String bezeichnung;

    public Boot(int maxPersonen, String bezeichnung) throws BootException {
        setMaxPersonen(maxPersonen);
        setBezeichnung(bezeichnung);
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) throws BootException {
        if (bezeichnung == null || bezeichnung.isEmpty()) {
            throw new BootException("Fehler: String ist null oder leer!");
        }
        this.bezeichnung = bezeichnung;
    }

    public int getMaxPersonen() {
        return maxPersonen;
    }

    public void setMaxPersonen(int maxPersonen) throws BootException {
        if (maxPersonen >= 1) {
            throw new BootException("Fehler: personen müssen mehr als 0 sein");
        }
        this.maxPersonen = maxPersonen;
    }

    public abstract double preis();

    public double preisProPerson() {
        return preis() / maxPersonen;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Boot boot = (Boot) o;
        return maxPersonen == boot.maxPersonen && Objects.equals(bezeichnung, boot.bezeichnung);
    }

    @Override
    public int hashCode() {
        int result = maxPersonen;
        result = 31 * result + Objects.hashCode(bezeichnung);
        return result; // beides gen.
    }

    @Override
    public int compareTo(Boot o) {
        return maxPersonen - o.getMaxPersonen();
    }

    @Override
    public String toString() {
        return "maxPersonen: " + maxPersonen +
                ", bezeichnung: " + bezeichnung +
                "Preis: " + preis() + "Euro" +
                "Preis pro Preis: " + preisProPerson() + "Euro";
    }

}
