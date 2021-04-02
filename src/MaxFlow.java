import java.util.Arrays;
import java.util.LinkedList;

public class MaxFlow {
    private int source;
    private int sink;
    private Graph graph;
    private Edge[] parentNodes;
    private int maxFlow;

    public MaxFlow(int source, int sink, Graph graph) {
        this.source = source;
        this.sink = sink;
        this.graph = graph;
    }

    public int calculateMaxFlow() {
        int flow = Integer.MAX_VALUE;
        while (breadFirstSearch()) {
            System.out.println("Loop augmented path " + Arrays.toString(parentNodes));
            for(int i = sink; i != source; i = parentNodes[i].getAdjacentNode(i)) {
                flow = Math.min(flow, parentNodes[i].residualCapacity(i));
                System.out.println("FLow " + flow);
            }
            for(int i = sink; i != source; i = parentNodes[i].getAdjacentNode(i)) {
                System.out.println("Augment path = "+ i + " to " + parentNodes[i].getAdjacentNode(i));
                parentNodes[i].addFlow(i, flow);
            }
            maxFlow += flow;
        }
        return maxFlow;
    }

    public boolean breadFirstSearch() {
        boolean[] visitedNodes = new boolean[graph.getNumberOfNodes()];
        parentNodes = new Edge[graph.getNumberOfNodes()];
        LinkedList<Edge>[] adjacencyList = graph.getGraph();

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        visitedNodes[source] = true;

        while(queue.size() != 0) {
            int node = queue.poll();
            for(Edge edge : adjacencyList[node]) {
                int adjacentNode = edge.getAdjacentNode(node);
                if(!visitedNodes[adjacentNode] && edge.residualCapacity(adjacentNode) > 0) {
                    parentNodes[adjacentNode] = edge;
                    visitedNodes[adjacentNode] = true;
                    queue.add(adjacentNode);
                }
            }
        }
        return visitedNodes[sink];
    }
}
