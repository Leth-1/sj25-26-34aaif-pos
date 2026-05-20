package at.spengergasse;

import java.util.ArrayList;

public class FlugBuchungssystem {
    private Passagier[] sitzplaetze;
    private ArrayList<Passagier> warteliste;
    private int kapazitaet;

    public FlugBuchungssystem(int kapazitaet) {
        this.kapazitaet = kapazitaet;
        this.sitzplaetze = new Passagier[kapazitaet];
        this.warteliste = new ArrayList<>();
    }

    public boolean buchePassagier(Passagier passagier) {
        if (passagier == null) return false;

        // Suche freien Platz
        for (int i = 0; i < sitzplaetze.length; i++) {
            if (sitzplaetze[i] == null) {
                sitzplaetze[i] = passagier;
                return true;
            }
        }

        // Kein freier Platz - auf Warteliste setzen
        warteliste.add(passagier);
        return false;
    }

    public boolean storniere(int platzNummer) {
        if (platzNummer < 0 || platzNummer >= kapazitaet) return false;
        if (sitzplaetze[platzNummer] == null) return false;

        sitzplaetze[platzNummer] = null;
        rueckeNach();
        return true;
    }

    // Lässt Passagiere von der Warteliste nachrücken
    public void rueckeNach() {
        if (warteliste.isEmpty()) return;

        for (int i = 0; i < sitzplaetze.length; i++) {
            if (sitzplaetze[i] == null && !warteliste.isEmpty()) {
                sitzplaetze[i] = warteliste.remove(0);
            }
        }
    }

    public int getAnzahlGebucht() {
        int gebucht = 0;
        for (Passagier p : sitzplaetze) {
            if (p != null) gebucht++;
        }
        return gebucht;
    }

    public int getAnzahlWarteliste() {
        return warteliste.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Flugbuchungssystem ===\n");
        sb.append(String.format("Kapazität: %d | Gebucht: %d | Warteliste: %d\n\n",
                kapazitaet, getAnzahlGebucht(), getAnzahlWarteliste()));

        sb.append("Sitzplätze:\n");
        for (int i = 0; i < sitzplaetze.length; i++) {
            sb.append(String.format("Platz %2d: %s\n", i+1,
                    sitzplaetze[i] == null ? "FREI" : sitzplaetze[i]));
        }

        if (!warteliste.isEmpty()) {
            sb.append("\nWarteliste:\n");
            for (int i = 0; i < warteliste.size(); i++) {
                sb.append(String.format("%d. %s\n", i+1, warteliste.get(i)));
            }
        }

        return sb.toString();
    }
}
