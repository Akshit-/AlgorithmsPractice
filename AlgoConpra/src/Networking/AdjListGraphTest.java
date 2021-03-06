package Networking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class AdjListGraphTest {

    public void testGraphBFS() {
    	
        AdjListGraph<Character, Character> charGraph = new AdjListGraph<Character, Character>();
        /* add nodes to the vertices */
        charGraph.addEdge('a', 'b');
        charGraph.addEdge('a', 'c');
        charGraph.addEdge('b', 'd');
        charGraph.addEdge('b', 'e');
        charGraph.addEdge('c', 'f');
        charGraph.addEdge('c', 'g');
        charGraph.addEdge('e', 'h');
        Queue<Character> queue = new LinkedList<Character>();
        /* add the root */
        queue.add('a');
        /* do the bfs */
        System.out.println("BFS");
        while (!queue.isEmpty()) {
            Character node = queue.poll();
            System.out.println(node);
            Set<Character> children =null;//= charGraph.getNodes(node);
            if (children == null) {
                continue;
            } else {
                queue.addAll(children);
            }
        }
    }

    public void testGraphDFS() {
        AdjListGraph<Character, Character> charGraph = new AdjListGraph<Character, Character>();
        Map<Character, Boolean> discovered = new HashMap<Character, Boolean>();
        Stack<Character> nodeStack = new Stack<Character>();
        /* add nodes to the vertices */
        charGraph.addEdge('a', 'b');
        charGraph.addEdge('a', 'c');
        charGraph.addEdge('b', 'd');
        charGraph.addEdge('b', 'e');
        charGraph.addEdge('c', 'f');
        charGraph.addEdge('c', 'g');
        charGraph.addEdge('e', 'h');
        /* add the root */
        nodeStack.push('a');
        System.out.println("DFS");
        while (!nodeStack.isEmpty()) {
            Character node = nodeStack.pop();
            /* check to make sure the node hasn't already been discovered */
            if (discovered.get(node)==null || !discovered.get(node).equals(true)) {
                System.out.println(node);
                discovered.put(node, true);
                Set<Character> adjacentNodes = null;//charGraph.getNodes(node);
                if (adjacentNodes != null) {
                    /* this loop will pick right nodes as opposed to left nodes first */
                    for (Character adjNode : adjacentNodes) {
                        nodeStack.push(adjNode);
                    }
                }
            }
        }


    }
}