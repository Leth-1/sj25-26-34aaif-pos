
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class StudentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StudentTest
{
    /**
     * Default constructor for test class StudentTest
     */
    public StudentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        System.out.println("executing setUp()");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        System.out.println("executing tearDown()");
    }

    @Test
    public void testGewichtsklasse_mann_untergewicht()
    {
        Student student = new Student ("Abudi", true, 200, 40);
        assertEquals("Untergewicht",student.gewichtsklasse());
    }

    @Test
    public void testGewichtsklasse_mann_normalgewicht()
    {
        Student student = new Student ("Abudi", true, 200, 90);
        assertEquals("Normalgewicht",student.gewichtsklasse());
    }

    @Test
    public void testGewichtsklasse_mann_uebergewicht()
    {
        Student student = new Student ("Abudi", true, 120, 150);
        assertEquals("Übergewicht",student.gewichtsklasse());
    }
      @Test
    public void testGewichtsklasse_F_untergewicht()
    {
        Student student = new Student ("Abudi", false, 200, 40);
        assertEquals("Untergewicht",student.gewichtsklasse());
    }

    @Test
    public void testGewichtsklasse_F_normalgewicht()
    {
        Student student = new Student ("Abudi", false, 200, 90);
        assertEquals("Normalgewicht",student.gewichtsklasse());
    }

    @Test
    public void testGewichtsklasse_F_uebergewicht()
    {
        Student student = new Student ("Abudi", false, 120, 150);
        assertEquals("Übergewicht",student.gewichtsklasse());
    }


    @Test
    public void testBMI_normalgewicht()
    {
        Student student = new Student ("Abudi", true, 190, 90);
        assertEquals(24.9,student.bmi(),0.1);
    }

    @Test
    public void testBMI_Übergewicht()
    {
        Student student = new Student ("Abudi", true, 190, 190);
        assertEquals(52.6,student.bmi(),0.1);
    }

    @Test
    public void testBMI_Untergewicht()

    {
        Student student = new Student ("Abudi", true, 190, 50);
        assertEquals(13.9,student.bmi(),0.1);
    }

    @Test
    public void testBMI_ÜbergewichtF()
    {
        Student student = new Student ("Abudi", false, 190, 190);
        assertEquals(52.6,student.bmi(),0.1);
    }

    @Test
    public void testBMI_NormalgewichtF()
    {
        Student student = new Student ("Abudi", false, 190, 190);
        assertEquals(52.6,student.bmi(),0.1);
    }

    @Test
    public void testBMI_UntergewichtF()
    {
        Student student = new Student ("Abudi", false, 190, 60);
        assertEquals(16.6,student.bmi(),0.1);
    }

}

