public class Edge {
    City destination;
    int time;
    double cost;

    public Edge(City destination, int time, double cost) {
        this.destination = destination;
        this.time = time;
        this.cost = cost;
    }

    public City getDestination(){
        return this.destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    
    
}