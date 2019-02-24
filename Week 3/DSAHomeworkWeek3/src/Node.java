import java.util.ArrayList;
import java.util.List;

public class Node<T> {

    private T data = null;

    private List<Node<T>> children = new ArrayList<>();

    private Node<T> parent = null;

    public Node(T data) {
        this.data = data;
    }

    public Node getRoot() {
        Node<T> root = this;
        while (!(this.parent == null))
            root = this.parent;
        return root;
    }

    public Node<T> addChild(Node<T> child) {
        // Finish this method
        child.setParent(this);
        this.children.add(child);
        return child;
    }

    public void addChildren(List<Node<T>> children) {
        // Finish this method
        this.children.addAll(children);
    }

    public List<Node<T>> getChildren() {
        // Finish this method
        return this.children;
    }

    public T getData() {
        // Finish this method
        return this.data;
    }

    public void setData(T data) {
        // Finish this method
        this.data = data;
    }

    private void setParent(Node<T> parent) {
        // Finish this method
        this.parent = parent;
    }

    public Node<T> getParent() {
        // Finish this method
        return this.parent;
    }

}