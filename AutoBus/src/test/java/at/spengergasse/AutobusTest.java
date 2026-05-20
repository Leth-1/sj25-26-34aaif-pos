package at.spengergasse;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class AutobusTest {

    static int busSize = 20;
    static int someSize = busSize / 2;
    Autobus bus;
    ArrayList<Person> persons;


    @BeforeEach
    public void setUp() {

        persons = new ArrayList<Person>();
        while (persons.size() < busSize);

        }


        @Test // es wird geprüft, ob NULL einsteigen darf
        public void testEinsteigenThrowsOnNull () {
            assertThrows(RuntimeException.class, () -> {
                bus.einsteigen(null);
            });
        }

        @Test // es wird geprüft, ob erkannt wird, wenn eine bereits drinnen Person einsteigen
        // soll.
        public void testEinsteigenThrowsOnAlreadyInside () {
            fillSome();
            assertThrows(RuntimeException.class, () -> {
                bus.einsteigen(persons[5]);
            });
        }

        @Test
        public void testEinsteigenBisVollSuccess () {
            for (int i = 0; i < busSize; i++) {
                assertTrue(bus.einsteigen(persons[i]));
            }
        }

        @Test
        public void testEinsteigenWhenFullFails () {
            fillFull();
            assertFalse(bus.einsteigen(persons[busSize]));
        }

        @Test
        public void testPersonInside () {
            fillSome();
            for (int i = 0; i < someSize; i++) {
                assertTrue(bus.istDrin(persons[i]));
            }
            for (int i = someSize; i < busSize; i++) {
                assertFalse(bus.istDrin(persons[i]));
            }
        }

        @Test
        public void testsetcap_soll_funktionieren_Autobus_leer () {
            // given
            Autobus autobus = new Autobus(50);
            Person person = new Person(2);
            //when
            boolean ergebniss = autobus.einsteigen(person);
            //wenn
            assertTrue(ergebniss);
        }

        @Test
        public void testsetcap_sollnicht_funktionieren_Autobus_leer_person_NUll () {
            // given
            Autobus autobus = new Autobus(50);
            //when
            try {
                autobus.einsteigen(null);
                fail();
            } catch (IllegalArgumentException e) {
                //wenn
                System.out.println(e.getMessage());
            }

        }

        @Test
        public void testsetcap_sollnicht_funktionieren_Autobus_1_person () {

        }


        @AfterEach
        public void tearDown () {
        }

        private void fillSome() {
            for (int i = 0; i < someSize; i++) {
                bus.einsteigen(persons[i]);
            }
        }

        private void fillFull () {
            for (int i = 0; i < busSize; i++) {
                bus.einsteigen(persons[i]);
            }
        }

    }
}
