public class MyMain {
    public static void main(String[] args){
        System.out.println("Hello World");
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(3, 5);
        g.addEdge(5, 6);
        g.addEdge(4, 5);
        g.addEdge(0, 4);
        g.addEdge(3, 4);
        g.DFS(1);
    }
}
