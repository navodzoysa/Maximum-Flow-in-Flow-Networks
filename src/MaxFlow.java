import java.util.Arrays;
import java.util.LinkedList;

public class MaxFlow {
    private int source;
    private int sink;
    private Graph graph;
    private Edge[] augmentedPathList;
    private int maxFlow;

    public MaxFlow(int source, int sink, Graph graph) {
        this.source = source;
        this.sink = sink;
        this.graph = graph;
    }

    public int calculateMaxFlow() {
        int flow = Integer.MAX_VALUE;
        while (breadFirstSearch()) {
            System.out.println("Loop augmented path " + Arrays.toString(augmentedPathList));
            for(int i = sink; i != source; i = augmentedPathList[i].getAdjacentNode(i)) {
                flow = Math.min(flow, augmentedPathList[i].residualCapacity(i));
                System.out.println("FLow " + flow);
            }
            for(int i = sink; i != source; i = augmentedPathList[i].getAdjacentNode(i)) {
                System.out.println("Augment path = "+ i + " to " + augmentedPathList[i].getAdjacentNode(i));
                System.out.println("Residual capacity before adding flow for " + i + " is " + augmentedPathList[i].residualCapacity(i));
                augmentedPathList[i].addFlow(i, flow);
                System.out.println("Residual capacity for after adding flow for " + i + " is " + augmentedPathList[i].residualCapacity(i));
            }
            maxFlow += flow;
        }
        return maxFlow;
    }

    public boolean breadFirstSearch() {
        boolean[] visitedNodes = new boolean[graph.getNumberOfNodes()];
        augmentedPathList = new Edge[graph.getNumberOfNodes()];
        LinkedList<Edge>[] adjacencyList = graph.getGraph();

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);
        visitedNodes[source] = true;

        while(queue.size() != 0) {
            int node = queue.poll();
            for(Edge edge : adjacencyList[node]) {
                int adjacentNode = edge.getAdjacentNode(node);
                if(!visitedNodes[adjacentNode] && edge.residualCapacity(adjacentNode) > 0) {
                    if(adjacentNode == sink) {
                        augmentedPathList[adjacentNode] = edge;
                        visitedNodes[adjacentNode] = true;
                        return true;
                    }
                    augmentedPathList[adjacentNode] = edge;
                    visitedNodes[adjacentNode] = true;
                    queue.add(adjacentNode);
                }
            }
        }
        return false;
    }
}
