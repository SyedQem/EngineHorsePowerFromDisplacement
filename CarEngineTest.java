import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * The CarEngineTest class contains unit tests for the CarEngine class.
 */

public class CarEngineTest {

    private static CarEngine defaultEngine;
    private static CarEngine customEngine;

    /**
     * Sets up the test environment before all tests.
     */

    @BeforeAll
    public static void setUp() {

        System.out.println("Starting tests now.");

    }

    /**
     * Initializes the CarEngine objects before each test.
     */

    @BeforeEach
    public void init(){
        defaultEngine = new CarEngine();
        customEngine = new CarEngine("TestCompany", 100, 500, 80, 90, 1);
    }

    /**
     * Tests the default constructor of the CarEngine class.
     */

    @Test
    public void testDefaultConstructor(){
        assertEquals(0, defaultEngine.getTorque());
        assertEquals(0, defaultEngine.getSpeed());
        assertEquals(0, defaultEngine.getBoreSize());
        assertEquals(0, defaultEngine.getStroke());
        assertEquals(0, defaultEngine.getNumCylinders());
        assertEquals(0, defaultEngine.getNumCylinders());
        assertEquals("Unknown", defaultEngine.getCompanyName());
        assertEquals(0.0f, defaultEngine.getHorsePower());
        assertEquals(0.0f, defaultEngine.getEngineDisplacement());

    }

    /**
     * Tests the overloaded constructor of the CarEngine class.
     */

    @Test
    public void testOverloadedConstructor() {
        assertEquals(100, customEngine.getTorque(), 0.01f);
        assertEquals(500, customEngine.getSpeed(), 0.01f);
        assertEquals(80, customEngine.getBoreSize(), 0.01f);
        assertEquals(90, customEngine.getStroke(), 0.01f);
        assertEquals(1, customEngine.getNumCylinders(), 0.01f);
        assertEquals("TestCompany", customEngine.getCompanyName());
        assertEquals(9.52018278751f, customEngine.getHorsePower(), 0.01f);
        assertEquals(452.389342117f, customEngine.getEngineDisplacement(), 0.01f);
    }

    /**
     * Tests the setCompanyName method of the CarEngine class.
     */

    @Test
    public void testSetCompanyName() {
        customEngine.setCompanyName("NewCompany");
        assertEquals("NewCompany", customEngine.getCompanyName());
        customEngine.setCompanyName(null);
        assertEquals("Unknown", customEngine.getCompanyName());
    }

    /**
     * Tests the setNumCylinders method of the CarEngine class.
     */

    @Test
    public void testSetNumCylinders() {
        customEngine.setNumCylinders(4);
        assertEquals(4, customEngine.getNumCylinders());
        customEngine.setNumCylinders(-1);
        assertEquals(0, customEngine.getNumCylinders());
        customEngine.setNumCylinders(10);
        assertEquals(8, customEngine.getNumCylinders());
    }

    /**
     * Tests the setBoreSize method of the CarEngine class.
     */

    @Test
    public void testSetBoreSize() {
        customEngine.setBoreSize(70);
        assertEquals(70, customEngine.getBoreSize());
        customEngine.setBoreSize(-10);
        assertEquals(0, customEngine.getBoreSize());
        customEngine.setBoreSize(110);
        assertEquals(100, customEngine.getBoreSize());
    }

    /**
     * Tests the setEngineDisplacement method of the CarEngine class.
     */

    @Test
    public void testSetEngineDisplacement() {
        customEngine.setBoreSize(85);
        customEngine.setStroke(90);
        customEngine.setNumCylinders(6);
        customEngine.setEngineDisplacement();
        assertEquals(3064.2309345f, customEngine.getEngineDisplacement(), 0.01f);
    }

    /**
     * Tests the setHorsePower method of the CarEngine class.
     */

    @Test
    public void testSetHorsePower() {
        //defaultEngine.setTorque(300);
        //defaultEngine.setSpeed(6000);
        customEngine.setHorsePower(false);
        assertEquals(9.520183f, customEngine.getHorsePower(), 0.01f);
        customEngine.setHorsePower(true);
        assertEquals(30.15929f, customEngine.getHorsePower(), 0.01f);
    }

    /**
     * Cleans up the test environment after all tests have concluded.
     */

    @AfterAll
    public static void tearDown() {
        defaultEngine = null;
        customEngine = null;
        System.out.println("All tests have concluded.");
    }

}
