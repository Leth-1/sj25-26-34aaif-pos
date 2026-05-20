package at.spengergasse;

import java.time.LocalDate;

public class Product {
    private String name;
    private int bestand;
    private double preis;
    private LocalDate ablaufdatum;

    public Product(String name, int bestand, double preis, LocalDate ablaufdatum) {
        this.name = name;
        this.bestand = bestand;
        this.preis = preis;
        this.ablaufdatum = ablaufdatum;
    }

    public String getName() {
        return name;
    }

    public int getBestand() {
        return bestand;
    }

    public void setBestand(int bestand) {
        if (bestand >= 0) {
            this.bestand = bestand;
        }
    }

    public double getPreis() {
        return preis;
    }

    public LocalDate getAblaufdatum() {
        return ablaufdatum;
    }

    public boolean istAbgelaufen() {
        return ablaufdatum.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return String.format("%s | Bestand: %d | Preis: %.2f EUR | Ablauf: %s%s",
                name, bestand, preis, ablaufdatum,
                istAbgelaufen() ? " (ABGELAUFEN!)" : "");
    }
}