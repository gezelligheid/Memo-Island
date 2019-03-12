import java.util.*;

public class Main {

    private static LinkedList<LinkedList<Vertex>> allPaths = new LinkedList<>();

    public static void main(String[] args) {

        LinkedList<Vertex> vertices = new LinkedList<>();
        LinkedList<Edge> edges = new LinkedList<>();

        for (char alphabet = 'a'; alphabet <= 'u'; alphabet++) {
            String str = String.valueOf(alphabet).toUpperCase();
            vertices.add(new Vertex(str, "Watering hole: " + str));
        }
//        System.out.println(vertices.toString());
        edges.push(new Edge("AB", vertices.get(0), vertices.get(1), 2));
        edges.push(new Edge("AO", vertices.get(0), vertices.get(14), 2));
        edges.push(new Edge("BC", vertices.get(1), vertices.get(2), 7));
        edges.push(new Edge("BN", vertices.get(1), vertices.get(13), 2));
        edges.push(new Edge("CD", vertices.get(2), vertices.get(3), 3));
        edges.push(new Edge("CF", vertices.get(2), vertices.get(5), 4));
        edges.push(new Edge("DG", vertices.get(3), vertices.get(6), 6));
        edges.push(new Edge("DH", vertices.get(3), vertices.get(7), 5));
        edges.push(new Edge("DI", vertices.get(3), vertices.get(8), 6));
        edges.push(new Edge("EH", vertices.get(4), vertices.get(7), 2));
        edges.push(new Edge("EJ", vertices.get(4), vertices.get(9), 1));
        edges.push(new Edge("EK", vertices.get(4), vertices.get(10), 3));
        edges.push(new Edge("FG", vertices.get(5), vertices.get(6), 5));
        edges.push(new Edge("FL", vertices.get(5), vertices.get(11), 7));
        edges.push(new Edge("FM", vertices.get(5), vertices.get(12), 4));
        edges.push(new Edge("GH", vertices.get(6), vertices.get(7), 2));
        edges.push(new Edge("GK", vertices.get(6), vertices.get(10), 5));
        edges.push(new Edge("HI", vertices.get(7), vertices.get(8), 3));
        edges.push(new Edge("IJ", vertices.get(8), vertices.get(9), 5));
        edges.push(new Edge("IS", vertices.get(8), vertices.get(18), 4));
        edges.push(new Edge("JP", vertices.get(9), vertices.get(15), 3));
        edges.push(new Edge("JS", vertices.get(9), vertices.get(18), 2));
        edges.push(new Edge("KL", vertices.get(10), vertices.get(11), 5));
        edges.push(new Edge("KR", vertices.get(10), vertices.get(17), 2));
        edges.push(new Edge("LQ", vertices.get(11), vertices.get(16), 6));
        edges.push(new Edge("MN", vertices.get(12), vertices.get(13), 4));
        edges.push(new Edge("MQ", vertices.get(12), vertices.get(16), 4));
        edges.push(new Edge("MT", vertices.get(12), vertices.get(19), 1));
        edges.push(new Edge("NO", vertices.get(13), vertices.get(14), 2));
        edges.push(new Edge("PR", vertices.get(15), vertices.get(17), 6));
        edges.push(new Edge("QR", vertices.get(16), vertices.get(17), 4));
        edges.push(new Edge("SU", vertices.get(18), vertices.get(20), 1));

        Graph graph = new Graph(vertices, edges);
        LinkedList<Vertex> currentPath = new LinkedList<>();
        Set<Vertex> seenSet = new HashSet<>(); // same as current path

        String startVertexId = "T";
        String targetVertexId = "U";

        Vertex source = graph.getVertexById(startVertexId);
        Vertex destination = graph.getVertexById(targetVertexId);


        currentPath.add(source);
        seenSet.add(source);

        //test
        System.out.println(graph.getNeighbours("M").toString());

        recursivePaths(graph, source, destination, seenSet, currentPath);


        // how many paths found
        System.out.println("paths: " + allPaths.size());


//        int testfill = stopsGivenBottle(graph, allPaths.getFirst(), 4);
//        System.out.println("first path needs at most: " + testfill + " fills");

        LinkedList<Vertex> bestPath = null;
        int minStops = 9000;

        int testBottle = 4;

        for (LinkedList<Vertex> path : allPaths) {
            int stops = stopsGivenBottle(graph, path, testBottle);
            if (stops > -1 && stops < minStops) {
                bestPath = (LinkedList<Vertex>) path.clone();
                minStops = stops;
            }
        }
        if (bestPath != null) {
            System.out.println("The desert cross path from hole " + startVertexId +
                    " to " + targetVertexId + " with minimum number of " + minStops + " fills is: ");
            System.out.println(bestPath.toString());
        } else {
            System.out.println("No path possible");
        }

    }

    /**
     * returns a lower bound on the number of stops needed traversing a path given a bottle distance capacity
     */
    public static int stopsGivenBottle(Graph graph, LinkedList<Vertex> path, int bottleSize) {
        Iterator<Vertex> vertexIterator = path.listIterator(1);
        int fills = 1;
        int waterLevel = bottleSize;
        Vertex source = path.getFirst();
        while (vertexIterator.hasNext()) {
            Vertex next = vertexIterator.next();
            int distance = graph.edgeWeight(source.getId(), next.getId());
            if (bottleSize - distance >= 0) {
                if (waterLevel - distance >= 0) {
                    waterLevel = waterLevel - distance;
                } else {
                    fills++;
                    waterLevel = bottleSize;
                }
            } else return -1;
            source = next;
        }
        return fills;
    }

    public static void recursivePaths(Graph graph, Vertex node, Vertex destination, Set<Vertex> seen, LinkedList<Vertex> path) {
        if (node.equals(destination))
            allPaths.add((LinkedList<Vertex>) path.clone());
        List<Vertex> neighbors = graph.getNeighbours(node.getId());
        for (Vertex v : neighbors) {
            if (!seen.contains(v)) {
                seen.add(v);
                path.add(v);
                recursivePaths(graph, v, destination, seen, path);
                seen.remove(v);
                path.removeLastOccurrence(v);
            }
        }
    }


}
