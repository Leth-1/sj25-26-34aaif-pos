package at.spengergasse;

import java.io.*;
import java.util.*;

public class Tanzschule {
    private String name;
    private List<Kurs> kurse;


    public Tanzschule(String name) throws TanzschuleException {
        setName(name);
        kurse = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws TanzschuleException {
        if (name == null || name.isBlank()) {
            throw new TanzschuleException("Fehler: name is null or leer!");
        }
    }

    public boolean hinzufuegen(Kurs kurs) {
        if (kurs == null) {
            try {
                throw new TanzschuleException("Fehler: darf nicht null sein!");
            } catch (TanzschuleException e) {
                throw new RuntimeException(e);
            }
        }
        if (kurse.contains(kurs)) {
            try {
                throw new TanzschuleException("Fehler: darf nicht null sein!");
            } catch (TanzschuleException e) {
                throw new RuntimeException(e);
            }
        }
        kurse.add(kurs);
        return true;
    }

    public void sortierenNachPreis() {
        kurse.sort((o1, o2) -> Double.compare(o1.preis(), o2.preis()));
    }

    public void saveKurs() throws TanzschuleException {
        String filepath = "src/main/resources/kurse.csv";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {
            oos.writeObject(kurse);
        } catch (FileNotFoundException e) {
            throw new TanzschuleException("Fehler mit Datei: " + filepath + ":" + e.getMessage());
        } catch (IOException e) {
            throw new TanzschuleException("Fehler mit Eingabe/Ausgabe: " + filepath + ":" + e.getMessage());
        }
    }

    public void writeKurseToCSV() throws TanzschuleException {
        String filepath = "src/main/resources/kurse.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            bw.write(this.toCSVString());
        } catch (FileNotFoundException e) {
            throw new TanzschuleException("Fehler mit Datei: " + filepath + ":" + e.getMessage());
        } catch (IOException e) {
            throw new TanzschuleException("Fehler mit Eingabe/Ausgabe: " + filepath + ":" + e.getMessage());
        }
    }
// BufferedWriter mit FileWriter verwenden
// try-with-resources damit Datei automatisch geschlossen wird
    // bw.write(this.toCSVSTRING())


    public void readKurseFromCSV() throws TanzschuleException {
        String filepath = "src/main/resources/kurse.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] linePart = line.split(";");
                if (linePart.length >= 3) {
                    if (linePart[0].trim().equals("PrivatKurs")) {
                        hinzufuegen(new PrivatKurs(linePart));
                    }
                    if (linePart[0].trim().equals("GruppenKurs")) {
                        hinzufuegen(new GruppenKurs(linePart));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new TanzschuleException("Fehler mit Datei: " + filepath + ":" + e.getMessage());
        } catch (IOException e) {
            throw new TanzschuleException("Eingabe/Ausgabe" + filepath + ":" + e.getMessage());
        }
    }

//
//1. Schleife
//
// while ((line = br.readLine()) != null) — nicht nur einmal lesen
//
//2. Zeile parsen
//
// Richtiges Trennzeichen (; oder ,?) — konsistent mit toCSVString()
// Genug Felder vorhanden (linePart.length >= erwartet)
// Leerzeichen trimmen (linePart[0].trim())
//
//3. Objekte erstellen
//
// Alle Typen abgedeckt (PrivatKurs, GruppenKurs, ...)
// Jeder Typ erstellt die richtige Klasse (kein new PrivatKurs für GruppenKurs)
// Konstruktor mit String[] existiert und validiert die Daten
//
//4. Liste befüllen
//
// hinzufuegen() wird aufgerufen
//
//5. Fehlerbehandlung
//
// FileNotFoundException → sinnvolle Fehlermeldung
// IOException → sinnvolle Fehlermeldung
// Fehler in einer Zeile → übrige Zeilen trotzdem einlesen?


    public String toCSVString() {
        StringBuilder sb = new StringBuilder();
        for (Kurs s : kurse) {
            sb.append(s.toCSVString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Tanzschule: " + "name: " + name + '\'' + ", kurse: " + kurse;
    }
}

