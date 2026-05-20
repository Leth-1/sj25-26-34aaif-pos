package at.spengergasse;

import java.util.ArrayList;
import java.util.Collections;

public class Playlist {

    public class PlaylistManagement {
        private ArrayList<Song> songs;

        public PlaylistManagement() {
            songs = new ArrayList<>();
        }

        public void songHinzufuegen(Song song) {
            if (song != null) {
                songs.add(song);
            }
        }

        public ArrayList<Song> filterNachGenre(String genre) {
            ArrayList<Song> gefiltert = new ArrayList<>();
            for (Song song : songs) {
                if (song.getGenre().equalsIgnoreCase(genre)) {
                    gefiltert.add(song);
                }
            }
            return gefiltert;
        }

        public void shuffle() {
            Collections.shuffle(songs);
        }

        public void entferneDuplikate() {
            ArrayList<Song> ohneD = new ArrayList<>();
            for (Song song : songs) {
                if (!ohneD.contains(song)) {
                    ohneD.add(song);
                }
            }
            songs = ohneD;
        }

        public int anzahlSongs() {
            return songs.size();
        }

        @Override
        public String toString() {
            if (songs.isEmpty()) {
                return "Playlist ist leer.";
            }

            StringBuilder sb = new StringBuilder();
            sb.append("=== Playlist ===\n");
            for (int i = 0; i < songs.size(); i++) {
                sb.append((i + 1)).append(". ").append(songs.get(i)).append("\n");
            }
            sb.append("Anzahl Songs: ").append(songs.size());
            return sb.toString();
        }
    }
}
