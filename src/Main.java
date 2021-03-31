import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser("../benchmarks/bridge_1.txt");
        List<List<Integer>> parsedList = parser.readFile();

        Graph graph = new Graph(parsedList);

        int numberOfNodes = graph.getNumberOfNodes();
        graph.printGraph();
        System.out.println(numberOfNodes);
    }
}
