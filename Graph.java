import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int vertices;
    private List<List<Integer>> adj;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adj = new ArrayList <>();
        for (int i = 0; i < vertices; i++)
            this.adj.add(i, new LinkedList <>());
    }

    public void addVertex() {
        this.adj.add(vertices, new LinkedList <>());
        vertices++;
    }

    public int getEdges() {
        return this.adj.size();
    }

    public int getVertices() {
        return this.vertices;
    }

    public void addEdge(int v, int w) {
        this.adj.get(v).add(w);
        this.adj.get(w).add(v);
    }

    public Iterable<Integer> adj(int v) {
        return this.adj.get(v);
    }

    public static void main(String[] args) {
        final int vertices = 13;
        Graph graph = new Graph(vertices);
        graph.addEdge(0,1); graph.addEdge(0,2);
        graph.addEdge(0,6); graph.addEdge(0,5);
        graph.addEdge(5,3); graph.addEdge(5,4);
        graph.addEdge(3,4); graph.addEdge(4,6);
        graph.addEdge(7,8); graph.addEdge(9,10);
        graph.addEdge(9,12); graph.addEdge(9,11); graph.addEdge(11,12);
        System.out.println(graph.vertices);
        System.out.println(graph.getEdges());
        for (int v = 0; v < graph.getVertices(); v++) for (int w : graph.adj(v)) System.out.println(v + " - " + w);
    }


}
