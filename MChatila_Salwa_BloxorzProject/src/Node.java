public class Node<T> {
	public T data;
	public Node next;
	public int pr = 0;

	public Node() {
		data = null;
		next = null;
	}

	public Node(T data) {
		this.data = data;
		next = null;
	}

	public Node(T data, int p) {
		this.data = data;
		next = null;
		pr = p;
	}
}