package at.spengergasse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    void main() {
        try {
            testBetriebszertifikat();
            testZertifikatsverwaltung();
            testTopnachhaltigkeitsScore();
        } catch (UmweltProjektException e) {
            System.out.println("Unerwartete Exception: ops");
            System.out.println(e.getMessage());
        }

    }

    private void testTopnachhaltigkeitsScore() throws UmweltProjektException {
        ZertifikatsVerwaltung zertifikatsVerwaltung = new ZertifikatsVerwaltung();
        BetriebsZertifikat betriebsZertifikat =
                new BetriebsZertifikat
                        ("Z-2026-001", "GreenCity Festival", 20.0, 78.0, 10);

        zertifikatsVerwaltung.addZertifikat(betriebsZertifikat);
        for (UmweltZertifikat u : zertifikatsVerwaltung.listeTopNachhaltigkeitsScore()) {
            System.out.println(u);
        }
    }

    private static void testZertifikatsverwaltung() throws UmweltProjektException {
        ZertifikatsVerwaltung zertifikatsVerwaltung = new ZertifikatsVerwaltung();
        zertifikatsVerwaltung.druckAlle();

        BetriebsZertifikat betriebsZertifikat =
                new BetriebsZertifikat
                        ("Z-2026-001", "GreenCity Festival", 20.0, 78.0, 10);

        zertifikatsVerwaltung.addZertifikat(betriebsZertifikat);
        zertifikatsVerwaltung.druckAlle();
    }

    private static void testBetriebszertifikat() throws UmweltProjektException {

        BetriebsZertifikat betriebsZertifikat =
                new BetriebsZertifikat("Z-2026-001", "GreenCity Festival", 20.0, 78.0, 10);
        System.out.println(betriebsZertifikat);

    }
}
