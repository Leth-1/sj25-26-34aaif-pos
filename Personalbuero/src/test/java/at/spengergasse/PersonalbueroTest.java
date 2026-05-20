package at.spengergasse;

import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;


class PersonalbueroTest {

    private Personalbuero personalbuero;
    private Arzt arzt;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.personalbuero = new Personalbuero();
        this.arzt = new Arzt("Hr.Mohamad", Year.of(2006), Year.now(), 12, 120.0);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

//    @Test
//    void testMitarbeiter() {
//        Mitarbeiter mitarbeiter = new Mitarbeiter("Anna", Year.of(2001), Year.now());
//        System.out.println(mitarbeiter);
//    }

    @Test
    void testKuendigenAlle_sollFunktionieren_dreiMA_zweiHubert_returns2() {
        // given
        Personalbuero personalbuero = new Personalbuero();
        Mitarbeiter ma1 = new Angestellter("Hubert", Year.of(2000), Year.now());
        Mitarbeiter ma3 = new Angestellter("Hubert", Year.of(2001), Year.now());
        Mitarbeiter ma2 = new Angestellter("Anna", Year.of(2000), Year.now());
        //System.out.println(ma1.getClass());
        personalbuero.aufnehmen(ma1);
        personalbuero.aufnehmen(ma2);
        personalbuero.aufnehmen(ma3);
        System.out.println(personalbuero);
        System.out.println();
        assertEquals(3, personalbuero.zaehleMitarbeiter());
        // when
        int ergebnis = personalbuero.kuendigenAlle("Hubert"); // 2
        // then
        assertEquals(2, ergebnis);
        assertEquals(1, personalbuero.zaehleMitarbeiter());
        System.out.println(personalbuero);
        System.out.println();
    }

    @Test
    void testKuendigenAlle_sollFunktionieren_einMA_einHubert_returns1() {
        // given
        Personalbuero personalbuero = new Personalbuero();
        Mitarbeiter ma1 = new Angestellter("Hubert", Year.of(2000), Year.now());
        personalbuero.aufnehmen(ma1);
        System.out.println(personalbuero);
        System.out.println();
        assertEquals(1, personalbuero.zaehleMitarbeiter());
        // when
        int ergebnis = personalbuero.kuendigenAlle("Hubert"); // 1
        // then
        assertEquals(1, ergebnis);
        assertEquals(0, personalbuero.zaehleMitarbeiter());
        System.out.println(personalbuero);
        System.out.println();
    }

    @Test
    void testAngestellter() {
        Angestellter angestellter = new Angestellter("Anna", Year.of(2001), Year.now());
        System.out.println(angestellter);
    }

    @Test
    void testPersonalbuero_aufnehmenAngestellter_returnsTrue() {
        Angestellter angestellter = new Angestellter("Anna", Year.of(2001), Year.now());
        System.out.println(angestellter);
        Personalbuero personalbuero = new Personalbuero();
        assertTrue(personalbuero.aufnehmen(angestellter));
        System.out.println(personalbuero);
    }

    @Test
    void testPersonalbuero_aufnehmenFreelancer_returnsTrue() {
        Freelancer freelancer = new Freelancer();
        System.out.println(freelancer);
        Personalbuero personalbuero = new Personalbuero();
        assertTrue(personalbuero.aufnehmen(freelancer));
        System.out.println(personalbuero);
    }

    @Test
    void testAufnehmen_eineAngestellte_doppeltesAufnehmen_returnFalse() {
        // given
        Mitarbeiter mitarbeiter1 = new Angestellter("Anna", Year.of(2000), Year.now().minusYears(1));
        Personalbuero personalbuero = new Personalbuero();
        assertTrue(personalbuero.aufnehmen(mitarbeiter1));
        // when then
        assertFalse(personalbuero.aufnehmen(mitarbeiter1));
        System.out.println(personalbuero); // 1 MitarbeiterIn in der Liste mit Prämie
        System.out.println();
    }

    @Test
    void testAufnehmen_zweiAngestellteAnna_doppeltesAufnehmen_returnFalse() {
        // given
        Personalbuero personalbuero = new Personalbuero();

        Mitarbeiter mitarbeiterAnna1 = new Angestellter("Anna", Year.of(2000), Year.now().minusYears(1));
        System.out.println(mitarbeiterAnna1);
        assertTrue(personalbuero.aufnehmen(mitarbeiterAnna1));

        Mitarbeiter mitarbeiterAnna2 = new Angestellter("Anna", Year.of(2000), Year.now().minusYears(1));
        System.out.println(mitarbeiterAnna2);
        System.out.println();

        // when then
        assertFalse(personalbuero.aufnehmen(mitarbeiterAnna2));
        System.out.println(personalbuero); // 1 MitarbeiterIn in der Liste mit Prämie
        System.out.println();
    }

    @Test
    void testBerechneGehaltFreelancer_defaultFreelancer_returns1000Komma0() {
        // given
        Freelancer freelancer = new Freelancer();
        // when
        double ergebnis = freelancer.berechneGehalt();
        double erwartet = freelancer.getStunden() * freelancer.getStundenSatz(); // 1000.0
        // then
        assertEquals(erwartet, ergebnis);
    }

    @Test
    void testFreenlacerAufnehmen_defaultFreelancer_returnsTrue() {
        // given
        Personalbuero personalbuero = new Personalbuero();
        Mitarbeiter freelancer = new Freelancer();
        // when then
        assertTrue(personalbuero.aufnehmen(freelancer));
        System.out.println(personalbuero);
    }

    @Test
    void testAufnehmen_sollNichtFunktionieren_einAngestellter_einFreelancer_doppelt_returnsFalse() {
        // given
        Personalbuero personalbuero = new Personalbuero();
        Mitarbeiter ma1 = new Angestellter("Hubert", Year.of(2000), Year.now());
        Mitarbeiter ma2 = new Freelancer();

        // when
        assertTrue(personalbuero.aufnehmen(ma1));
        assertTrue(personalbuero.aufnehmen(ma2));
        assertFalse(personalbuero.aufnehmen(ma2));

        // then
        assertEquals(2, personalbuero.zaehleMitarbeiter());
        System.out.println(personalbuero);
        System.out.println();
    }

    @Test
    void testAufnehmen_sollFunktionieren_einAngestellter_zweiFreelancer_nichtInhaltsgleichBeiFreelancerAttributen_returnsTrue() {
        // given
        Personalbuero personalbuero = new Personalbuero();
        Mitarbeiter ma1 = new Angestellter("Hubert", Year.of(2000), Year.now());
        Mitarbeiter ma2 = new Freelancer("Zazei", Year.of(2005), Year.now(), 10.0, 10);
        Mitarbeiter ma3 = new Freelancer("Zazei", Year.of(2005), Year.now(), 100.0, 10);

        // when
        assertTrue(personalbuero.aufnehmen(ma1));
        assertTrue(personalbuero.aufnehmen(ma2));
        assertTrue(personalbuero.aufnehmen(ma3));

        // then
        assertEquals(3, personalbuero.zaehleMitarbeiter());
        System.out.println(personalbuero);
        System.out.println();
    }

    @Test
    void testAufnehmen_sollNichtFunktionieren_einAngestellter_einFreelancer_inhaltsgleicherFreelancer_returnsFalse() {
        // given
        Personalbuero personalbuero = new Personalbuero();
        Mitarbeiter ma1 = new Angestellter("Hubert", Year.of(2000), Year.now());
        Mitarbeiter ma2 = new Freelancer();
        System.out.println("ma2: " + ma2);
        Mitarbeiter ma3 = new Freelancer();
        System.out.println("ma3: " + ma3);

        // when
        assertTrue(personalbuero.aufnehmen(ma1));
        assertTrue(personalbuero.aufnehmen(ma2));
        assertFalse(personalbuero.aufnehmen(ma3));

        // then
        assertEquals(2, personalbuero.zaehleMitarbeiter());
        System.out.println(personalbuero);
        System.out.println();
    }

    @Test
    void testGehaltsliste_sollFunktionieren_einAngestellter_zweiFreelancer_returnsTrue() {
        // given
        Personalbuero personalbuero = new Personalbuero();
        Mitarbeiter ma1 = new Angestellter("Hubert", Year.of(2000), Year.now());
        Mitarbeiter ma2 = new Freelancer("Zazei", Year.of(2005), Year.now(), 10.0, 10);
        Mitarbeiter ma3 = new Freelancer("Zazei", Year.of(2005), Year.now(), 100.0, 10);
        assertTrue(personalbuero.aufnehmen(ma1));
        assertTrue(personalbuero.aufnehmen(ma2));
        assertTrue(personalbuero.aufnehmen(ma3));
        assertEquals(3, personalbuero.zaehleMitarbeiter());
        // when then
        assertEquals(2600.0, personalbuero.berechneGehaltsumme());
        personalbuero.gehaltsListe();
        System.out.println();
    }

    @Test
    void testPersonalbuero_sollFunktionieren_dreiAngestellte_eineAerztin() {
        // given
        Personalbuero personalbuero = new Personalbuero();
        Mitarbeiter mitarbeiter = new Angestellter("Alfred", Year.of(2000), Year.now());
        Mitarbeiter mitarbeiter1 = new Angestellter("Alfred1", Year.of(2000), Year.now());
        Mitarbeiter mitarbeiter2 = new Angestellter("Alfred2", Year.of(2000), Year.now());
        Arzt arzt = new Arzt("Anna", Year.of(1999), Year.now(), 10, 1000.0);
        personalbuero.aufnehmen(mitarbeiter);
        personalbuero.aufnehmen(mitarbeiter1);
        personalbuero.aufnehmen(mitarbeiter2);
        personalbuero.aufnehmen(arzt);
        // when, then
        assertEquals(4, personalbuero.zaehleMitarbeiter());
        personalbuero.gehaltsListe();  // vier Mitarbeiter, 5500.0
    }

    @Test
    void testSortierenNachName_einAngestellterHubert_einFreelancerAnna_sollFunktionieren_returnTrue() {
        // given
        Personalbuero personalbuero = new Personalbuero();
        Mitarbeiter ma1 = new Angestellter("Hubert", Year.of(2000), Year.now());
        Mitarbeiter ma2 = new Freelancer();
        assertTrue(personalbuero.aufnehmen(ma1));
        assertTrue(personalbuero.aufnehmen(ma2));
        System.out.println(personalbuero); // Hubert, Anna
        System.out.println();
        // when
        boolean ergebnis = personalbuero.sortierenNachName();
        // then
        assertTrue(ergebnis);
        System.out.println(personalbuero); // Anna, Hubert
        System.out.println();
    }

    @Test
    void testArzt() {
        System.out.println(arzt);
        System.out.println();
        assertEquals(10.0, arzt.berechneStundensatz());
        assertEquals(120.0, arzt.berechneGehalt());
        assertTrue(personalbuero.aufnehmen(arzt));
        personalbuero.gehaltsListe();
    }

    // NEU
    @Test
    void testArztGettersSetters_sollNichtFunktionieren_throwsException() {
        System.out.println(arzt);
        System.out.println();
        assertEquals(12.0, arzt.getWochenStunden());
        assertEquals(120.0, arzt.getFixum());
        try {
            arzt.setWochenStunden(0);
            fail();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            arzt.setFixum(0);
            fail();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        assertEquals(12.0, arzt.getWochenStunden());
        assertEquals(120.0, arzt.getFixum());
        System.out.println(arzt);
        System.out.println();
    }

    // NEU
    @Test
    void testZaehleAngestellte_sollNichtFunktionieren_leeresPersonalbuero_returnsMinus99() {
        assertEquals(-99, personalbuero.zaehleAngestellte());
    }

    // NEU
    @Test
    void testZaehleAngestellte_sollFunktionieren_zweiAngestellteEinArzt_returns2() {
        Mitarbeiter ma1 = new Angestellter("Hubert", Year.of(2000), Year.now());
        Mitarbeiter ma2 = new Angestellter("Anna", Year.of(2001), Year.now());
        personalbuero.aufnehmen(ma1);
        personalbuero.aufnehmen(ma2);
        personalbuero.aufnehmen(arzt);
        assertEquals(3, personalbuero.zaehleMitarbeiter());
        assertEquals(2, personalbuero.zaehleAngestellte());
    }

    // NEU
    @Test
    void testBerechneDurchschnittsalter_sollNichtFunktionieren_leeresPersonalbuero_returnsMinus99Komma0() {
        assertEquals(-99.0, personalbuero.berechneDurchschnittsalter());
    }

    // NEU
    @Test
    void testBerechneDurchschnittsalter_sollFunktionieren_zweiAngestellteEinArzt_returns23Komma666() {
        Mitarbeiter ma1 = new Angestellter("Hubert", Year.of(2000), Year.now());
        Mitarbeiter ma2 = new Angestellter("Anna", Year.of(2001), Year.now());
        personalbuero.aufnehmen(ma1);
        personalbuero.aufnehmen(ma2);
        personalbuero.aufnehmen(arzt);
        System.out.println(personalbuero);
        System.out.println();
        assertEquals(3, personalbuero.zaehleMitarbeiter());
        assertEquals(23.666, personalbuero.berechneDurchschnittsalter(), 0.001);
    }

    // NEU
    @Test
    void testZaehleAlter_sollNichtFunktionieren_leeresPersonalbuero_returnsMinus99() {
        assertEquals(0, personalbuero.zaehleMitarbeiter());
        assertEquals(-99, personalbuero.zaehleAlter(19));
    }

    // NEU
    @Test
    void testZaehleAlter_sollFunktionieren_zweiAngestellteEinArzt20_returns1() {
        Mitarbeiter ma1 = new Angestellter("Hubert", Year.of(2000), Year.now());
        Mitarbeiter ma2 = new Angestellter("Anna", Year.of(2001), Year.now());
        personalbuero.aufnehmen(ma1);
        personalbuero.aufnehmen(ma2);
        personalbuero.aufnehmen(arzt);
        System.out.println(personalbuero);
        System.out.println();
        assertEquals(3, personalbuero.zaehleMitarbeiter());
        assertEquals(1, personalbuero.zaehleAlter(20));
    }

    // NEU
    @Test
    void testZaehleAlter_sollFunktionieren_zweiAngestellteEinArztKeine19_returns0() {
        Mitarbeiter ma1 = new Angestellter("Hubert", Year.of(2000), Year.now());
        Mitarbeiter ma2 = new Angestellter("Anna", Year.of(2001), Year.now());
        personalbuero.aufnehmen(ma1);
        personalbuero.aufnehmen(ma2);
        personalbuero.aufnehmen(arzt);
        System.out.println(personalbuero);
        System.out.println();
        assertEquals(3, personalbuero.zaehleMitarbeiter());
        assertEquals(0, personalbuero.zaehleAlter(19));
    }

    // NEU
    @Test
    void testKuendigenDouble_sollNichtFunktionieren_leeresPersonalbuero_throwsException() {
        try {
            personalbuero.kuendigen(0.0);
            fail();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // NEU
    @Test
    void testKuendigenDouble_sollFunktionieren_einFreelacer_returnsGehalt() {
        Freelancer freelancer = new Freelancer();
        assertTrue(personalbuero.aufnehmen(freelancer));
        double gehalt = freelancer.berechneGehalt();
        try {
            assertEquals(gehalt, personalbuero.kuendigen(gehalt - 0.1));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            fail();
        }
        assertEquals(0, personalbuero.zaehleMitarbeiter());
    }

    // NEU
    @Test
    void testKuendigenIndex_sollNichtFunktionieren_leeresPersonalbuero_throwsException() {
        try {
            personalbuero.kuendigen(-1);
            fail();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // NEU
    @Test
    void testKuendigenIndex_sollFunktionieren_einFreelacer_returnsFreelacer() {
        Mitarbeiter mitarbeiter = new Freelancer();
        assertTrue(personalbuero.aufnehmen(mitarbeiter));
        try {
            assertEquals(mitarbeiter, personalbuero.kuendigen(0));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            fail();
        }
        assertEquals(0, personalbuero.zaehleMitarbeiter());
    }

    // NEU
    @Test
    void testKuendigenString_sollNichtFunktionieren_leeresPersonalbuero_returnsFalse() {
        assertFalse(personalbuero.kuendigen("Anna"));
    }

    // NEU
    @Test
    void testKuendigenMitarbeiter_sollNichtFunktionieren_leeresPersonalbuero_returnsFalse() {
        Mitarbeiter mitarbeiter = new Freelancer();
        assertFalse(personalbuero.kuendigen(mitarbeiter));
    }

    // NEU
    @Test
    void testKuendigenString_sollNichtFunktionieren_null_throwsException() {
        try {
            assertFalse(personalbuero.kuendigen((String) null));
            fail();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // NEU
    @Test
    void testKuendigenMitarbeiter_sollNichtFunktionieren_null_throwsException() {
        try {
            assertFalse(personalbuero.kuendigen((Mitarbeiter) null));
            fail();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }


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




}