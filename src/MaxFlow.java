import java.util.Arrays;
import java.util.LinkedList;

public class MaxFlow {
    private int source;
    private int sink;
    private Graph graph;
    private int[] parentNodes;

    public MaxFlow(int source, int sink, Graph graph) {
        this.source = source;
        this.sink = sink;
        this.graph = graph;
    }

    public boolean breadFirstSearch() {
        boolean[] visitedNodes = new boolean[graph.getNumberOfNodes()];
        parentNodes = new int[graph.getNumberOfNodes()];
        LinkedList<Edge>[] adjacencyList = graph.getGraph();

        System.out.println(Arrays.toString(adjacencyList));

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        visitedNodes[source] = true;
        parentNodes[source] = -1;

        System.out.println(Arrays.toString(visitedNodes));
        System.out.println(Arrays.toString(parentNodes));

        while(queue.size() != 0) {
            int node = queue.poll();
            for(Edge edge : adjacencyList[node]) {
                System.out.println("Queue node (" + node + ") | Starting node (" + edge.getStartNode() + ") | Ending node (" + edge.getEndNode() +")");
                if(!visitedNodes[edge.getEndNode()] && edge.getCapacity() > 0) {
                    if(edge.getEndNode() == sink) {
                        parentNodes[edge.getEndNode()] = edge.getStartNode();
                        visitedNodes[edge.getEndNode()] = true;
                        System.out.println("Queue " + queue);
                        System.out.println("parentNodes for node - " + node + " " + Arrays.toString(parentNodes));
                        System.out.println("Visited nodes for " + node + " "  + Arrays.toString(visitedNodes));
                        return true;
                    }
                    queue.add(edge.getEndNode());
                    parentNodes[edge.getEndNode()] = edge.getStartNode();
                    visitedNodes[edge.getEndNode()] = true;
                    System.out.println("Queue " + queue);
                    System.out.println("parentNodes for node - " + node + " " + Arrays.toString(parentNodes));
                    System.out.println("Visited nodes for " + node + " "  + Arrays.toString(visitedNodes));
                }
            }
        }
        return false;
    }
}
