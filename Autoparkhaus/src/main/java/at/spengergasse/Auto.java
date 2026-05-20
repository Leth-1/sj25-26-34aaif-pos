package at.spengergasse;

public class Auto {

    private String kennzeichnen = "AB-123-CD";
    private String marke = "VW";
    private String farbe = "blau";

    public Auto() {
    }

    public Auto(String kennzeichnen, String marke, String farbe) {
        this.kennzeichnen = kennzeichnen;
        this.marke = marke;
        this.farbe = farbe;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public String getKennzeichnen() {
        return kennzeichnen;
    }

    public void setKennzeichnen(String kennzeichnen) {
        this.kennzeichnen = kennzeichnen;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Auto{");
        sb.append("kennzeichnen='").append(kennzeichnen).append('\'');
        sb.append(", marke='").append(marke).append('\'');
        sb.append(", farbe='").append(farbe).append('\'');
        sb.append('}');
        return sb.toString();
    }
    
}
