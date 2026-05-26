package at.spengergasse;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
            throw new TanzschuleException("Fehler.");
        }
        this.name = name;
    }

    public boolean hinzufuegen(Kurs kurs) {
        if (kurs == null || kurse.contains(kurs)) {
            return false;
        }
        return kurse.add(kurs);
    }

    public void sortierenNachPreis() {
        kurse.sort((o1, o2) -> Double.compare(o1.preis(), o2.preis()));
    }


    public void saveKurse() throws TanzschuleException {
        String filepath = "src/main/resources/kurse.csv";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {
            oos.writeObject(kurse);
        } catch (FileNotFoundException e) {
            throw new TanzschuleException("Fehler" + e.getMessage());
        } catch (IOException e) {
            throw new TanzschuleException("Fehler beim Eingabe/Ausgabe" + filepath + e.getMessage());
        }
    }

    public void importKurseCSV() throws TanzschuleException {
        String filepath = "src/main/resources/kurse.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] linePart = line.split(";");
                if (linePart.length >= 3) {
                    if (linePart[0].trim().equals("Privatkurs")) {
                        hinzufuegen(new Privatkurs(linePart));
                    }

                    if (linePart[0].trim().equals("Gruppenkurs")) {
                        hinzufuegen(new Gruppenkurs(linePart));
                    }
                }
            }

        } catch (FileNotFoundException e) {
            throw new TanzschuleException(e.getMessage());
        } catch (IOException e) {
            throw new TanzschuleException("Fehler" + e.getMessage());

        }
    }

    public void exportPrivatKurseCSV() throws TanzschuleException {
        String filepath = "src/main/resources/privatKurse.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            for (Kurs kurs : kurse) {
                if (kurs instanceof Privatkurs) {
                    bw.write(kurs.ToCSVString());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new TanzschuleException("Fehler" + e.getMessage());
        }
    }


    public String ToCSV() {
        StringBuilder sb = new StringBuilder();
        for (Kurs kurs : kurse) {
            sb.append(kurs.ToCSVString()).append("\n");
        }
        return sb.toString();
    }

}
