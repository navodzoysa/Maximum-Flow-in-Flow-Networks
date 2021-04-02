import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MaxFlow {
    private int source;
    private int sink;
    private Graph graph;
    private int[] parentNodes;
    private List<Edge> augmentedPathList;
    private int maxFlow;

    public MaxFlow(int source, int sink, Graph graph) {
        this.source = source;
        this.sink = sink;
        this.graph = graph;
    }

    public int calculateMaxFlow() {
        int flow = Integer.MAX_VALUE;
        while (breadFirstSearch()) {
            for(int i = sink; i != source; i = augmentedPathList.get(i).getAdjacentNode(i)) {
                flow = Math.min(flow, augmentedPathList.get(i).getCapacity());
            }
            for(int i = sink; i != source; i = augmentedPathList.get(i).getAdjacentNode(i)) {
                augmentedPathList.get(i).setCapacity(augmentedPathList.get(i).getCapacity() - flow);
                augmentedPathList.get(i).setFlow(flow);
            }
        }
        return maxFlow += flow;
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

        augmentedPathList = new ArrayList<>();

        System.out.println(Arrays.toString(visitedNodes));
        System.out.println(Arrays.toString(parentNodes));

        while(queue.size() != 0) {
            int node = queue.poll();
            for(Edge edge : adjacencyList[node]) {
                int adjacentNode = edge.getAdjacentNode(node);
                if(!visitedNodes[adjacentNode] && edge.getCapacity() > 0) {
                    parentNodes[adjacentNode] = node;
                    augmentedPathList.add(edge);
                    visitedNodes[adjacentNode] = true;
                    queue.add(adjacentNode);
                }
                System.out.println("Node = " + node + " Adjacent Node = " + adjacentNode);
            }
            System.out.println(Arrays.toString(parentNodes));
            System.out.println(Arrays.toString(visitedNodes));
            System.out.println(augmentedPathList);
        }
        return false;
    }
}
