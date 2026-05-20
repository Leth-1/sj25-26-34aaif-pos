package at.spengergasse;

import java.util.ArrayList;
import java.util.List;

public class ZertifikatsVerwaltung  {
    private List<UmweltZertifikat> zertifikate;

    public ZertifikatsVerwaltung() {
        zertifikate = new ArrayList<>();
    }

    public void addZertifikat(UmweltZertifikat z) throws UmweltProjektException {
        if (z == null) {
            throw new UmweltProjektException("Fehler: null");
        }
        zertifikate.add(z);
    }


    public void druckAlle() {
        if (zertifikate.isEmpty()) {
            System.out.println("keine Zertifikate vorhanden");
        } else {
            for (UmweltZertifikat u : zertifikate)
                System.out.println(u);
        }
    }

    public List<UmweltZertifikat> listeTopNachhaltigkeitsScore() throws UmweltProjektException {
      if (zertifikate.size() < 10){
          throw new UmweltProjektException("Fehler: klleiner als 10");
      }
        zertifikate.sort(null);
        zertifikate.reversed();
        int anzahlTop10Prozent = zertifikate.size() / 10;
        ArrayList<UmweltZertifikat> toplist = new ArrayList<>();
        for (int i = 0; i < anzahlTop10Prozent; i++){
            toplist.add(zertifikate.get(i));
        }
        return toplist;
    }
}
