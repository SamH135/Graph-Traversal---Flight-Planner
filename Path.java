import java.util.*;

public class Path {
    List<Edge> edges;

    public Path() {
        edges = new ArrayList<>();
    }

    public double getTotalCost() {
        return edges.stream().mapToDouble(edge -> edge.cost).sum();
    }

    public int getTotalTime() {
        return edges.stream().mapToInt(edge -> edge.time).sum();
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

}