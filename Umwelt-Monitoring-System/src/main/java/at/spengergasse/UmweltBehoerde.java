package at.spengergasse;

import java.util.ArrayList;

public class UmweltBehoerde {
    private ArrayList<Messstation> messstationen;

    public UmweltBehoerde() {
        messstationen = new ArrayList<>();
    }

    public boolean addMesstation(Messstation m) {
        if (m == null || messstationen.contains(m)) return false;
        return messstationen.add(m);
    }

    public double berechneDurschnittMesswer() {
        if (messstationen.isEmpty()) {
            return 0.0;
        }
        double summe = 0.0;
        for (Messstation m : messstationen) {
            summe += m.getMesswert();
        }
        return summe / messstationen.size();
    }

    public double berechneDurchschnittLuftmessstationen() {
        if (messstationen.isEmpty()) {
            return 0.0;
        }
        double summe1 = 0.0;
        for (Messstation m : messstationen) {
            if (m instanceof Luftmessstation) {
                summe1 += m.getMesswert();
            }
        }
        return summe1 / messstationen.size();
    }

    public double berechneDurchschnittLaermmessstationen() {
        if (messstationen.isEmpty()) {
            return 0.0;
        }
        double summe2 = 0.0;
        for (Messstation m : messstationen) {
            if (m instanceof Laermmesstation) {
                summe2 += m.getMesswert();
            }

        }
        return summe2 / messstationen.size();
    }

    public double berechneDurchschnittWetterstation() {
        if (messstationen.isEmpty()) {
            return 0.0;
        }
        double summe3 = 0.0;
        for (Messstation m : messstationen) {
            if (m instanceof Wetterstation) {
                summe3 += m.getMesswert();
            }

        }
        return summe3 / messstationen.size();
    }

    public void sortiereMessstationen() {
        messstationen.sort(null);
    }

    public void zeigeAlleStationen() {
        for (Messstation m : messstationen) {
            System.out.println(m);
        }
    }

    public void zeigeNurLuftmessstationen() {
        for (Messstation m : messstationen) {
            if (m instanceof Luftmessstation) {
                System.out.println(m);
            }
        }
    }

    public void zeigeNurlaermmessstationen() {
        for (Messstation m : messstationen) {
            if (m instanceof Laermmesstation) {
                System.out.println(m);
            }
        }
    }

    public void zeigeStationenMitGrenzwertUeberschreitung() {
        for (Messstation m : messstationen) {
            if (m instanceof Luftmessstation) {
                if ((((Luftmessstation) m).getFeinstaubGrenzwert() < m.getMesswert())) {
                    System.out.println(m + "\n" + m.getMesswert() + ((Luftmessstation) m).getFeinstaubGrenzwert()
                            + (m.getMesswert() - ((Luftmessstation) m).getFeinstaubGrenzwert()));
                }
            }
        }
    }
}


