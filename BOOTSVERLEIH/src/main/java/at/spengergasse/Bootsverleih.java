package at.spengergasse;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Bootsverleih {
    private String name;
    private List<Boot> boote;

    public Bootsverleih(String name) {
        setName(name);
        boote = new LinkedList<>();

        // wenn contains ---> equals und hashcode
        // hinzufügen methode -->
        // Strings ist equals nicht ==
        // casting !!
        // instanceof
        // kann kommen Zähle alle eventboote
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boot getBoot(int index) {
        if (index >= 0 && index < boote.size()) {
            return boote.get(index);
        } else {
            return null;
        }
    }

    public boolean hinzufügen(Boot boot) {
        if (boot != null && boote.size() < 20 && boote.contains(boot)) {
            return boote.add(boot);
        } else {
            return false;
        }
    }

    public boolean entfernen(Boot boot) {
        if (boot != null) {
            boote.remove(boot);
        }
        return false;
    }

    public int entfernen(String bezeichnung) {
        int entfernen = 0;
        if (bezeichnung != null) {
            Iterator<Boot> iterator = boote.iterator();
            while (iterator.hasNext()) {
                iterator.next().getBezeichnung().equals(bezeichnung);
                iterator.remove();
                entfernen++;
            }
            return entfernen;
        } else {
            return -99;
        }
    }

    public int anzahlBooteMitLizenz() {
        int anzahlBooteMitLizenz = 0;
        if (anzahlSegelBoote() > 0) {
            for (Boot boot : boote) {
                if (boot instanceof SegelBoot) {
                    if (((SegelBoot) boot).hasLizenz()) {
                        anzahlBooteMitLizenz++;
                    }
                }
            }
            return anzahlBooteMitLizenz;
        } else {
            return -99;
        }
    }

    public void sortieren() {
        boote.sort(null);
    }

    public void sortierenNachBezeichnung() {
        boote.sort(new bezeichnungComparable());
    }

    public int zaehleEventBoote() {
        int count = 0;
        for (Boot k : boote) {
            if (k instanceof Eventboot)
                count++;

        }
        return count;
    }
}




