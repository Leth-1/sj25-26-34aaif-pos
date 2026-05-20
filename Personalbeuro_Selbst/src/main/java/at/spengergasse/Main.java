package at.spengergasse;

import java.time.Year;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Mitarbeiter mitarbeiter = new Mitarbeiter("Anna", Year.of(2001), Year.now());
        System.out.println(mitarbeiter);

        System.out.println();
        Personalbeuro personalbuero = new Personalbeuro();
        System.out.println();
        System.out.println(personalbuero.aufnehmen(null));
        System.out.println();
        System.out.println(personalbuero.aufnehmen(mitarbeiter));
        System.out.println(personalbuero);
        Mitarbeiter mitarbeiter1 = new Mitarbeiter("Hanna", Year.of(2002), Year.now());
        personalbuero.aufnehmen(mitarbeiter1);
        personalbuero.aufnehmen(mitarbeiter1);
        System.out.println(personalbuero);
        System.out.println();

    }
}
