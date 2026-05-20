package at.spengergasse;

import java.util.Random;

public class Person {
    public int id;
    private final Random rnd = new Random(40000);

    public Person(int id) {
        this.id = id;
    }

    public Person() {
        // Wir vergeben random
        Random rnd = new Random(4711);
        this.id = rnd.nextInt(1, 3001);
    }


}
