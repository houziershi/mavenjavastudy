package com.my.algorithm.graph;


import java.util.LinkedList;

/**
 * @author houguokun
 * discription: 无向图的邻接矩阵
 */
public class AdjacencyGraphList {

    static void addEdge(Graph graph, int src, int dest) {
        graph.adjListArray[src].add(dest);
        graph.adjListArray[dest].add(src);
    }

    static void printGraph(Graph graph) {
        for (int v = 0; v < graph.v; v++) {
            System.out.println("Adgacency list of vertex " + v);
            System.out.println("head");
            for (Integer pCrawl : graph.adjListArray[v]) {
                System.out.println("-->" + pCrawl);
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        int v = 5;
        Graph graph = new Graph(v);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);

        // print the adjacency list representation of
        // the above graph
        printGraph(graph);
    }

    static class Graph {
        int v;
        LinkedList<Integer> adjListArray[];

        Graph(int v) {
            this.v = v;

            adjListArray = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adjListArray[i] = new LinkedList<>();
            }

        }
    }
}
