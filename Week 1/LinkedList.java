import java.util.List;

// Singly Linked List class
public class LinkedList<T>  {
    Node<T> head;  // head of list

    /* Inserts a new Node at front of the list. */
    public void add(T data) {
        Node<T> tNode = new Node<>(data);
        tNode.setNext(head);
        head = tNode;


    }

    /* Delete all nodes with given data */
    public void delete(T data) {
        // Finish this method
    }

    /* Get data at index i */
    public T get(int i) {
        // Finish this method
        return head.getElement();
    }

    /* Returns count of nodes in linked list */
    public int getCount() {
        // Finish this method
        return -1;
    }
}