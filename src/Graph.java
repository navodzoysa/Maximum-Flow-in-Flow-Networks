import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int numberOfNodes;
    private int source;
    private int sink;
    private LinkedList<Edge> graph;

    public Graph(List<List<Integer>> parsedList) {
        this.numberOfNodes = parsedList.get(0).get(0);
        parsedList.remove(0);
        this.graph = generateGraph(parsedList);
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

    public LinkedList<Edge> getGraph() {
        return graph;
    }

    public LinkedList<Edge> generateGraph(List<List<Integer>> parsedList) {
        System.out.println(parsedList);
        this.graph = new LinkedList<>();
        for(List<Integer> list : parsedList) {
            this.graph.add(new Edge(list.get(0), list.get(1), list.get(2)));
        }
        return graph;
    }
}
