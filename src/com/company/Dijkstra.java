package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.company.Constants.INFINITY;

public class Dijkstra {


    /**
     * Implementacja algorytmu Dijkstry.
     * Problem: wyznaczenie najkrótszych ścieżek z wierzchołka startVertex do pozostałych wierzchołków grafu.
     * @param graph - reprezentacja grafu w postaci macierzy przyległości
     * @param startVertex - wierzchołek z którego algorytm wystartuje
     */

    public static void run(int[][] graph, int startVertex) {

        int graphVertexCount = graph.length;

        int[][] cost = new int[graphVertexCount][graphVertexCount];
        int[] visited = new int[graphVertexCount];
        int[] prevVertex = new int[graphVertexCount];
        int[] distance = new int[graphVertexCount];
        int minDistance = 0, nextVertex = 0;


        for (int i = 0; i < graphVertexCount; i++) {
            for (int j = 0; j < graphVertexCount; j++) {
                cost[i][j] = (graph[i][j] == 0) ? INFINITY : graph[i][j];
            }
        }

        for (int i = 0; i < graphVertexCount; i++) {
            visited[i] = 0;
            prevVertex[i] = startVertex;
            distance[i] = cost[startVertex][i];
        }


        //jestesmy na pierwszym wierzcholku wiec ustawiamy dystans na 0
        //oraz oznaczamy startVertex jako odwiedzony
        distance[startVertex] = 0;
        visited[startVertex] = 1;


        for (int iter = 1; iter < graphVertexCount - 1; iter++) {
            minDistance = INFINITY;

            for (int i = 0; i < graphVertexCount; i++) {
                if (distance[i] < minDistance && visited[i] == 0) {
                    minDistance = distance[i];
                    nextVertex = i;
                }
            }
            visited[nextVertex] = 1;


            for (int i = 0; i < graphVertexCount; i++) {
                if (visited[i] == 0) {
                    if (minDistance + cost[nextVertex][i] < distance[i]) {
                        distance[i] = minDistance + cost[nextVertex][i];
                        prevVertex[i] = nextVertex;
                    }
                }
            }
        }



        for(int i = 0; i < graphVertexCount; i++){

            if(i != startVertex){
                System.out.println("Dystans do wierzcholka " + i + ": " + distance[i]);
                System.out.print("Sciezka do wierzcholka " + i + ": ");

                List<Integer> path = new ArrayList<>();
                int j = i;
                do{
                    j = prevVertex[j];
                    path.add(j);
                }while(j != startVertex);

                //odrwracam elementy w liscie, gdyz sciezka jest aktualnie w odwrotnej kolejnosci
                Collections.reverse(path);

                for(int elem : path){
                    System.out.print((elem == startVertex ? "" : "=> ") + elem + " ");
                }
                System.out.println("\n");
            }
        }

    }
}