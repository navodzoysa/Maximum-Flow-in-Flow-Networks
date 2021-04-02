import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int numberOfNodes;
    private int source;
    private int sink;
    private LinkedList<Edge>[] adjacencyList;

    public Graph(List<List<Integer>> parsedList) {
        this.numberOfNodes = parsedList.get(0).get(0);
        parsedList.remove(0);
        adjacencyList = new LinkedList[numberOfNodes];
        for(int i = 0; i < numberOfNodes; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
        this.adjacencyList = generateGraph(parsedList);
        this.source = 0;
        this.sink = numberOfNodes - 1;
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    public int getSource() {
        return source;
    }

    public int getSink() {
        return sink;
    }

    public LinkedList<Edge>[] getGraph() {
        return adjacencyList;
    }

    public void addEdge(Edge edge) {
        int startNode = edge.getStartNode();
        int endNode = edge.getEndNode();
        adjacencyList[startNode].add(edge);
        adjacencyList[endNode].add(edge);
    }

    public LinkedList<Edge>[] generateGraph(List<List<Integer>> parsedList) {
        for (List<Integer> integers : parsedList) {
            Edge edge = new Edge(integers.get(0), integers.get(1), integers.get(2));
            addEdge(edge);
        }
        return adjacencyList;
    }

    public void printGraph() {
        for(int i = 0; i < numberOfNodes; i++) {
            LinkedList<Edge> list = adjacencyList[i];
            System.out.println(list);
        }
    }
}
