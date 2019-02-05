import java.util.List;

public class Graph {
    private final List<Vertex> vertexes;
    private final List<Edge> edges;

    public Graph(List<Vertex> vertexes, List<Edge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
    }

    public List<Vertex> getVertexes() {
        return vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public boolean adjacent(String x, String y)	{
        // Returns true when there’s an edge from x to y
        // TODO: Implement this method
        return false;
    }

    public List<Vertex> getNeighbours(String vertex) {
        // Returns all neighbours of a given vertex
        // TODO: Implement this method
        return null;
    }


}