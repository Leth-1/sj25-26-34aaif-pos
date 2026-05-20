package at.spengergasse;

import at.spengergasse.WerkstoffException;
import at.spengergasse.Werkstoffprobe;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class WerkstoffprobeTest {}
/*
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void testWerkstoffprobe_shouldWork_noExceptionThrown() {
        try {
            Werkstoffprobe werkstoffprobe = new Werkstoffprobe("WZ-101", "Stahl S235", 7.85, 12.5);
            System.out.println();
            assertEquals("WZ-101", werkstoffprobe.getId());
            assertEquals("Stahl S235", werkstoffprobe.getBezeichnung());
            assertEquals(7.85, werkstoffprobe.getDichte());
            assertEquals(12.5, werkstoffprobe.getMasse());
            System.out.println(werkstoffprobe);
            System.out.println();
        } catch (WerkstoffException e) {
            System.out.println("Unerwartete Exception: " + e.getMessage());
            fail();
        }
    }


    @Test
    void testSetIdSetBezeichnung_shouldFail_null_throwsWerkstoffException() {
        try {
            new Werkstoffprobe(null, "Stahl S235", 7.85, 12.5);
            fail();
        } catch (WerkstoffException e) {
            System.out.println("Erwartete WerkstoffException: " + e.getMessage());
        }
        try {
            new Werkstoffprobe("WZ-101", null, 7.85, 12.5);
            fail();
        } catch (WerkstoffException e) {
            System.out.println("Erwartete WerkstoffException: " + e.getMessage());
        }
    }

    @Test
    void testSetDichteSetMasse_shouldFail_0Komma0_throwsWerkstoffException() {
        assertThrows(WerkstoffException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new Werkstoffprobe("WZ-101", "Stahl S235", 0.0, 12.5);
            }
        });
        // Test von Masse mit Lambda
        assertThrows(WerkstoffException.class, () -> new Werkstoffprobe("WZ-101", "Stahl S235", 7.85, 0.0));

        //Test von ID
        assertThrows(WerkstoffException.class, () ->, new Werkstoffprobe(null, "Test", 0.1, 0.1));
    }

}
 */