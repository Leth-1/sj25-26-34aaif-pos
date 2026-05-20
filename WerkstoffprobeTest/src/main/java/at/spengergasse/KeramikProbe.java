package at.spengergasse;

public class KeramikProbe extends Werkstoffprobe {

    public KeramikProbe(String id, String bezeichnung, double dichte, double masse) throws WerkstoffException {
        super(id, bezeichnung, dichte, masse);
    }

    @Override
    public double qualitaetsIndex() {
        return getDichte() * 2;
    }

    @Override
    public String toString() {
        return "KeramikProbe [ " + super.toString()+ ", Volumen= "+
                 + ", Materialwert;";
    }
}
