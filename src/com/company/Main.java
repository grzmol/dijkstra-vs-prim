package com.company;
import static com.company.Constants.INFINITY;

public class Main {

    public static void main(String[] args) {

        int INF = INFINITY;

	    int[][] graph = {
            {0, 6, INF, 1, INF},
            {6, 0, 5, 2, 2},
            {INF, 5, 0, INF, 5},
            {1, 2, INF, 0, 1},
            {INF, 2, 5, 1, 0}
        };


        System.out.println("Wyznaczanie najkrótszych ścieżek z danego wierzchołka do pozostałych wierzchołków grafu - Algorytm Dijkstry\n\n");
        System.out.println("Dane wejscowie: ");
        Utils.printGraph(graph);
        System.out.println("\n\nDane wyjsciowe: ");

	    Dijkstra.run(graph, 0);

	    System.out.println("\n\n---------------------------------------------\n\n");

	    System.out.println("Wyznaczanie minimalnego drzewa rozpinajacego - Algorytm Prima\n\n");
	    System.out.println("Dane wejscowie: ");

	    Utils.printGraph(graph);
	    System.out.println("\n\n");
	    System.out.println("Dane wyjsciowe: ");
	    Prim.run(graph);
    }
}

