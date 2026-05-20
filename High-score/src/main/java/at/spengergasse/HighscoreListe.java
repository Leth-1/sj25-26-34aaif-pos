package at.spengergasse;

import java.util.Arrays;

public class HighscoreListe {
    private Spieler[] highscores;
    private int anzahlEintraege;

    public HighscoreListe() {
        highscores = new Spieler[10];
        anzahlEintraege = 0;
    }

    public boolean fuegeErgebnisHinzu(Spieler neuerSpieler) {
        if (neuerSpieler == null) return false;

        // Prüfe, ob Ergebnis gut genug für Top 10 ist
        if (anzahlEintraege < 10) {
            // Liste noch nicht voll - einfach hinzufügen
            highscores[anzahlEintraege] = neuerSpieler;
            anzahlEintraege++;
            sortiereHighscores();
            return true;
        } else {
            // Liste voll - prüfe, ob besser als der schlechteste
            if (neuerSpieler.getPunkte() > highscores[9].getPunkte()) {
                // Füge neuen Spieler ein, letzter fällt raus
                highscores[9] = neuerSpieler;
                sortiereHighscores();
                return true;
            }
        }

        return false;
    }

    public boolean istHighscore(int punkte) {
        if (anzahlEintraege < 10) return true;
        return punkte > highscores[9].getPunkte();
    }

    public void sortiereHighscores() {
        // Sortiere nur die tatsächlich belegten Plätze
        if (anzahlEintraege > 0) {
            Arrays.sort(highscores, 0, anzahlEintraege);
        }
    }

    public int getPlatzierung(int punkte) {
        for (int i = 0; i < anzahlEintraege; i++) {
            if (punkte > highscores[i].getPunkte()) {
                return i + 1;
            }
        }
        if (anzahlEintraege < 10) {
            return anzahlEintraege + 1;
        }
        return -1; // Nicht in Top 10
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== TOP 10 HIGHSCORES ===\n");

        if (anzahlEintraege == 0) {
            sb.append("Noch keine Einträge vorhanden.\n");
        } else {
            for (int i = 0; i < anzahlEintraege; i++) {
                sb.append(String.format("%2d. %s\n", i+1, highscores[i]));
            }
        }

        return sb.toString();
    }
}