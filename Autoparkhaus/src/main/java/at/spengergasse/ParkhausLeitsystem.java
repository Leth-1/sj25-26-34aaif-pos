package at.spengergasse;

public class ParkhausLeitsystem {
    private Auto[] parkplaetze;
    private int anzahlPlaetze;
    private int ausgangsPosition;

    public ParkhausLeitsystem(int anzahlPlaetze, int ausgangsPosition) {
        this.anzahlPlaetze = anzahlPlaetze;
        this.ausgangsPosition = ausgangsPosition;
        this.parkplaetze = new Auto[anzahlPlaetze];
    }

    // Findet den nächsten freien Platz zum Ausgang
    public int findeNaechstenFreienPlatz() {
        int naechster = -1;
        int minAbstand = Integer.MAX_VALUE;

        for (int i = 0; i < parkplaetze.length; i++) {
            if (parkplaetze[i] == null) {
                int abstand = Math.abs(i - ausgangsPosition);
                if (abstand < minAbstand) {
                    minAbstand = abstand;
                    naechster = i;
                }
            }
        }

        return naechster;
    }

    public boolean parkiere(Auto auto, int platz) {
        if (auto == null) return false;
        if (platz < 0 || platz >= anzahlPlaetze) return false;
        if (parkplaetze[platz] != null) return false;

        parkplaetze[platz] = auto;
        return true;
    }

    public Auto verlasse(int platz) {
        if (platz < 0 || platz >= anzahlPlaetze) return null;

        Auto auto = parkplaetze[platz];
        parkplaetze[platz] = null;
        return auto;
    }

    public double berechneAuslastung() {
        int belegt = 0;
        for (Auto auto : parkplaetze) {
            if (auto != null) {
                belegt++;
            }
        }
        return (double) belegt / anzahlPlaetze * 100;
    }

    public int anzahlFreiePlaetze() {
        int frei = 0;
        for (Auto auto : parkplaetze) {
            if (auto == null) {
                frei++;
            }
        }
        return frei;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Parkhaus ===\n");
        sb.append(String.format("Ausgang bei Platz %d\n", ausgangsPosition));
        sb.append(String.format("Auslastung: %.1f%%\n", berechneAuslastung()));
        sb.append(String.format("Freie Plätze: %d/%d\n\n", anzahlFreiePlaetze(), anzahlPlaetze));

        for (int i = 0; i < parkplaetze.length; i++) {
            sb.append(String.format("Platz %2d: %s\n", i,
                    parkplaetze[i] == null ? "FREI" : parkplaetze[i]));
        }

        return sb.toString();
    }
}