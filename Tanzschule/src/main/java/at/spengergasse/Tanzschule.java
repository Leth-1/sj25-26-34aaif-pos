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
        kurse.sort(Comparator.comparingDouble(Kurs::preis));
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


    public void readKurseFromCSV() throws TanzschuleException {
        String filepath = "src/main/resources/kurse.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line = br.readLine();
            if (line != null) {
                String[] linePart = line.split(";");
                if (linePart.length >= 3) {
                    if (linePart[0].trim().equals("PrivatKurs")) {
                        hinzufuegen(new PrivatKurs(linePart));
                    }
                    if (linePart[0].trim().equals("GruppenKurs")) {
                        hinzufuegen(new PrivatKurs(linePart));
                    }
                }
            } else {
                throw new TanzschuleException("Fehler");
            }
        } catch (FileNotFoundException e) {
            throw new TanzschuleException("Fehler mit Datei: " + filepath + ":" + e.getMessage());
        } catch (IOException e) {
            throw new TanzschuleException("Eingabe/Ausgabe" + filepath + ":" + e.getMessage());
        }
    }


    public String toCSVString() {
        StringBuilder sb = new StringBuilder();
        for (Kurs s : kurse) {
            sb.append(s.toCSVString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Tanzschule: " +
                "name: " + name + '\'' +
                ", kurse: " + kurse;
    }
}

