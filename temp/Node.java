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
		// Finish this method
	}
 
	public Node<T> addChild(Node<T> child) {
		// Finish this method
	}
 
	public void addChildren(List<Node<T>> children) {
		// Finish this method
	}
 
	public List<Node<T>> getChildren() {
		// Finish this method
	}
 
	public T getData() {
		// Finish this method
	}
 
	public void setData(T data) {
		// Finish this method
	}
 
	private void setParent(Node<T> parent) {
		// Finish this method
	}
 
	public Node<T> getParent() {
		// Finish this method
	}

}