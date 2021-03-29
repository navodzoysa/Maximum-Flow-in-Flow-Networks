import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int numberOfNodes;
    private int source;
    private int sink;
    private List<Edge> edges;
    private LinkedList<Edge>[] adjacencyList;

    public Graph(List<List<Integer>> parsedList) {
        this.numberOfNodes = parsedList.get(0).get(0);
        parsedList.remove(0);
        adjacencyList = new LinkedList[numberOfNodes];
        for(int i = 0; i < numberOfNodes; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
        this.edges = generateGraph(parsedList);
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

    public List<Edge> getGraph() {
        return edges;
    }

    public List<Edge> generateGraph(List<List<Integer>> parsedList) {
        System.out.println(parsedList);
        this.edges = new ArrayList<>();

        for (List<Integer> integers : parsedList) {
            System.out.println(integers);
            adjacencyList[integers.get(0)].add(new Edge(integers.get(0), integers.get(1), integers.get(2)));
        }

        for(int i = 0; i < numberOfNodes; i++) {
            LinkedList<Edge> list = adjacencyList[i];
            for (Edge edge : list) {
                System.out.println(edge);
            }
        }
        return edges;
    }
}
