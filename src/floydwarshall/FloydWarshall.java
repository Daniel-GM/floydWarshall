package floydwarshall;
public class FloydWarshall {
    static int V=10;
    
    void imprimeFloydWarshall(int dist[][]){
        System.out.println("");
        for (int i = 0; i < V; i++) {
            System.out.print(i+1 + ": ");
            for (int j = 0; j < V; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
    
    void floydWarshall(int grafo[][]){
        int visitados[][] = new int[V][V];
        int dist[][] = new int[V][V];
        int proximo[][] = new int[V][V];
        
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = grafo[i][j];
                proximo[i][j] = j;
                visitados[i][j] = 0;
            }
        }
        
        for (int u = 0; u < V; u++) {
            for (int s = 0; s < V; s++) {
                for (int v = 0; v < V; v++) {
                    if(dist[s][u] + dist[u][v] < dist[s][v] && visitados[s][v] == 0){
                       dist[s][v] = dist[s][u] + dist[u][v];
                       proximo[s][v] = u;
                       visitados[s][v] = 1;
                    }
                }
            }
        }
        
        imprimeFloydWarshall(dist);
    }
}
