import java.util.List;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser("../benchmarks/bridge_1.txt");
        List<List<Integer>> parsedList = parser.readFile();

        Graph graph = new Graph(parsedList);

        int numberOfNodes = graph.getNumberOfNodes();
        int source = graph.getSource();
        int sink = graph.getSink();

        graph.printGraph();
        System.out.println(numberOfNodes);
        MaxFlow maxFlow = new MaxFlow(source, sink, graph);
        maxFlow.breadFirstSearch();
        System.out.println(maxFlow.calculateMaxFlow());
    }
}
