import java.io.File;

public class Main {
    public static void main(String[] args) {

        // FOR QUICK TESTING...
        FlightPlan flightPlan = new FlightPlan("in1.txt", "in2.txt");
        flightPlan.writeOutputFile("outFile.txt");

        flightPlan.graph.displayGraph();


        // if (args.length != 3) {
        //     System.out.println("Call program from command line!");
        //     return;
        // }

        // String flightDataFile = args[0];
        // String pathsToCalculateFile = args[1];
        // String outputFile = args[2];

        // // Verify if the flight data file exists
        // File flightData = new File(flightDataFile);
        // if (!flightData.exists() || flightData.isDirectory()) {
        //     System.out.println("Flight data file does not exist or is a directory: " + flightDataFile);
        //     return;
        // }

        // // Verify if the paths to calculate file exists
        // File pathsToCalculate = new File(pathsToCalculateFile);
        // if (!pathsToCalculate.exists() || pathsToCalculate.isDirectory()) {
        //     System.out.println("Paths to calculate file does not exist or is a directory: " + pathsToCalculateFile);
        //     return;
        // }

        // // Create an instance of FlightPlan and process the files
        // FlightPlan flightPlan = new FlightPlan(flightDataFile, pathsToCalculateFile);
        // flightPlan.writeOutputFile(outputFile);




        
    }
}


