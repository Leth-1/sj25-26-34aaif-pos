package at.spengergasse;

import java.time.Year;

public class Wetterstation extends Messstation {
    private double temperatur;

    public Wetterstation(String standort, Year installationsJahr, double messwert, double temperatur) {
        super(standort, installationsJahr, messwert);
        setTemperatur(temperatur);
    }

    public double getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(double temperatur) {
        if (temperatur < -200 || temperatur > 200) {
            throw new IllegalArgumentException("Fehler: temp passt nicht.");
        }
        this.temperatur = temperatur;
    }


    @Override
    public double berechneUmweltIndex() {
        return getMesswert() + (temperatur * 0.5);
    }

    @Override
    public String getStationTyp() {
        return "Wetterstation";
    }

}
