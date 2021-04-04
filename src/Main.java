import java.util.List;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser("../benchmarks/bridge_1.txt");
        List<List<Integer>> parsedList = parser.readFile();

        Graph graph = new Graph(parsedList);

        System.out.println("Number of Nodes - " + graph.getNumberOfNodes());
        System.out.println("Number of Edges - " + graph.getNumberOfEdges());

        int source = graph.getSource();
        int sink = graph.getSink();
        graph.printGraph();

        MaxFlow maxFlow = new MaxFlow(source, sink, graph);
        System.out.println("Max Flow = " + maxFlow.calculateMaxFlow());
    }
}
