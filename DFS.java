import java.util.Queue;
import java.util.Stack;

public class DFS {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public DFS(Graph graph, int source) {
        this.source = source;
        this.edgeTo = new int[graph.getVertices()];
        marked = new boolean[graph.getVertices()];
        dfs(graph, source);
    }

    private void dfs(Graph graph, int vertex) {
        marked[vertex] = true;
        for (int w : graph.adj(vertex)) {
            if (!marked[w])
                dfs(graph,w);
            edgeTo[w] = vertex;
        }
    }

    public boolean hasPathTo(int vertex) {
        return marked[vertex];
    }

    public Iterable<Integer> pathTo(int vertex) {
        if (!hasPathTo(vertex)) return null;
        Stack <Integer> path = new Stack <>();
        for (int x = vertex; x != source ; x = edgeTo[x]) path.push(x);
        path.push(source);
        return path;
    }

    public static void main(String[] args) {
        final int vertices = 13;
        final int source = 0;
        Graph graph = new Graph(vertices);
        graph.addEdge(0,1); graph.addEdge(0,2);
        graph.addEdge(0,6); graph.addEdge(0,5);
        graph.addEdge(5,3); graph.addEdge(5,4);
        graph.addEdge(3,4); graph.addEdge(4,6);
        graph.addEdge(7,8); graph.addEdge(9,10);
        graph.addEdge(9,12); graph.addEdge(9,11); graph.addEdge(11,12);
        DFS paths = new DFS(graph, source);
        for (int v = 0; v < graph.getVertices(); v++) if (paths.hasPathTo(v)) System.out.println(paths.pathTo(v));
    }
}
