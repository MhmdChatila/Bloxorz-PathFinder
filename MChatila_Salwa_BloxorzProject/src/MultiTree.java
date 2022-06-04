public class MultiTree {

	protected multinode root;
	protected int nbnodes = 1;
	protected multinode current = null;

	public MultiTree() {
		root = null;
	}

	public MultiTree(Map data) {
		root = new multinode(data, 1);
	}

	public void setRoot(Map data) {
		root = new multinode(data, 1);
	}

	public multinode search_id(int id) {
		current = null;
		search_id(id, root);
		return current;
	}

	public void search_id(int id, multinode node) {
		if (node == null) {
			return;
		}
		if (node.id == id) {
			current = node;
			return;
		} else {
			for (int i = 0; i < node.children.size(); i++) {
				search_id(id, (multinode) node.children.get(i));
			}
		}
	}

	public multinode search_data(Map t) {
		current = null;
		search_data(t, root);
		return current;
	}

	public void search_data(Map t, multinode node) {
		if (node == null) {
			return;
		}
		Map tt = (Map) node.getData();
		if (tt.isEqual(t)) {
			current = node;
			return;
		} else {
			for (int i = 0; i < node.children.size(); i++) {
				search_data(t, (multinode) node.children.get(i));
			}
		}
	}

	public boolean insertnode(Map data, int Parentid) {
		multinode n = search_id(Parentid);
		if (n != null) {
			n.insertchildren(data, ++nbnodes);
			return true;
		}
		return false;
	}

	public void display() {
		display(root, null);
	}

	public void display(multinode node, multinode nodep) {
		if (node != null) {
			if (nodep != null)
				System.out.println(nodep.getData() + ": " + node.id + ": " + node.getData());
			else
				System.out.println("N: " + node.id + ": " + node.getData());
			for (int i = 0; i < node.children.size(); i++) {
				display(node.getNode(i), node);
			}
		}
	}

	public void display_solution(multinode node) {
		if (node != null) {
			display_solution(node.getParent());
			System.out.println(node.getData());
		}
	}
}