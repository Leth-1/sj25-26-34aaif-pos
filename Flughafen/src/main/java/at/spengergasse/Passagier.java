package at.spengergasse;

public class Passagier {
    private String name;
    private String buchungsNummer;

    public Passagier(String name, String buchungsNummer) {
        this.name = name;
        this.buchungsNummer = buchungsNummer;
    }

    public String getName() {
        return name;
    }

    public String getBuchungsNummer() {
        return buchungsNummer;
    }

    @Override
    public String toString() {
        return String.format("%s (Buchung: %s)", name, buchungsNummer);
    }
}
