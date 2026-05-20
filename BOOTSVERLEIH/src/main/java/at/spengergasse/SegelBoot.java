package at.spengergasse;

public class SegelBoot extends Boot {

    private double preisProPerson;
    private boolean lizenz;


    public SegelBoot(int maxPersonen, String bezeichnung, double preisProPerson, boolean lizenz) throws BootException {
        super(maxPersonen, bezeichnung);
        setPreisProPerson(preisProPerson);
        setLizenz(lizenz);
    }

    public boolean isLizenz() {
        return lizenz;
    }

    public void setLizenz(boolean lizenz) {
        this.lizenz = lizenz;
    }

    public double getPreisProPerson() {
        return preisProPerson;
    }

    public void setPreisProPerson(double preisProPerson) throws BootException {
        if (preisProPerson < 0.0) {
            throw new BootException("Fehler: preis darf nicht minus sein");
        }
        this.preisProPerson = preisProPerson;
    }

    @Override
    public double preis() {
        return preisProPerson * getMaxPersonen();
    }

    private String hatlizenz(boolean lizenz) {
        if (lizenz) {
            return "Hat lizenz";
        } else return "hat kein lizenz";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        SegelBoot segelBoot = (SegelBoot) o;
        return Double.compare(preisProPerson, segelBoot.preisProPerson) == 0 && lizenz == segelBoot.lizenz;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Double.hashCode(preisProPerson);
        result = 31 * result + Boolean.hashCode(lizenz);
        return result;
    }

    @Override
    public String toString() {
        return "SegelBoot: " + super.toString() +
                "preisProPerson: " + preisProPerson +
                ", lizenz: " + hatlizenz(lizenz);
    }
}
