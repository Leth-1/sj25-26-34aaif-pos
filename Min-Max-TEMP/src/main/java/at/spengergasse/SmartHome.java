package at.spengergasse;

import java.util.Random;
import java.util.ArrayList;

import java.util.ArrayList;

public class HeizungsSteuerung {
    private double[] temperaturWerte;

    public HeizungsSteuerung() {
        temperaturWerte = new double[24];
    }

    public void setTemperatur(int stunde, double temp) {
        if (stunde >= 0 && stunde < 24) {
            temperaturWerte[stunde] = temp;
        }
    }

    public double getTemperatur(int stunde) {
        if (stunde >= 0 && stunde < 24) {
            return temperaturWerte[stunde];
        }
        return 0.0;
    }

    public double findeMinimaltemperatur() {
        double min = temperaturWerte[0];
        for (int i = 1; i < temperaturWerte.length; i++) {
            if (temperaturWerte[i] < min) {
                min = temperaturWerte[i];
            }
        }
        return min;
    }

    public double findeMaximaltemperatur() {
        double max = temperaturWerte[0];
        for (int i = 1; i < temperaturWerte.length; i++) {
            if (temperaturWerte[i] > max) {
                max = temperaturWerte[i];
            }
        }
        return max;
    }

    public double berechneDurchschnitt() {
        double summe = 0.0;
        for (double temp : temperaturWerte) {
            summe += temp;
        }
        return summe / temperaturWerte.length;
    }

    // Findet Heizphasen (Sequenzen, in denen die Temperatur steigt)
    // Gibt Liste von int-Arrays zurück: [startStunde, endStunde]
    public ArrayList<int[]> findeHeizphasen() {
        ArrayList<int[]> phasen = new ArrayList<>();
        int startPhase = -1;

        for (int i = 1; i < temperaturWerte.length; i++) {
            if (temperaturWerte[i] > temperaturWerte[i-1]) {
                if (startPhase == -1) {
                    startPhase = i-1;
                }
            } else {
                if (startPhase != -1) {
                    phasen.add(new int[]{startPhase, i-1});
                    startPhase = -1;
                }
            }
        }

        // Wenn Phase bis zum Ende geht
        if (startPhase != -1) {
            phasen.add(new int[]{startPhase, temperaturWerte.length-1});
        }

        return phasen;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Heizungssteuerung (24h) ===\n");
        for (int i = 0; i < temperaturWerte.length; i++) {
            sb.append(String.format("%02d:00 Uhr - %.1f°C\n", i, temperaturWerte[i]));
        }
        sb.append(String.format("\nMin: %.1f°C | Max: %.1f°C | Ø: %.1f°C",
                findeMinimaltemperatur(),
                findeMaximaltemperatur(),
                berechneDurchschnitt()));
        return sb.toString();
    }
}
