package at.spengergasse;

public class Song {
    private String titel;
    private String kuenstler;
    private String genre;
    private int dauerSekunden;

    public Song(String titel, String kuenstler, String genre, int dauerSekunden) {
        this.titel = titel;
        this.kuenstler = kuenstler;
        this.genre = genre;
        this.dauerSekunden = dauerSekunden;
    }

    public String getTitel() {
        return titel;
    }

    public String getKuenstler() {
        return kuenstler;
    }

    public String getGenre() {
        return genre;
    }

    public int getDauerSekunden() {
        return dauerSekunden;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Song song = (Song) obj;
        return titel.equals(song.titel) && kuenstler.equals(song.kuenstler);
    }

    @Override
    public String toString() {
        int minuten = dauerSekunden / 60;
        int sekunden = dauerSekunden % 60;
        return String.format("%s - %s [%s] (%d:%02d)",
                titel, kuenstler, genre, minuten, sekunden);
    }


}
