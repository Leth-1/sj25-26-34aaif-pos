package at.spengergasse;

public class PixelManipulation {
    private int[][] bild;
    private int breite;
    private int hoehe;

    public PixelManipulation(int breite, int hoehe) {
        this.breite = breite;
        this.hoehe = hoehe;
        this.bild = new int[hoehe][breite];
    }

    public void setPixel(int x, int y, int wert) {
        if (x >= 0 && x < breite && y >= 0 && y < hoehe) {
            // Clamping: Wert muss zwischen 0 und 255 liegen
            bild[y][x] = Math.max(0, Math.min(255, wert));
        }
    }

    public int getPixel(int x, int y) {
        if (x >= 0 && x < breite && y >= 0 && y < hoehe) {
            return bild[y][x];
        }
        return 0;
    }

    // Erhöht die Helligkeit aller Pixel
    public void erhoeheHelligkeit(int betrag) {
        for (int y = 0; y < hoehe; y++) {
            for (int x = 0; x < breite; x++) {
                int neuerWert = bild[y][x] + betrag;
                // Clamping bei 255!
                bild[y][x] = Math.min(255, neuerWert);
            }
        }
    }

    // Spiegelt das Bild horizontal
    public void spiegeleHorizontal() {
        for (int y = 0; y < hoehe; y++) {
            for (int x = 0; x < breite / 2; x++) {
                int temp = bild[y][x];
                bild[y][x] = bild[y][breite - 1 - x];
                bild[y][breite - 1 - x] = temp;
            }
        }
    }

    // Invertiert alle Pixel (255 - Wert)
    public void invertiere() {
        for (int y = 0; y < hoehe; y++) {
            for (int x = 0; x < breite; x++) {
                bild[y][x] = 255 - bild[y][x];
            }
        }
    }

    public int[][] getBild() {
        return bild;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("=== Bild %dx%d ===\n", breite, hoehe));
        for (int y = 0; y < hoehe; y++) {
            for (int x = 0; x < breite; x++) {
                sb.append(String.format("%3d ", bild[y][x]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}