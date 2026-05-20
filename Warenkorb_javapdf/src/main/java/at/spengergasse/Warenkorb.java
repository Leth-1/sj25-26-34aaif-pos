package at.spengergasse;

import java.util.ArrayList;

public class Warenkorb {
    private ArrayList<Artikel> artikel;

    public Warenkorb() {
        artikel = new ArrayList<>();
    }

    // Fügt Artikel hinzu oder erhöht Menge bei vorhandenem Artikel
    public void add(Artikel neuerArtikel) {
        if (neuerArtikel == null) return;

        // Prüfe, ob Artikel bereits vorhanden ist
        for (Artikel a : artikel) {
            if (a.equals(neuerArtikel)) {
                a.erhoeheAnzahl();
                return;
            }
        }

        // Artikel noch nicht vorhanden - hinzufügen
        artikel.add(neuerArtikel);
    }

    public boolean entferneArtikel(String bezeichnung) {
        for (int i = 0; i < artikel.size(); i++) {
            if (artikel.get(i).getBezeichnung().equals(bezeichnung)) {
                artikel.remove(i);
                return true;
            }
        }
        return false;
    }

    public double berechneGesamtsumme() {
        double summe = 0.0;
        for (Artikel a : artikel) {
            summe += a.getPreis() * a.getMenge();
        }
        return summe;
    }

    public int anzahlArtikel() {
        return artikel.size();
    }

    @Override
    public String toString() {
        if (artikel.isEmpty()) {
            return "Warenkorb ist leer.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("=== Warenkorb ===\n");
        for (Artikel a : artikel) {
            sb.append(a).append("\n");
        }
        sb.append("----------------\n");
        sb.append(String.format("Gesamtsumme: %.2f EUR", berechneGesamtsumme()));
        return sb.toString();
    }
}
