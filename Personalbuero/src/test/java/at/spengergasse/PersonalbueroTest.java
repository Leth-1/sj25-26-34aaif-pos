package at.spengergasse;

import org.junit.jupiter.api.Test;

import java.time.Year;


class PersonalbueroTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

//    @Test
//    void testMitarbeiter(){
//        Angestellter mitarbeiter = new Angestellter("Anna", Year.of(2001), Year.now());
//        System.out.println(mitarbeiter);
//    }

    // while (ausdruck) anweisung;
    // zbs int i = 0;
    // while ( i < 10) {
    // sout(i)
    // i = i+1;
    // }


    // do
    // anweisung;
    // while (ausdruck);

    //!!!
    // iter.hasNext()  iter.next()  iter.remove()
    // kommt bei PLF 100%


    @Test
    void testAngestellter() {
        Mitarbeiter angestellter = new Angestellter("Anna", Year.of(2001), Year.now());
        System.out.println(angestellter);
    }


}