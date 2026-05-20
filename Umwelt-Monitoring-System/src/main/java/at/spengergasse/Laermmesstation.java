package at.spengergasse;

import java.time.Year;

public class Laermmesstation extends Messstation {
    private double maxErlaubterPegel;

    public Laermmesstation(String standort, Year installationsJahr, double messwert, double maxErlaubterPegel) {
        super(standort, installationsJahr, messwert);
        setMaxErlaubterPegel(maxErlaubterPegel);
    }

    public double getMaxErlaubterPegel() {
        return maxErlaubterPegel;
    }

    public void setMaxErlaubterPegel(double maxErlaubterPegel) {
        if (maxErlaubterPegel < 0) {
            throw new IllegalArgumentException("Fehler: Kleiner als 0");
        }
        this.maxErlaubterPegel = maxErlaubterPegel;
    }


    @Override
    public double berechneUmweltIndex() {
        return getMesswert() - maxErlaubterPegel;
    }

    @Override
    public String getStationTyp() {
        return "laermmesstation";
    }

    @Override
    public String toString() {
        return "Laermmesstation: " + super.toString() +
                "maxErlaubterPegel: " + maxErlaubterPegel;

    }
}
