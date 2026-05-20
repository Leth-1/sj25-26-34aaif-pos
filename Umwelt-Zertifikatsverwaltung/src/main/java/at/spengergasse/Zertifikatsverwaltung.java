package at.spengergasse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Zertifikatsverwaltung {
    private List<UmweltZertifikat> zertifikate;

    public Zertifikatsverwaltung(List<UmweltZertifikat> zertifikate) {
        zertifikate = new ArrayList<>();
    }

    public void addZertifikat(UmweltZertifikat z) throws UmweltProjektException {
        if (z == null) {
            throw new UmweltProjektException("Fehler: null");
        }
        zertifikate.add(z);
    }

    public void druckeAlle() throws UmweltProjektException {
        if (zertifikate.isEmpty()) {
            throw new UmweltProjektException("Fehler: empty");
        }
        for (UmweltZertifikat u : zertifikate) {
            System.out.println(u);
        }
    }

    public void druckeScoreListe() {
        

}
