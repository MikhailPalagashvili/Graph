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


}
