public class ConnectedComponents {
    private boolean[] marked;
    private int[] id; //id of component containing a given vertex
    private int count; //number of connected components
    private int[] edgeTo;

    public ConnectedComponents(Graph graph) {
        this.marked = new boolean[graph.getVertices()];
        this.id = new int[graph.getVertices()];
        this.edgeTo = new int[graph.getVertices()];
        for (int vertex = 0; vertex < graph.getVertices(); vertex++) {
            if (!marked[vertex]) {
                dfs(graph,vertex); //run dfs from one vertex in each connected component
                count++;
            }

        }
    }
    //all vertices discovered in same call of dfs have the same id
    private void dfs(Graph graph, int vertex) {
        this.marked[vertex] = true;
        this.id[vertex] = count;
        for (int w : graph.adj(vertex)) {
            if (!marked[w])
                dfs(graph,w);
            edgeTo[w] = vertex;
        }
    }

    public int getCount() {
        return this.count;
    }

    public int getId(int vertex) {
        return id[vertex];
    }
}
