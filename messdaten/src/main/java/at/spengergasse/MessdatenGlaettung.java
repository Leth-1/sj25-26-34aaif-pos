package at.spengergasse;

public class MessdatenGlaettung {
    private double[] messwerte;

    public MessdatenGlaettung(double[] messwerte) {
        this.messwerte = messwerte;
    }

    // Gleitender Durchschnitt: Jeder Wert = Durchschnitt aus ihm und seinen Nachbarn
    public double[] gleitenderDurchschnitt() {
        double[] geglättet = new double[messwerte.length];

        for (int i = 0; i < messwerte.length; i++) {
            if (i == 0) {
                // Erster Wert: nur aktueller und rechter Nachbar
                geglättet[i] = (messwerte[i] + messwerte[i + 1]) / 2.0;
            } else if (i == messwerte.length - 1) {
                // Letzter Wert: nur linker Nachbar und aktueller
                geglättet[i] = (messwerte[i - 1] + messwerte[i]) / 2.0;
            } else {
                // Mittlere Werte: linker Nachbar, aktueller, rechter Nachbar
                geglättet[i] = (messwerte[i - 1] + messwerte[i] + messwerte[i + 1]) / 3.0;
            }
        }

        return geglättet;
    }

    // Erweiterte Version mit variabler Fenstergröße
    public double[] gleitenderDurchschnittMitFenster(int fensterGroesse) {
        double[] geglättet = new double[messwerte.length];
        int halbFenster = fensterGroesse / 2;

        for (int i = 0; i < messwerte.length; i++) {
            int start = Math.max(0, i - halbFenster);
            int end = Math.min(messwerte.length - 1, i + halbFenster);

            double summe = 0.0;
            int anzahl = 0;
            for (int j = start; j <= end; j++) {
                summe += messwerte[j];
                anzahl++;
            }
            geglättet[i] = summe / anzahl;
        }

        return geglättet;
    }

    public double[] getMesswerte() {
        return messwerte;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Messdaten ===\n");
        sb.append("Original: ");
        for (double wert : messwerte) {
            sb.append(String.format("%.2f ", wert));
        }
        sb.append("\nGeglättet: ");
        double[] geglättet = gleitenderDurchschnitt();
        for (double wert : geglättet) {
            sb.append(String.format("%.2f ", wert));
        }
        return sb.toString();
    }
}