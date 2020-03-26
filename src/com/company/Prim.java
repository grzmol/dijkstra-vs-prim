package com.company;

import static com.company.Constants.INFINITY;

public class Prim {

    public static void run(int graph[][]) {

        int graphSize = graph.length;

        int i, j;
        int edgesNumber = 1;
        int min, min_cost = 0;

        //reprezentacja wierzcholkow
        int u = 0, v = 0;

        //tablica która pozwoli na zaznaczenie odwiedzonych wierzchołkow
        int visit[] = new int[graphSize];

        for (int vertex : visit) {
            vertex = 0;
        }

        //ustawiając visit[k] = 1 zaznaczam ze wierzchołek k został odwiedzony
        visit[0] = 1;

        while (edgesNumber < graphSize)//no of edges < no of vertices
        {
            min = INFINITY;
            //iteracja przez wszystkie wierzchołki
            for (i = 0; i < graphSize; i++) {
                if (visit[i] == 1) {
                    for (j = 0; j < graphSize; j++) {
                        if (graph[i][j] < min && graph[i][j] != 0) {
                            //przypisanie nowej minimalnej wartości
                            min = graph[i][j];
                            //przypisanie i,j do u,v
                            u = i;
                            v = j;
                        }
                    }
                }
            }
            //sprawdzenie czy aktualny wierzcholek zostal odwiedzony a nastepny NIE zostal odwiedzony
            if (visit[u] == 1 && visit[v] == 0) {
                //zaznaczam ze wczesniej nie odwiedzony wierzcholek został odwiedzony
                visit[v] = 1;
                //dodaje wierzcholek do MST
                edgesNumber++;
                min_cost += min;
                System.out.println("Krawedz " + u + " - " + v + " dlugosc: " + min);

            }
            //blokuje sciezki przypisujac im maksymalna wartosc
            graph[u][v] = graph[v][u] = INFINITY;
        }
        System.out.println("Minimalny koszt to: " + min_cost);
    }
}
