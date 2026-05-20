package at.spengergasse;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Notizen {

    private List<String> notizen;

    //"Brot einkaufen"
    //"Video über Java-Streams ansehen"
    //"Geschenk für Petra besorgen"

    public Notizen() {
        notizen = new ArrayList<>();
    }

    public boolean notizHinzufuegen(String notiz) throws NotizException {
        if (notiz == null || notiz.isBlank()) {
            throw new NotizException("Fehler: null oder leer");
        }
        if (this.notizen.contains(notiz)) {
            return false;
        }
        return notizen.add(notiz);
    }

    public void sortierenAlphabetisch() {
        notizen.sort(null);
    }

    public void sortierenNachLaengeAbsteigend() {
        //Comparator<String> nachLaengeAbsteigendComparator = new LaengeComparator().reversed();
        notizen.sort(new LaengeComparator().reversed());
    }

    public void sortierenNachDerLaengeAufsteigend() {
        notizen.sort(new LaengeComparator());
    }

    public boolean notizEntfernen(String notiz) throws NotizException {
        if (!checkNotiz(notiz)) {
            throw new NotizException("Fehler: notiz ungültig");
        }
        return notizen.remove(notiz);
    }

    private boolean checkNotiz(String notiz) {
        return notiz != null && !notiz.isBlank();
    }

    public void ausgebenNotizen() {
        if (notizen.isEmpty()) {
            System.out.println("Keine Notizen vorhanden");
        } else {
            System.out.println("Meine Notizen: ");
            for (String notiz : notizen) {
                System.out.println(notiz);
            }
        }
    }

    // ----------------------- files -------------------------

    public void save() throws NotizException {
        String filepath = "src/main/resources/notizen.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath))) {
            oos.writeObject(notizen);
        } catch (FileNotFoundException e) {
            throw new NotizException("Datei " + filepath + " nicht gefunden: " + e.getMessage());
        } catch (IOException e) {
            throw new NotizException("I/O-Problem mit Datei " + filepath + ": " + e.getMessage());
        }
    }

    // alle Notizen sollen ersetzt werden!!!
    // Problem: "was passiert, wenn etwas passiert beim Reinladen"
    public void load() throws NotizException {
        String filepath = "src/main/resources/notizen.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath))) {
            // wegen Warning "unchecked cast":
            //<?> ich lasse den Typ einmal offen: Mitarbeiter, WerkstoffProben,... hoffentlich String
            List<?> notizenLoad = (List<?>) ois.readObject();

            // Backup von notizen erstellen
            ArrayList<String> notizenBackup = new ArrayList<>();
            Collections.copy(notizenBackup, notizen);

            // jetzt erst notizen löschen
            notizen.clear(); // alles weg!!!
            for (Object o : notizenLoad) {
                if (o instanceof String) {
                    notizen.add((String) o);
                } else {
                    // Ausgangszustand herstellen
                    notizen = notizenBackup;
                    throw new NotizException("Fehler mit den Notizen in " + filepath + ", andere Informationen gefunden");
                }
            }
        } catch (FileNotFoundException e) {
            throw new NotizException("Die Datei " + filepath + " kann nicht geladen werden: " + e.getMessage());
        } catch (IOException e) {
            throw new NotizException("I/O-Problem mit Datei " + filepath + ": " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new NotizException("Die Datei " + filepath + " enthält keine Notizen: " + e.getMessage());
        }
    }

    public void exportNotizen() throws NotizException {
        String filepath = "src/main/resources/exportNotizen.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filepath))) {
            bw.write(this.toString());
        } catch (IOException e) {
            throw new NotizException("Fehler beim Export: " + e.getMessage());
        }

    }

    public void immportNotizen() throws NotizException {
        String filepath = "src/main/resources/ImportNotizen.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line = br.readLine();
            if (line != null) {
                line.trim();
                String[] lineSplit = line.split(";");
                if (lineSplit.length > 0) {

                } else {
                    throw new NotizException("Datei");
                }

            }
        } catch (Exception e) {
            throw new NotizException("Fehler");
        }
    }

    public String toCSVString() {
        String delimiter = ";";
        StringBuilder sb = new StringBuilder();
        for (String s : notizen) {
            sb.append(s).append(delimiter);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Notizen:\n");
        if (notizen.isEmpty()) {
            sb.append("keine Notizen vorhanden");
        } else {
            for (String notiz : notizen) {
                sb.append(notiz).append("\n");
            }
        }
        return sb.toString();
    }


}
