package at.spengergasse;

import java.time.LocalDate;

public class Spieler implements Comparable<Spieler> {
    private String name;
    private int punkte;
    private LocalDate datum;

    public Spieler(String name, int punkte) {
        this.name = name;
        this.punkte = punkte;
        this.datum = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public int getPunkte() {
        return punkte;
    }

    public LocalDate getDatum() {
        return datum;
    }

    @Override
    public int compareTo(Spieler other) {
        // Sortierung nach Punkten absteigend (höchste zuerst)
        return Integer.compare(other.punkte, this.punkte);
    }

    @Override
    public String toString() {
        return String.format("%s: %d Punkte (%s)", name, punkte, datum);
    }
}