import static java.lang.Math.PI;

/**
 * The CarEngine class represents an engine with various attributes like torque, speed,
 * bore size, stroke, number of cylinders, company name, horsepower, and engine displacement.
 *
 * @author Qurb E Muhammad Syed
 * @StudentNumber 101281787
 * @version 07.31.2024
 */
public class CarEngine {

    private int torque;
    private int speed;
    private int boreSize;
    private int stroke;
    private int numCylinders;
    private String companyName;
    private float horsePower;
    private float engineDisplacement;

    private final int RADIANS_PER_SECOND = 5252;
    private final int CC_FROM_HP = 15;


    /**
     * Default Constructor
     * Initializes the engine with default values.
     */

    public CarEngine() {

        torque = 0;
        speed = 0;
        boreSize = 0;
        stroke = 0;
        numCylinders = 0;
        companyName = "Unknown";
        horsePower = 0.0f;
        engineDisplacement = 0.0f;
    }

    /**
     * Overloaded Constructor
     *
     * @param companyName   the name of the company
     * @param torque        the torque of the engine
     * @param speed         the speed of the engine
     * @param boreSize      the bore size of the engine
     * @param stroke        the stroke of the engine
     * @param numCylinders  the number of cylinders in the engine
     */

    public CarEngine(String companyName, int torque, int speed, int boreSize, int stroke, int numCylinders) {

        if (torque < 0) {
            this.torque = 0;
        } else {
            this.torque = torque;
        }

        if (speed < 0) {
            this.speed = 0;
        } else {
            this.speed = speed;
        }

        if (boreSize < 0) {
            this.boreSize = 0;
        } else if (boreSize > 100) {
            this.boreSize = 100;
        } else {
            this.boreSize = boreSize;
        }

        if (stroke < 0) {
            this.stroke = 0;
        } else if (stroke > 100) {
            this.stroke = 100;
        } else {
            this.stroke = stroke;
        }

        if (numCylinders < 0) {
            this.numCylinders = 0;
        } else if (numCylinders > 8) {
            this.numCylinders = 8;
        } else {
            this.numCylinders = numCylinders;
        }

        if (companyName == null) {
            this.companyName = "Unknown";
        } else {
            this.companyName = companyName;
        }

        setHorsePower(false); // HorsePower for Overloaded Constructor

       this.engineDisplacement = calculateEngineDisplacement();

    }

    /**
     * Gets the horsepower of the engine.
     *
     * @return the horsepower of the engine.
     */
    public float getHorsePower(){
        return horsePower;
    }

    /**
     * Gets the company name of the engine.
     *
     * @return the company's name
     */
    public String getCompanyName(){
        return companyName;
    }


    /**
     * Gets the engine displacement.
     *
     * @return the engine displacement of the engine.
     */

    public float getEngineDisplacement() {
        return engineDisplacement;
    }

    /**
     * Gets the bore size of the engine.
     *
     * @return the bore size of the engine.
     */

    public int getBoreSize() {
        return boreSize;
    }


    /**
     * Gets the number of cylinders in the engine.
     *
     * @return the number of cylinders in the engine.
     */

    public int getNumCylinders() {
        return numCylinders;
    }

    /**
     * Gets the speed of the engine.
     *
     * @return the speed of the engine in RPM.
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Gets the stroke of the engine.
     *
     * @return the stroke of the engine in mm.
     */
    public int getStroke() {
        return stroke;
    }


    /**
     * Gets the torque of the engine.
     *
     * @return the torque of the engine in pound-foot.
     */

    public int getTorque() {
        return torque;
    }

    /**
     * Sets the engine displacement.
     */
    public void setEngineDisplacement() {
        this.engineDisplacement = calculateEngineDisplacement();
    }


    /**
     * Sets the torque of the engine.
     *
     * @param torque the torque to set.
     */
    public void setTorque(int torque) {

        if (torque < 0) {
            this.torque = 0;
        } else {
            this.torque = torque;
        }
    }

    /**
     * Sets the speed of the engine.
     *
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        if (speed < 0) {
            this.speed = 0;
        } else {
            this.speed = speed;
        }
    }

    /**
     * Sets the bore size of the engine.
     *
     * @param boreSize the bore size to set.
     */

    public void setBoreSize(int boreSize) {
        this.boreSize = boreSize;
        if (boreSize < 0) {
            this.boreSize = 0;
        } else if (boreSize > 100) {
            this.boreSize = 100;
        }
        }


    /**
     * Sets the stroke of the engine.
     *
     * @param stroke the stroke to set
     */
    public void setStroke(int stroke) {
        if (stroke < 0) {
            this.stroke = 0;
        } else if (stroke > 100) {
            this.stroke = 100;
        } else {
            this.stroke = stroke;
        }
    }

    /**
     * Sets the number of cylinders in the engine.
     *
     * @param numCylinders the number of cylinders to set
     */

    public void setNumCylinders(int numCylinders) {
        if (numCylinders < 0) {
            this.numCylinders = 0;
        } else if (numCylinders > 8) {
            this.numCylinders = 8;
        } else {
            this.numCylinders = numCylinders;
        }
    }

    /**
     * Sets the company name of the engine.
     *
     * @param companyName the company name to set.
     */

    public void setCompanyName(String companyName) {
        if (companyName == null) {
            this.companyName = "Unknown";
        } else {
            this.companyName = companyName;
        }
    }

    /**
     * Sets the horsepower of the engine.
     *
     * @param source if true, calculates horsepower from displacement; otherwise, from torque.
     */

    public void setHorsePower(boolean source){
        if (source){
            this.horsePower = calculateHorsepowerFromDisplacement();
        } else {
            this.horsePower = calculateHorsePowerFromTorque();
        }
    }

    /**
     * Calculates the horsepower from torque.
     *
     * @return the calculated horsepower from torque.
     */

    private float calculateHorsePowerFromTorque(){
        return (this.torque * ((float) this.speed / RADIANS_PER_SECOND));
    }

    /**
     * Calculates the engine displacement.
     *
     * @return the calculated engine displacement.
     */

    private float calculateEngineDisplacement(){

        return (float) ((PI * Math.pow((boreSize / 2.0f), 2) * stroke * numCylinders) / 1000);
        //return (float) ((3.14 * Math.pow((80 / 2.0f), 2) * 90 * 1) / 1000);

    }

    /**
     * Calculates the horsepower from displacement.
     *
     * @return the calculated horsepower from displacement.
     */

    private float calculateHorsepowerFromDisplacement(){
        return calculateEngineDisplacement() / CC_FROM_HP;
    }



}

