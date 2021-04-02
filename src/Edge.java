public class Edge {
    private int startNode;
    private int endNode;
    private int capacity;
    private int flow;

    public Edge(int startNode, int endNode, int capacity) {
        this.startNode = startNode;
        this.endNode = endNode;
        this.capacity = capacity;
    }

    public int getStartNode() {
        return startNode;
    }

    public int getEndNode() {
        return endNode;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFlow() {
        return flow;
    }

    public int getAdjacentNode(int node) {
        if(node == startNode) {
            return endNode;
        }
        return startNode;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "startNode=" + startNode +
                ", endNode=" + endNode +
                ", capacity=" + capacity +
                ", flow=" + flow +
                '}';
    }
}
