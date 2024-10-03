

import java.util.ArrayList;
/**
 * The Main class is where the execution of the program happens.
 * It creates an ArrayList of the type CarEngine class and iterates over it, printing
 * their details, those being: Company Name, Number of Cylinders, Engine Displacement and Horsepower.
 */

public class Main {

    /**
     * Prints the details of the provided CarEngine objects.
     *
     * @param engines the list of CarEngine objects to print details for
     */
        public static void printEngineDetails(ArrayList<CarEngine> engines) {

            for (CarEngine engine : engines) {

                System.out.println("Company Name: " + engine.getCompanyName());
                System.out.println("Number of Cylinders: " + engine.getNumCylinders());
                System.out.println("Engine Displacement: " + engine.getEngineDisplacement());
                System.out.println("Horsepower: " + engine.getHorsePower());
                System.out.println();
            }

        }

    /**
     * The main method where the program starts execution.
     *
     * @param args the command line arguments
     */

    public static void main(String[] args) {

            ArrayList<CarEngine> engines =  new ArrayList<>();

        engines.add(new CarEngine("Nissan", 200, 600, 90, 100, 1));
        engines.add(new CarEngine("Honda", 300, 700, 100, 110, 3));
        engines.add(new CarEngine("Toyota", 350, 750, 110, 120, 4));
        engines.add(new CarEngine("Lexus", 400, 800, 120, 130, 6));
        engines.add(new CarEngine("Suzuki", 450, 900, 130, 140, 8));


        printEngineDetails(engines);
    }
    }
