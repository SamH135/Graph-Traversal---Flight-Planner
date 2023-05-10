import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class FlightPlan {
    Graph graph;
    List<FlightRequest> requests;

    public FlightPlan(String flightDataFile, String pathsToCalculateFile) {
        this.graph = new Graph();
        this.requests = new ArrayList<>();
        readFlightDataFile(flightDataFile);
        readPathsToCalculateFile(pathsToCalculateFile);
    }

    private void readFlightDataFile(String flightDataFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(flightDataFile))) {
            int numEdges = Integer.parseInt(br.readLine());
            for (int i = 0; i < numEdges; i++) {
                String[] parts = br.readLine().split("\\|");
                String origin = parts[0];
                String destination = parts[1];
                double cost = Double.parseDouble(parts[2]);
                int time = Integer.parseInt(parts[3]);
                graph.addEdge(origin, destination, time, cost);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readPathsToCalculateFile(String pathsToCalculateFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(pathsToCalculateFile))) {
            int numRequests = Integer.parseInt(br.readLine());
            for (int i = 0; i < numRequests; i++) {
                String[] parts = br.readLine().split("\\|");
                String origin = parts[0];
                String destination = parts[1];
                char orderBy = parts[2].charAt(0);
                requests.add(new FlightRequest(origin, destination, orderBy));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public List<Path> findAllPaths(City origin, City destination, char orderBy) {
        List<Path> paths = new ArrayList<>();
        Set<City> visited = new HashSet<>();
    
        dfs(origin, destination, new Stack<>(), visited, paths);
    
        Comparator<Path> comparator = orderBy == 'T' ? Comparator.comparingInt(Path::getTotalTime) : Comparator.comparingDouble(Path::getTotalCost);
        paths.sort(comparator);
    
        return paths;
    }
    
    
    
    
    private void dfs(City currentCity, City destination, List<Edge> currentPath, Set<City> visited, List<Path> paths) {
        visited.add(currentCity);
    
        if (currentCity == destination) {
            Path path = new Path();
            path.edges.addAll(currentPath);
            paths.add(path);
        } else {
            for (Edge edge : currentCity.edges) {
                if (!visited.contains(edge.destination)) {
                    currentPath.add(edge);
                    dfs(edge.destination, destination, currentPath, visited, paths);
                    currentPath.remove(edge);
                }
            }
        }
    
        visited.remove(currentCity);
    }
    


    public void writeOutputFile(String outputFile) {
        try (FileWriter fw = new FileWriter(outputFile)) {
            int flightCounter = 1;
            for (FlightRequest request : requests) {
                List<Path> paths = findAllPaths(graph.getCity(request.origin), graph.getCity(request.destination), request.orderBy);
                if(request.orderBy == 'C'){
                    fw.write("Flight " + flightCounter + ": " + request.origin + ", " + request.destination + " (Cost)" + "\n");
                }
                else {
                    fw.write("Flight " + flightCounter + ": " + request.origin + ", " + request.destination + " (Time)" + "\n");
                }
                
                int pathCounter = 1;
                for (Path path : paths.stream().limit(3).collect(Collectors.toList())) {
                    fw.write("Path " + pathCounter + ": ");
                    fw.write(request.origin + " -> ");
                    fw.write(path.edges.stream().map(edge -> edge.destination.name).collect(Collectors.joining(" -> ")));
                    fw.write(". Time: " + path.getTotalTime() + " Cost: " + String.format("%.2f", path.getTotalCost()) + "\n");
                    pathCounter++;
                }
                fw.write("\n");
                flightCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    
    
}
