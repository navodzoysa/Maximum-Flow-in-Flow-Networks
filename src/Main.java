import java.util.List;

public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser("../benchmarks/bridge_1.txt");
        List<List<Integer>> parsedList = parser.readFile();

        Graph graph = new Graph(parsedList);

        int numberOfNodes = graph.getNumberOfNodes();
//        parsedList.remove(0);
        System.out.println(graph.getGraph());
        System.out.println(numberOfNodes);

//        LinkedList<Edge>[] exampleList;
//
//        exampleList = new LinkedList[numberOfNodes];
//
//        for(int i = 0; i < numberOfNodes; i++) {
//            exampleList[i] = new LinkedList<>();
//        }
//        System.out.println(Arrays.toString(exampleList));
//
//        exampleList[0].add(new Edge(0, 1, 6));
//        exampleList[0].add(new Edge(0, 2, 4));
//        exampleList[1].add(new Edge(1, 2, 2));
//        exampleList[1].add(new Edge(1, 3, 3));
//        exampleList[2].add(new Edge(2, 3, 5));
//
//        System.out.println(Arrays.toString(exampleList));

        
//        List<Integer> graph = new LinkedList<>();
//        for(int i = 0; i < numberOfNodes; i++) {
//            graph.add(i);
//        }
//        System.out.println(graph);
    }
}
