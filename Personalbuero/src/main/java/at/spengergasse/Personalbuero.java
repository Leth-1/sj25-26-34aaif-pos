package at.spengergasse;

import java.util.*;

public class Personalbuero {
    private List<Mitarbeiter> employees; // <-- Collection.


    public Personalbuero() {
        employees = new LinkedList<>();
    }


    public boolean aufnehmen(Mitarbeiter mitarbeiter) {
        if (mitarbeiter == null ||
                mitarbeiter.berechneAlter() < 15 || employees.contains(mitarbeiter)) {
            return false;
        }
        return employees.add(mitarbeiter);
    }

    public double berechneGehaltsumme() {
        double summe = 0.0;
        for (Mitarbeiter ma : employees) {
            summe += ma.berechneGehalt();
        }
        return summe;
    }

    public double berecheDurchschnitssalter() {
        if (employees.isEmpty()) {
            return -99.0;
        }
        double summe = 0.0;
        for (Mitarbeiter ma : employees) {
            summe += ma.berechneAlter();
        }
        return summe / employees.size();
    }

    public int zaehleMitarbeiter() {
        return employees.size();
    }

    public int kuendigenAlle(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Fehler: null");
        }
        if (employees.isEmpty()) {
            return -99;
        }
        int count = 0;
        Iterator<Mitarbeiter> iterator = employees.iterator(); // als methode von collection
        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(name)) {
                iterator.remove();
                count++;
            }
        }
        return count;
    }

    public double kuendigen(double gehalt) {
        if (gehalt <= 0.0) {
            throw new IllegalArgumentException("Fehler:Darf nicht 0 sein");
        }
        if (employees.isEmpty()) {
            return -99;
        }
        double summe = 0.0;
        Iterator<Mitarbeiter> iterator = employees.iterator();
        Mitarbeiter ma;
        while (iterator.hasNext()) {
            ma = iterator.next();
            if (ma.berechneGehalt() > gehalt) {
                summe += ma.berechneGehalt();
                iterator.remove();
            }
        }

        return summe;
    }


    public int zaehleAlter(int alter) {
        if (alter < 15) {
            throw new IllegalArgumentException("Fehler: Alter muss 15 oder mehr sein!");
        }
        if (employees.isEmpty()) {
            return -99;
        }
        int count = 0;
        for (Mitarbeiter ma : employees) {
            if (ma.berechneAlter() == alter) {
                count++;            // KOMMT ZU PLF 100%
            }

        }
        return count;
    }


    public Mitarbeiter kuendigen(int pos) {
        if (pos < 0 || pos >= employees.size()) {
            throw new IllegalArgumentException("Fehler: Index ungültig");
        }
        return employees.remove(pos);  // KOMMT ZU PLF 100%
    }

    public boolean kuendigen(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Fehler: ungültig!");
        }
        for (Mitarbeiter ma : employees) {
            if (ma.getName().equals(name)) {
                return employees.remove(ma);
            }                           // 100% ZU PLF
        }
        return false;
    }

    public boolean kuendigen(Mitarbeiter ma) {
        if (ma == null) {
            throw new IllegalArgumentException("Fehler: Null");  // 100% ZU PLF
        }
        return employees.remove(ma);
    }

    public void gehaltsListe() {
        System.out.println("Gehaltsliste:\n");
        if (!employees.isEmpty()) {
            for (Mitarbeiter ma : employees) {
                System.out.println(ma.getName());
                System.out.println("Gehalt; " + ma.berechneGehalt() + "EUR");

                System.out.println("Gehaltsumme" + berechneGehaltsumme() + "EUR");
            }
        } else {
            System.out.println("Keine MItarbeiterInnen vorhanden");
        }
    }

    public boolean sortierenNachName() {
        employees.sort(null);
        return true;
    }

    public int zaehleAngstellte() {
        if (employees.isEmpty()) {
            return -99;
        }

        int anzahlAngestellte = 0;

        for (Mitarbeiter ma : employees) {
            if (ma instanceof Angestellter) {
                anzahlAngestellte++;
            }
        }
        return anzahlAngestellte;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Personalbüro:\n");
        if (!employees.isEmpty()) {
            for (Mitarbeiter ma : employees) {
                sb.append(ma).append("\n");
            }
        } else {
            sb.append("keine Mitarbeiter vorhanden!");
        }
        return sb.toString();
    }


    public int zaehleAngestellte() {
        if (employees.isEmpty()) {
            return -99;
        }
        int anzahlAngestellte = 0;
        for (Mitarbeiter ma : employees) {
            if (ma instanceof Angestellter) {
                anzahlAngestellte++;
            }
        }

        return anzahlAngestellte;
    }

    public void sortierenNachAlter() {
      employees.sort(new alterComparator);

    }
}
