/* *****************************************************************************
 *  Name:    Navod Zoysa
 *  UoW ID:  w1761781
 *  IIT ID:  2015154
 *
 *  Description:  Calculates the max flow given using breadth first search.
 *
 *  Written:       08/04/2021
 **************************************************************************** */

import java.util.*;

public class MaxFlow {
    private int source;
    private int sink;
    private Graph graph;
    private Edge[] augmentedPathList;
    private int maxFlow;
    private double timeTaken;

    public MaxFlow(int source, int sink, Graph graph) {
        this.source = source;
        this.sink = sink;
        this.graph = graph;
    }

    public int calculateMaxFlow() {
        int flow = Integer.MAX_VALUE;
        double startTime = System.nanoTime();
        System.out.println("start time " +startTime);
        while (breadFirstSearch()) {
            for(int i = sink; i != source; i = augmentedPathList[i].getAdjacentNode(i)) {
                flow = Math.min(flow, augmentedPathList[i].residualCapacity(i));
            }
            List<String> pathTaken = new ArrayList<>();
            for(int i = sink; i != source; i = augmentedPathList[i].getAdjacentNode(i)) {
                augmentedPathList[i].addFlow(i, flow);
                pathTaken.add("Edge (" + augmentedPathList[i].getAdjacentNode(i) + " > " + i +
                        ") Original Capacity = " + augmentedPathList[i].getCapacity() + "/" +
                        augmentedPathList[i].getCapacity() + ", Flow = " + augmentedPathList[i].getFlow() + "/" +
                        augmentedPathList[i].getCapacity() + ", Residual Capacity = " +
                        augmentedPathList[i].residualCapacity(i) + "/" + augmentedPathList[i].getCapacity());
            }
            Collections.reverse(pathTaken);
            System.out.println("Augmented Path | Minimum Capacity allowed = " + flow + "\n");
            for(String string : pathTaken) {
                System.out.println(string);
            }
            System.out.println("--------------------------------------");
            maxFlow += flow;
        }
        timeTaken = (System.nanoTime() - startTime);
        System.out.println("end time " +(timeTaken/1000000000));
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
