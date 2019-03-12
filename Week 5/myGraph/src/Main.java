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
        String targetVertexId = "N";

        Vertex source = graph.getVertexById(startVertexId);
        Vertex destination = graph.getVertexById(targetVertexId);


        currentPath.add(source);
        seenSet.add(source);

        //test
        System.out.println(graph.getNeighbours("M").toString());

        recursivePaths(graph,source,destination,seenSet,currentPath);


        // how many paths found
        System.out.println("paths: " + allPaths.size());



        for (LinkedList<Vertex> path : allPaths) {
            for (Vertex v: path) {
                System.out.print(v.toString() + " -> ");
            }
            System.out.println();
        }
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


//    private static boolean stuck(Vertex toCheck) {
//        if (toCheck.getId().equals(targetVertex)) {
//            return false;
//        }
//        List<Vertex> adjacent = graph.getNeighbours(toCheck.getId());
//        for (Vertex v : adjacent) {
//            if (!seenSet.contains(v)) {
//                seenSet.add(v);
////                currentPath.add(v);
//                if (!stuck(v)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    private static void searchAllPaths(Vertex start) {
//        if (start.getId().equals(targetVertex)) {
//            allPaths.add(currentPath);
//        }
//
//        if (stuck(start)) {
//            return;
//        }
//        List<Vertex> adjacent = graph.getNeighbours(start.getId());
//        for (Vertex v : adjacent) {
//            currentPath.push(v);
//            searchAllPaths(v);
//            currentPath.removeLastOccurrence(v);
//        }
//    }


}
