package at.spengergasse;

public class bezeichnungComparable implements java.util.Comparator<Boot> {
    @Override
    public int compare(Boot o1, Boot o2) {
        return o1.getBezeichnung().compareTo(o2.getBezeichnung());
    }
}
