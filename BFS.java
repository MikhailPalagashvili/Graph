import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
    private boolean marked[];
    private int[] edgeTo;
    private int[] distTo;
    private int source;

    public BFS(Graph graph, int source) {
        this.marked = new boolean[graph.getVertices()];
        this.edgeTo = new int[graph.getVertices()];
        this.distTo = new int[graph.getVertices()];
        this.source = source;
        bfs(graph,source);
    }

    private void bfs(Graph graph, int source) {
        Queue<Integer> q = new LinkedList <>();
        q.add(source);
        marked[source] = true;
        while (!q.isEmpty()) {
           int v = q.poll();

           for (int w : graph.adj(v)) {
               if (!marked[v]) q.add(w);
               marked[w] = true;
               edgeTo[w] = v;
           }

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
