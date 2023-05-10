import java.util.*;

public class Graph {
    Map<String, City> cities;

    public Graph() {
        this.cities = new HashMap<>();
    }

    public City addCity(String name) {
        if (!cities.containsKey(name)) {
            City city = new City(name);
            cities.put(name, city);
        }
        return cities.get(name);
    }

    public void addEdge(String originName, String destinationName, int time, double cost) {
        City origin = addCity(originName);
        City destination = addCity(destinationName);
        Edge edge1 = new Edge(destination, time, cost);
        Edge edge2 = new Edge(origin, time, cost);
        origin.addEdge(edge1);
        destination.addEdge(edge2);
    }


    public City getCity(String name) {
        return cities.get(name);
    }

    public Map<String, City> getCities() {
        return cities;
    }

    

    public void displayGraph() {
    System.out.println("Structure of the Graph (Possible Flights):");
    for (City city : cities.values()) {
        System.out.println(city.getName() + ":");
        for (Edge edge : city.getEdges()) {
            System.out.printf("- Destination: %-10s\n", edge.getDestination().getName());
            System.out.printf("  Time:       %-5d\n", edge.getTime());
            System.out.printf("  Cost:       %.2f\n", edge.getCost());
        }
        System.out.println();
    }
}
}
