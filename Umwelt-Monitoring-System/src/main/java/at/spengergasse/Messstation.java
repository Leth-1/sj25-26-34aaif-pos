package at.spengergasse;

import java.time.Year;

public abstract class Messstation {
    private String standort;
    private Year installationsJahr;
    private double messwert;

    public Messstation(String standort, Year installationsJahr, double messwert) {
        setMesswert(messwert);
        setStandort(standort);
        setInstallationsJahr(installationsJahr);
    }

    public String getStandort() {
        return standort;
    }

    public void setStandort(String standort) {
        if (standort == null || standort.isBlank()) {
            throw new IllegalArgumentException("Fehler: Blank oder null");
        }
        this.standort = standort;
    }

    public double getMesswert() {
        return messwert;
    }

    public void setMesswert(double messwert) {
        if (messwert < 0) {
            throw new IllegalArgumentException("Fehler: kleiner als 0.");
        }
        this.messwert = messwert;
    }

    public Year getInstallationsJahr() {
        return installationsJahr;
    }

    public void setInstallationsJahr(Year installationsJahr) {
        if (installationsJahr == null || installationsJahr.isAfter(Year.now()) || installationsJahr.isBefore(Year.of(1880))) {
            throw new IllegalArgumentException("Fehler: null oder du bist ein time travler");
        }
        this.installationsJahr = installationsJahr;
    }

    public abstract double berechneUmweltIndex();

    public abstract String getStationTyp();


    public int compareTo(Messstation anderes) {
        return Double.compare(anderes.getMesswert(), messwert);
    }


    @Override
    public String toString() {
        return "Messstation: " +
                "Messwert: " + messwert +
                "standort: '" + standort +
                ", installationsJahr: " + installationsJahr;
    }
}
