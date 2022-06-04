import java.util.ArrayList;

public class multinode {
	protected Map data;
	protected int id = 1;
	protected multinode parent = null;
	protected ArrayList<multinode> children;

	public multinode(Map data, int id) {
		this.data = data;
		children = new ArrayList<multinode>();
		parent = null;
		this.id = id;
	}

	public multinode(Map data, multinode p, int id) {
		this.data = data;
		children = new ArrayList<multinode>();
		parent = p;
		this.id = id;
	}

	public void setData(Map data) {
		this.data = data;
	}

	public Map getData() {
		return data;
	}

	public multinode getNode(int x) {
		if (x >= 0 && x < children.size()) {
			return children.get(x);

		} else {
			return null;

		}
	}

	public multinode getParent() {
		return parent;
	}

	public void insertchildren(Map data, int id) {
		multinode n = new multinode(data, this, id);
		children.add(n);
	}

	boolean isEmpty() {
		return data == null;
	}
}