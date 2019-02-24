import java.util.HashSet;
import java.util.Set;

public class TreeExample {

    public static void main(String[] args) {
        Node<String> root = createTree();
        printTree(root, " ");

        // testing on the given tree
        Node<String> testLCS = LCSupervisor(root, "node 111", "node 112");
        System.out.println("lowest common supervisor of node 111 and node 112 is: " + testLCS.getData());

        // what if we have only one employee who is into itself?
        Node<String> alone = LCSupervisor(narcisus(), "Narcisus","Narcisus");
        System.out.println("Independent puritan: " + alone.getData());

        // let Ezra and Fleur fall in love in iPuritan2
        Node<String> ip2 = iPuritan2();
        Node<String> lcs2 = LCSupervisor(ip2, "Ezra","Fleur");
        System.out.println("Ez and Fleur need permission from: " + lcs2.getData());// expected: Bob

        // after iPuritan.com expansion Dan and Heather have chemistry
        Node<String> ip3 = iPuritan3();
        Node<String> lcs3 = LCSupervisor(ip3, "Dan","Heather");
        System.out.println("Dan and Heather need permission from: " + lcs3.getData()); // expected: Dan (convenient)


    }
    private static Node<String> narcisus(){
        return new Node<>("Narcisus");
    }

    private static Node<String> iPuritan2(){
        Node<String> root = new Node<>("Alice");

        Node<String> employee1 = root.addChild(new Node<>("Bob"));
        Node<String> employee12 = employee1.addChild(new Node<>("Ezra"));
        Node<String> employee13 = employee1.addChild(new Node<>("Fleur"));

        Node<String> employee2 = root.addChild(new Node<>("Carl"));
        Node<String> employee3 = root.addChild(new Node<>("Dan"));


        return root;
    }
    private static Node<String> iPuritan3(){
        Node<String> root = new Node<>("Alice");

        Node<String> employee1 = root.addChild(new Node<>("Bob"));
        Node<String> employee12 = employee1.addChild(new Node<>("Ezra"));
        Node<String> employee13 = employee1.addChild(new Node<>("Fleur"));

        Node<String> employee2 = root.addChild(new Node<>("Carl"));
        Node<String> employee3 = root.addChild(new Node<>("Dan"));
        Node<String> employee31 = employee3.addChild(new Node<>("Gio"));
        Node<String> employee311 = employee31.addChild(new Node<>("Heather"));
        return root;
    }


    private static Node<String> createTree() {
        Node<String> root = new Node<>("root");

        Node<String> node1 = root.addChild(new Node<String>("node 1"));

        Node<String> node11 = node1.addChild(new Node<String>("node 11"));
        Node<String> node111 = node11.addChild(new Node<String>("node 111"));
        Node<String> node112 = node11.addChild(new Node<String>("node 112"));


        Node<String> node12 = node1.addChild(new Node<String>("node 12"));

        Node<String> node2 = root.addChild(new Node<String>("node 2"));

        Node<String> node21 = node2.addChild(new Node<String>("node 21"));
        Node<String> node211 = node2.addChild(new Node<String>("node 22"));
        return root;
    }

    private static <T> void printTree(Node<T> node, String appender) {
        System.out.println(appender + node.getData());
        node.getChildren().forEach(each -> printTree(each, appender + appender));
    }

    /**
     * finds a node of a tree containing specific string as data.
     * inspired by:
     * https://stackoverflow.com/questions/5938486/how-to-search-for-a-node-in-a-tree-and-return-it
     *
     * @param node the root of the (sub)tree to search
     */
    private static Node<String> findNode(Node<String> node, String data) {
        if (node != null) {
            if (node.getData().equals(data)) {
                return node;
            } else {
                for (Node<String> child : node.getChildren()) {
                    Node<String> foundNode = findNode(child, data);
                    if (foundNode != null) {
                        return foundNode;
                    }
                }
            }
        }
        return null;

    }

    private static Node<String> LCSupervisor(Node<String> root, String employee1, String employee2) {
        // find both lovers
        Node<String> lover1 = findNode(root, employee1);
        Node<String> lover2 = findNode(root, employee2);
        // make a set of all supervisors of lover1
        Set<Node<String>> supervisorsL1 = new HashSet<>();
        while (lover1 != null){
            supervisorsL1.add(lover1); // lover1 is it's own descendant
            lover1 = lover1.getParent();
        }
        while (lover2 != null){
            if (supervisorsL1.contains(lover2))
                return lover2;
            lover2 = lover2.getParent();
        }

        return null;
    }
}