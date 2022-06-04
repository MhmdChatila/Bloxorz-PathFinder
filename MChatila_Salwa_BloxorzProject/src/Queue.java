public class Queue<T> extends LinkedList<T> {
	public Queue() {
		super();
	}

	public Queue(String na) {
		super(na);
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	public void enqueue(T a) {
		insertAtBack(a);
	}

	public T dequeue() {
		return deleteFromFront();
	}

	public int sizeOfQueue() {
		int count = 0;
		Queue<T> temp = new Queue<T>("Temp");
		while (!isEmpty()) {
			T t = dequeue();
			count++;
			temp.enqueue(t);
		}
		while (!temp.isEmpty())
			enqueue(temp.dequeue());
		return count;
	}
}