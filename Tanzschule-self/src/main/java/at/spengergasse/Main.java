package at.spengergasse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws TanzschuleException {
        testSaveKurse();
        testExportPrivatKurseCSV();

    }

    private static void testExportPrivatKurseCSV() throws TanzschuleException {
        try {
            Tanzschule tanzschule = new Tanzschule("Da");
            tanzschule.hinzufuegen(new Privatkurs(60, 20.0));
            tanzschule.hinzufuegen(new Gruppenkurs(60, 50));
            tanzschule.exportPrivatKurseCSV();
            System.out.println("Export: ok");
        } catch (TanzschuleException e) {
            throw new TanzschuleException("Fehler" + e.getMessage());
        }
    }

    public static void testSaveKurse() throws TanzschuleException {
        try {
            Tanzschule tanzschule = new Tanzschule("Dance");
            tanzschule.hinzufuegen(new Privatkurs(2, 10.0));
            tanzschule.hinzufuegen(new Gruppenkurs(90, 20.0));
            tanzschule.saveKurse();
            System.out.println("Savekurs: ok");
        } catch (TanzschuleException e) {
            throw new TanzschuleException("Fehler" + e.getMessage());
        }
    }
}
