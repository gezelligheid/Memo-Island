import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private final List<Vertex> vertices;
    private final List<Edge> edges;

    public Graph(List<Vertex> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public boolean adjacent(String x, String y) {
        // Returns true when there’s an edge from x to y
        for (Edge edge : edges) {
            if ((edge.getSource().getId().equals(x) && edge.getDestination().getId().equals(y)) ||
                    (edge.getSource().getId().equals(y) && edge.getDestination().getId().equals(x))) {
                return true;
            }
        }
        return false;
    }

    public int edgeWeight(String x, String y) {
        for (Edge edge : edges) {
            if ((edge.getSource().getId().equals(x) && edge.getDestination().getId().equals(y)) ||
                    (edge.getSource().getId().equals(y) && edge.getDestination().getId().equals(x))) {
                return edge.getWeight();
            }
        }
        return -1;
    }

    public List<Vertex> getNeighbours(String vertex) {
        // Returns all neighbours of a given vertex
        LinkedList<Vertex> theNeighbours = new LinkedList<>();
        for (Edge edge : edges) {
            if (edge.getSource().getId().equals(vertex)) {
                theNeighbours.push(edge.getDestination());
            }
            if (edge.getDestination().getId().equals(vertex)){
                theNeighbours.push(edge.getSource());
            }
        }

        return theNeighbours;
    }

    public Vertex getVertexById(String vertexId) {
        for (Vertex vertex : vertices) {
            if (vertex.getId().equals(vertexId))
                return vertex;
        }
        return null;
    }


}