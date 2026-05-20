package at.spengergasse;

public static void main(String[] args) {
    System.out.println("╔════════════════════════════════════════════╗");
    System.out.println("║   SMART HOME - HEIZUNGSSTEUERUNG          ║");
    System.out.println("║   24-Stunden Temperaturanalyse             ║");
    System.out.println("╚════════════════════════════════════════════╝\n");

    // Smart Home System erstellen
    SmartHome heizung = new SmartHome();

    // Temperaturen generieren
    heizung.generiereTemperaturen();

    // Alle Temperaturen anzeigen
    heizung.zeigeTemperaturen();

    // Statistiken berechnen
    heizung.findeMinimaltemperatur();
    heizung.findeMaximaltemperatur();
    heizung.berechneDurchschnitt();

    // Heizphasen finden
    heizung.findeHeizphasen();

    // Schwellenwert-Analyse (z.B. 20°C)
    heizung.pruefeSchwellenwert(20.0);

    System.out.println("╔════════════════════════════════════════════╗");
    System.out.println("║   Analyse abgeschlossen!                   ║");
    System.out.println("╚════════════════════════════════════════════╝");
}
