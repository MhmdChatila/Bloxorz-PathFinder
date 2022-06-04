public class LinkedList<T> {
	public Node<T> first;
	private String name;

	public LinkedList() {
		first = null;
		name = " ";
	}

	public LinkedList(String na) {
		name = na;
		first = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertAtFront(T d) {
		Node<T> p = new Node<T>(d);
		if (isEmpty()) {
			first = p;
		} else {
			p.next = first;
			first = p;
		}
	}

	public void insertAtBack(T a) {
		if (isEmpty())
			first = new Node<T>(a);
		else {
			Node<T> p = new Node<T>(a);
			Node<T> current = first;
			while (current.next != null) {
				current = current.next;
			}
			current.next = p;
		}
	}

	public T deleteFromFront() {
		T temp = first.data;
		if (!isEmpty()) {
			first = first.next;
		}
		return temp;
	}

	public T deleteFromBack() {
		Node<T> current1 = first;
		Node<T> current2 = null;
		while (current1.next != null) {
			current2=current1;
			current1 = current1.next;
		}
		T toReturn = current1.data;
		current2.next = null;

		return toReturn;
	}

	public void insertPr(T d, int pr1) {
		Node<T> p = new Node<T>(d, pr1);

		if (isEmpty()) {
			first = p;
		} else if (first.pr < pr1) {

			Node<T> current = first;
			if (first.next != null) {
				while (current.next.pr < pr1) {
					current = current.next;
					if (current.next == null)
						break;
				}
			}
			p.next = current.next;
			current.next = p;
		} else {
			p.next = first;
			first = p;
		}
	}

	public boolean display() {
		if (isEmpty())
			return false;
		Node<T> current = first;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		return true;
	}

}