package at.spengergasse;

import java.util.Scanner;

public class KinoReservierung {

    // 2D-Array für Kinosaal
    private boolean[][] sitze;
    private int reihen;
    private int plaetzeProReihe;
    private String saalName;

    // Konstruktor
    public KinoReservierung(String saalName, int reihen, int plaetzeProReihe) {
        this.saalName = saalName;
        this.reihen = reihen;
        this.plaetzeProReihe = plaetzeProReihe;
        this.sitze = new boolean[reihen][plaetzeProReihe];

        // false = frei, true = besetzt
        // Standardmäßig sind alle Plätze frei (false)
    }

    // Aufgabe 1: Einzelnen Platz reservieren
    public boolean platzReservieren(int reihe, int platz) {
        // Bounds-Checking
        if (!istGueltigerPlatz(reihe, platz)) {
            System.out.println("❌ Ungültiger Platz! Reihe " + reihe + ", Platz " + platz);
            return false;
        }

        // Prüfen ob Platz frei ist
        if (sitze[reihe][platz]) {
            System.out.println("❌ Platz bereits besetzt! Reihe " + reihe + ", Platz " + platz);
            return false;
        }

        // Platz reservieren
        sitze[reihe][platz] = true;
        System.out.println("✓ Platz reserviert: Reihe " + reihe + ", Platz " + platz);
        return true;
    }

    // Aufgabe 2: Prüfen ob n Personen nebeneinander sitzen können
    public boolean kannGruppeNebeneinanderSitzen(int anzahlPersonen) {
        // Nested Loops durch alle Reihen und mögliche Startpositionen
        for (int reihe = 0; reihe < reihen; reihe++) {
            for (int startPlatz = 0; startPlatz <= plaetzeProReihe - anzahlPersonen; startPlatz++) {

                // Prüfe ob alle benötigten Plätze ab startPlatz frei sind
                boolean alleFrei = true;
                for (int i = 0; i < anzahlPersonen; i++) {
                    if (sitze[reihe][startPlatz + i]) {
                        alleFrei = false;
                        break;
                    }
                }

                // Wenn alle Plätze frei sind, haben wir einen Treffer!
                if (alleFrei) {
                    return true;
                }
            }
        }

        return false;
    }

    // Aufgabe 3: Gruppe nebeneinander reservieren (mit Details)
    public boolean gruppeReservieren(int anzahlPersonen) {
        System.out.println("\n🔍 Suche " + anzahlPersonen + " zusammenhängende Plätze...");

        // Nested Loops
        for (int reihe = 0; reihe < reihen; reihe++) {
            for (int startPlatz = 0; startPlatz <= plaetzeProReihe - anzahlPersonen; startPlatz++) {

                // Prüfe ob alle benötigten Plätze frei sind
                boolean alleFrei = true;
                for (int i = 0; i < anzahlPersonen; i++) {
                    if (sitze[reihe][startPlatz + i]) {
                        alleFrei = false;
                        break;
                    }
                }

                // Wenn gefunden, reserviere alle Plätze
                if (alleFrei) {
                    for (int i = 0; i < anzahlPersonen; i++) {
                        sitze[reihe][startPlatz + i] = true;
                    }
                    System.out.println("✓ Gruppe reserviert: Reihe " + reihe +
                            ", Plätze " + startPlatz + " bis " + (startPlatz + anzahlPersonen - 1));
                    return true;
                }
            }
        }

        System.out.println("❌ Keine " + anzahlPersonen + " zusammenhängenden Plätze verfügbar!");
        return false;
    }

    // Aufgabe 4: Sitzplan als String ausgeben
    public void sitzplanAnzeigen() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║  🎬 " + saalName + " - SITZPLAN");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");

        // Leinwand anzeigen
        System.out.println("                    🎥 LEINWAND 🎥");
        System.out.println("  ═══════════════════════════════════════════════════════");
        System.out.println();

        // Platznummern oben anzeigen
        System.out.print("      ");
        for (int p = 0; p < plaetzeProReihe; p++) {
            System.out.printf("%2d ", p);
        }
        System.out.println();
        System.out.print("      ");
        for (int p = 0; p < plaetzeProReihe; p++) {
            System.out.print("───");
        }
        System.out.println();

        // Nested Loop: Durch alle Reihen und Plätze
        for (int r = 0; r < reihen; r++) {
            System.out.printf("  %2d │ ", r);

            for (int p = 0; p < plaetzeProReihe; p++) {
                if (sitze[r][p]) {
                    System.out.print(" ❌ "); // Besetzt
                } else {
                    System.out.print(" ✓  "); // Frei
                }
            }

            System.out.printf("│ %2d", r);
            System.out.println();
        }

        System.out.print("      ");
        for (int p = 0; p < plaetzeProReihe; p++) {
            System.out.print("───");
        }
        System.out.println();

        System.out.println("\n  Legende: ✓ = Frei   ❌ = Besetzt\n");
    }

    // Sitzplan als String (alternative Darstellung)
    public String sitzplanAlsString() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== SITZPLAN ===\n");
        sb.append("Platz: ");
        for (int p = 0; p < plaetzeProReihe; p++) {
            sb.append(String.format("%2d ", p));
        }
        sb.append("\n");

        for (int r = 0; r < reihen; r++) {
            sb.append(String.format("Reihe %2d: ", r));
            for (int p = 0; p < plaetzeProReihe; p++) {
                sb.append(sitze[r][p] ? " X " : " O ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    // Hilfsmethoden
    private boolean istGueltigerPlatz(int reihe, int platz) {
        return reihe >= 0 && reihe < reihen && platz >= 0 && platz < plaetzeProReihe;
    }

    // Statistiken
    public void statistikAnzeigen() {
        int besetztePlätze = 0;
        int freiePlätze = 0;

        // Nested Loop zum Zählen
        for (int r = 0; r < reihen; r++) {
            for (int p = 0; p < plaetzeProReihe; p++) {
                if (sitze[r][p]) {
                    besetztePlätze++;
                } else {
                    freiePlätze++;
                }
            }
        }

        int gesamt = reihen * plaetzeProReihe;
        double auslastung = (besetztePlätze * 100.0) / gesamt;

        System.out.println("\n📊 STATISTIK:");
        System.out.println("  Gesamtplätze:    " + gesamt);
        System.out.println("  Besetzt:         " + besetztePlätze);
        System.out.println("  Frei:            " + freiePlätze);
        System.out.printf("  Auslastung:      %.1f%%\n", auslastung);
    }

    // Freie Plätze in Reihe zählen
    public int freiePlaetzeInReihe(int reihe) {
        if (reihe < 0 || reihe >= reihen) {
            return 0;
        }

        int frei = 0;
        for (int p = 0; p < plaetzeProReihe; p++) {
            if (!sitze[reihe][p]) {
                frei++;
            }
        }
        return frei;
    }

    // Beste Reihe für Gruppe finden
    public void besteReiheAnzeigen(int anzahlPersonen) {
        System.out.println("\n🔍 Beste Reihen für " + anzahlPersonen + " Personen:");

        boolean gefunden = false;
        for (int r = 0; r < reihen; r++) {
            // Prüfe ob genug zusammenhängende Plätze in dieser Reihe
            for (int startPlatz = 0; startPlatz <= plaetzeProReihe - anzahlPersonen; startPlatz++) {
                boolean alleFrei = true;
                for (int i = 0; i < anzahlPersonen; i++) {
                    if (sitze[r][startPlatz + i]) {
                        alleFrei = false;
                        break;
                    }
                }

                if (alleFrei) {
                    System.out.println("  → Reihe " + r + ", Plätze " + startPlatz +
                            " bis " + (startPlatz + anzahlPersonen - 1));
                    gefunden = true;
                    break; // Nur erste Option pro Reihe zeigen
                }
            }
        }

        if (!gefunden) {
            System.out.println("  ❌ Keine passenden Plätze verfügbar");
        }
    }

    // Main-Methode zum Testen
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║           🎬 KINO-RESERVIERUNGSSYSTEM 🎬                      ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");

        // Kinosaal erstellen (8 Reihen, 12 Plätze pro Reihe)
        KinoReservierung kino = new KinoReservierung("Saal 1", 8, 12);

        // Sitzplan anzeigen (leer)
        kino.sitzplanAnzeigen();
        kino.statistikAnzeigen();

        System.out.println("\n" + "═".repeat(65));
        System.out.println("➤ Einzelne Plätze reservieren...\n");

        // Einzelne Plätze reservieren
        kino.platzReservieren(2, 5);
        kino.platzReservieren(2, 6);
        kino.platzReservieren(3, 3);
        kino.platzReservieren(3, 4);
        kino.platzReservieren(3, 5);

        kino.sitzplanAnzeigen();

        System.out.println("\n" + "═".repeat(65));
        System.out.println("➤ Gruppe von 4 Personen reservieren...");

        // Prüfen ob 4 Personen nebeneinander sitzen können
        if (kino.kannGruppeNebeneinanderSitzen(4)) {
            System.out.println("✓ 4 zusammenhängende Plätze sind verfügbar!");
            kino.besteReiheAnzeigen(4);
            kino.gruppeReservieren(4);
        } else {
            System.out.println("❌ Keine 4 zusammenhängenden Plätze verfügbar!");
        }

        kino.sitzplanAnzeigen();

        System.out.println("\n" + "═".repeat(65));
        System.out.println("➤ Größere Gruppe von 6 Personen reservieren...");

        kino.gruppeReservieren(6);
        kino.sitzplanAnzeigen();
        kino.statistikAnzeigen();

        System.out.println("\n" + "═".repeat(65));
        System.out.println("➤ Versuche 10 Personen zu reservieren...");

        kino.gruppeReservieren(10);

        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║              Reservierungsprozess abgeschlossen!              ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }
}