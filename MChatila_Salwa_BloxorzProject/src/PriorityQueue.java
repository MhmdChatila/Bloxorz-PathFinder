public class PriorityQueue<T> extends LinkedList<T> {
	public PriorityQueue() {
		super();
	}

	public PriorityQueue(String na) {
		super(na);
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	public void enqueue(T a, int pr1) {
		insertPr(a, pr1);
	}

	public T dequeue() {
		return deleteFromFront();
	}

	public boolean display() {
		return display();
	}
}