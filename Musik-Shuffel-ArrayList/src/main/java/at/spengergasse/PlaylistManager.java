package at.spengergasse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// Song-Klasse
class Song {
    private String titel;
    private String artist;
    private String genre;
    private int dauer; // in Sekunden

    public Song(String titel, String artist, String genre, int dauer) {
        this.titel = titel;
        this.artist = artist;
        this.genre = genre;
        this.dauer = dauer;
    }

    // Getter-Methoden
    public String getTitel() {
        return titel;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getDauer() {
        return dauer;
    }

    // Song als String formatieren
   //// public String toString() {
       // int minuten = dauer / 60;
     //   int sekunden = dauer % 60;
       // return String.format("%-25s | %-20s | %-15s | %d:%02d",
      //          titel, artist, genre, minuten, sekunden);
    //}

    // Für Duplikat-Erkennung: Songs sind gleich wenn Titel UND Artist gleich sind
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Song song = (Song) obj;
        return titel.equalsIgnoreCase(song.titel) && artist.equalsIgnoreCase(song.artist);
    }

    @Override
    public int hashCode() {
        return titel.toLowerCase().hashCode() + artist.toLowerCase().hashCode();
    }
}

// Playlist-Manager Klasse
public class PlaylistManager {
    private ArrayList<Song> playlist;
    private String playlistName;

    public PlaylistManager(String playlistName) {
        this.playlistName = playlistName;
        this.playlist = new ArrayList<>();
    }

    // Aufgabe 1: Songs hinzufügen
    public void songHinzufuegen(Song song) {
        playlist.add(song);
        System.out.println("Song hinzugefügt: " + song.getTitel());
    }

    public void songHinzufuegen(String titel, String artist, String genre, int dauer) {
        Song song = new Song(titel, artist, genre, dauer);
        playlist.add(song);
        System.out.println("✓ Song hinzugefügt: " + titel);
    }

    // Aufgabe 2: Nach Genre filtern
    public ArrayList<Song> nachGenreFiltern(String genre) {
        ArrayList<Song> gefiltert = new ArrayList<>();

        for (Song song : playlist) {
            if (song.getGenre().equalsIgnoreCase(genre)) {
                gefiltert.add(song);
            }
        }

        return gefiltert;
    }

    // Alternative mit removeIf (filtert direkt die Playlist)
    public void nurGenreBehalten(String genre) {
        int vorher = playlist.size();
        playlist.removeIf(song -> !song.getGenre().equalsIgnoreCase(genre));
        int nachher = playlist.size();
        System.out.println("→ " + (vorher - nachher) + " Songs entfernt, " + nachher + " Songs behalten");
    }

    // Aufgabe 3: Shuffle implementieren (Collections.shuffle)
    public void shufflePlaylist() {
        System.out.println("\n🔀 Playlist wird gemischt...");
        Collections.shuffle(playlist);
        System.out.println("✓ Playlist erfolgreich gemischt!\n");
    }

    // Shuffle manuell implementieren (Elemente tauschen)
    public void shuffleManuell() {
        System.out.println("\n🔀 Playlist wird manuell gemischt...");
        Random rand = new Random();

        // Fisher-Yates Shuffle Algorithmus
        for (int i = playlist.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            // Elemente tauschen
            Song temp = playlist.get(i);
            playlist.set(i, playlist.get(j));
            playlist.set(j, temp);
        }

        System.out.println("✓ Playlist erfolgreich gemischt (manuell)!\n");
    }

    // Aufgabe 4: Duplikate entfernen
    public void duplikateEntfernen() {
        int vorher = playlist.size();
        ArrayList<Song> ohneeDuplikate = new ArrayList<>();

        for (Song song : playlist) {
            if (!ohneeDuplikate.contains(song)) {
                ohneeDuplikate.add(song);
            }
        }

        int entfernt = vorher - ohneeDuplikate.size();
        playlist = ohneeDuplikate;

        System.out.println("🗑️  " + entfernt + " Duplikat(e) entfernt");
    }

    // Song nach Titel suchen
    public Song songSuchen(String titel) {
        for (Song song : playlist) {
            if (song.getTitel().equalsIgnoreCase(titel)) {
                return song;
            }
        }
        return null;
    }

    // Song entfernen
    public boolean songEntfernen(String titel) {
        return playlist.removeIf(song -> song.getTitel().equalsIgnoreCase(titel));
    }

    // Gesamtdauer der Playlist berechnen
    public void zeigeGesamtdauer() {
        int gesamtSekunden = 0;
        for (Song song : playlist) {
            gesamtSekunden += song.getDauer();
        }

        int stunden = gesamtSekunden / 3600;
        int minuten = (gesamtSekunden % 3600) / 60;
        int sekunden = gesamtSekunden % 60;

        System.out.printf("⏱️  Gesamtdauer: %d:%02d:%02d (%d Songs)\n", stunden, minuten, sekunden, playlist.size());
    }

    // Playlist anzeigen
    public void playlistAnzeigen() {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("🎵 PLAYLIST: " + playlistName);
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        if (playlist.isEmpty()) {
            System.out.println("  (Playlist ist leer)");
        } else {
            System.out.println("Titel                     | Artist               | Genre           | Dauer");
            System.out.println("─────────────────────────────────────────────────────────────────────────────");

            for (int i = 0; i < playlist.size(); i++) {
                System.out.printf("%2d. %s\n", i + 1, playlist.get(i));
            }
        }

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }

    // Statistik nach Genre
    public void genreStatistik() {
        System.out.println("\n📊 GENRE-STATISTIK:");
        ArrayList<String> genres = new ArrayList<>();

        // Alle einzigartigen Genres sammeln
        for (Song song : playlist) {
            if (!genres.contains(song.getGenre())) {
                genres.add(song.getGenre());
            }
        }

        // Für jedes Genre zählen
        for (String genre : genres) {
            int anzahl = 0;
            for (Song song : playlist) {
                if (song.getGenre().equalsIgnoreCase(genre)) {
                    anzahl++;
                }
            }
            System.out.printf("  %-15s: %d Songs\n", genre, anzahl);
        }
        System.out.println();
    }
}
