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
}
