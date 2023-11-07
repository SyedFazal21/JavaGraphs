import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    int V;
    List<List<Integer>> l;

    Graph(int v) {
        this.V = v;
        l = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            l.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){
        l.get(u).add(v);
        l.get(v).add(u);
    }

    public void printGraph(){
        for(int i = 0; i < V; i++){
            System.out.print(i + " -> ");
            for(int v : l.get(i)){
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public void BFS(int source, int dest){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        int[] parent = new int[V];

        for(int i = 0; i < V; i++) parent[i] = -1;

        q.add(source);
        visited[source] = true;
        dist[source] = 0;
        parent[source] = source;

        while(!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");

            for(int nbrs : l.get(node)){
                if(!visited[nbrs]){
                    q.add(nbrs);
                    visited[nbrs] = true;
                    parent[nbrs] = node;
                    dist[nbrs] = dist[node] + 1;
                }
            }
        }

        System.out.println();
        for(int i = 0; i < V; i++){
            System.out.println("Shortest distance to " + i + " is " +  dist[i]);
        }

        if(dest != -1){
            int temp = dest;
            while(temp != source){
                System.out.print(temp + " --> ");
                temp = parent[temp];
            }
            System.out.print(source + "\n");
        }
    }

    public void DFSHelper(int source, boolean[] visited){
        visited[source] = true;
        System.out.print(source + " ");

        for(int nbr : l.get(source)){
            if(!visited[nbr]){
                DFSHelper(nbr, visited);
            }
        }
    }

    public void DFS(int source){
        boolean[] visited = new boolean[V];
        DFSHelper(source, visited);
    }

}