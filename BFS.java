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
        BFS paths = new BFS(graph, source);
        for (int v = 0; v < graph.getVertices(); v++) if (paths.hasPathTo(v)) System.out.println(paths.pathTo(v));
    }


}
