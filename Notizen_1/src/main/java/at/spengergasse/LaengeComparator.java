package at.spengergasse;

import java.util.Comparator;

public class LaengeComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if(o1.length() > o2.length()) {
            return 1;
        } else {
            if (o1.length() < o2.length() ){
                return -1;
            } else {
                //return 0; // hier könnte 2. Kriterum folgen, z.B. alphabetisch
                return o1.compareTo(o2); // 2. Kriterium alphabetisch
            }
        }
    }
}
