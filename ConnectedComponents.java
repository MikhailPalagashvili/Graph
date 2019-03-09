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
        ConnectedComponents cc = new ConnectedComponents(graph);
        System.out.println("There are " + cc.getCount() + " connected components in this graph");
        System.out.println("*****************");
        for (int v = 0; v < graph.getVertices(); v++) System.out.println(cc.getId(v));
    }
}
