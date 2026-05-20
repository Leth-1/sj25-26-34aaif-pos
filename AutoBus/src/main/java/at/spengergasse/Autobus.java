package at.spengergasse;

import java.util.ArrayList;

class Autobus {

    // private Person[] sitze;
    private final ArrayList<Person> sitze;
    private int cap;

    public Autobus(int cap) {
        this.sitze = new ArrayList();
        setCap(cap);
    }

    public void setCap(int cap) {
        if (cap < 1 || cap > 50){
            throw new IllegalArgumentException("cap ist zu groß oder zu klein.");
        }
        this.cap = cap;
    }


    // Anforderungen an die Methode:
    // 1) Exception werfen wenn
    // 1a) person is null
    // 2a) person ist bereits im Bus (caller über logikfehler informieren)

    // 2) die Person auf den ersten freien Sitz setzten und "true" zurückgeben
    // 3) wenn kein Platz mehr frei ist, nix machen und "false" zurückgeben
    public boolean einsteigen(Person person) {
        if (person == null) {
            throw new IllegalArgumentException("null sollte nie einsteigen");
        }
        if (istDrin(person)) {
            throw new IllegalArgumentException("Person schon drinnen.");
        }
        if (istVoll()){
            return false;
        }

        sitze.add(person);
        return true;


    }

    // gibt zurück, ob die Person im Bus ist ( true / false )
    public boolean istDrin(Person person) {
        return sitze.contains(person);

    }

    public boolean hatPlatz() {
        return !istVoll();
    }

    public boolean istVoll() {
        if (sitze.size() == cap){
            return true;
        } else return false;
    }
}
