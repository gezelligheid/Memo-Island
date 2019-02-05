public class Node<T>
{
    T data;
    Node<T> next;
    Node(T d)  { data = d;  next = null; }

    public void setNext(Node<T> newNext) {
        next = newNext;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getElement() {
    	return data;
    }
}