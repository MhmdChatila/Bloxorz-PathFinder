public class PathFinder {

	MultiTree tree;
	boolean flag = false;
	int maxDepth;

	public Map possibleMoves(char op, Map before) {

		Map after = new Map(before);

		if (op == 'l') {
			if (before.x1 == before.x2 && before.y1 == before.y2) { // standing up
				after.y1 = before.y1 - 1;
				after.y2 = before.y2 - 2;
			} else if (before.x1 == before.x2 && before.y1 != before.y2) { // laying down horizontally
				after.y1 = before.y1 - 1;
				after.y2 = before.y2 - 2;
			} else if (before.x1 != before.x2 && before.y1 == before.y2) { // laying down vertically
				after.y1 = before.y1 - 1;
				after.y2 = before.y2 - 1;
			}
			if (after.y1 < 0 || after.y2 < 0)
				return null;
			else if (!after.checkTile())
				return null;
			else
				after.action = "Move Left: ";
		}
		if (op == 'r') {
			if (before.x1 == before.x2 && before.y1 == before.y2) { // standing up
				after.y1 = before.y1 + 2;
				after.y2 = before.y2 + 1;
			} else if (before.x1 == before.x2 && before.y1 != before.y2) { // laying down horizontally
				after.y1 = before.y1 + 2;
				after.y2 = before.y2 + 1;
			} else if (before.x1 != before.x2 && before.y1 == before.y2) { // laying down vertically
				after.y1 = before.y1 + 1;
				after.y2 = before.y2 + 1;
			}
			if (after.y1 > after.terrain[0].length - 1 || after.y2 > after.terrain[0].length - 1)
				return null;
			else if (!after.checkTile())
				return null;
			else
				after.action = "Move Right: ";
		}
		if (op == 'u') {
			if (before.x1 == before.x2 && before.y1 == before.y2) { // standing up
				after.x1 = before.x1 - 1;
				after.x2 = before.x2 - 2;
			} else if (before.x1 == before.x2 && before.y1 != before.y2) { // laying down horizontally
				after.x1 = before.x1 - 1;
				after.x2 = before.x2 - 1;
			} else if (before.x1 != before.x2 && before.y1 == before.y2) { // laying down vertically
				after.x1 = before.x1 - 1;
				after.x2 = before.x2 - 2;
			}
			if (after.x1 < 0 || after.x2 < 0)
				return null;
			else if (!after.checkTile())
				return null;
			else
				after.action = "Move Up: ";
		}
		if (op == 'd') {
			if (before.x1 == before.x2 && before.y1 == before.y2) { // standing up
				after.x1 = before.x1 + 1;
				after.x2 = before.x2 + 2;
			} else if (before.x1 == before.x2 && before.y1 != before.y2) { // laying down horizontally
				after.x1 = before.x1 + 1;
				after.x2 = before.x2 + 1;
			} else if (before.x1 != before.x2 && before.y1 == before.y2) { // laying down vertically
				after.x1 = before.x1 + 2;
				after.x2 = before.x2 + 1;
			}
			if (after.x1 > after.terrain.length - 1 || after.x2 > after.terrain.length - 1)
				return null;
			else if (!after.checkTile())
				return null;
			else
				after.action = "Move Down: ";
		}
		// make sure x1, y1 < x2, y2
		if (after.x1 <= after.x2 && after.y1 <= after.y2) {
			return after;
		} else {
			int tmpX = after.x2;
			after.x2 = after.x1;
			after.x1 = tmpX;
			int tmpY = after.y2;
			after.y2 = after.y1;
			after.y1 = tmpY;
			return after;
		}

	}

	public void DFS(MultiTree tr, Map goal) {
		tree = tr;
		flag=false;
		DFS(tr.root, goal, 0);
	}

	public void DFS(multinode n, Map goal, int c) {
		c++;
		if (c > 50 || flag) {
			return;
		}
		Map cur = n.data;
		if (cur.isEqual(goal)) {
			tree.display_solution(n);
			flag = true;
			return;
		} else {
			Map t1 = possibleMoves('l', cur);
			Map t2 = possibleMoves('r', cur);
			Map t3 = possibleMoves('u', cur);
			Map t4 = possibleMoves('d', cur);
			if (t1 != null) {
				tree.insertnode(t1, n.id);
				multinode k = tree.search_data(t1);
				DFS(k, goal, c);
			}
			if (t2 != null) {
				tree.insertnode(t2, n.id);
				multinode k = tree.search_data(t2);
				DFS(k, goal, c);
			}
			if (t3 != null) {
				tree.insertnode(t3, n.id);
				multinode k = tree.search_data(t3);
				DFS(k, goal, c);
			}
			if (t4 != null) {
				tree.insertnode(t4, n.id);
				multinode k = tree.search_data(t4);
				DFS(k, goal, c);
			}
		}
	}

	public void IDS(MultiTree tr, Map goal) {
		tree = tr;
		flag = false;
		for (maxDepth = 1; maxDepth < 50; maxDepth++)
			IDS(tr.root, goal, 0);
	}

	public void IDS(multinode n, Map goal, int c) {
		c++;
		if (c > maxDepth || flag) {
			return;
		}
		Map cur = n.data;
		if (cur.isEqual(goal)) {
			tree.display_solution(n);
			flag = true;
			return;
		} else {
			Map t1 = possibleMoves('l', cur);
			Map t2 = possibleMoves('r', cur);
			Map t3 = possibleMoves('u', cur);
			Map t4 = possibleMoves('d', cur);
			if (t1 != null) {
				tree.insertnode(t1, n.id);
				multinode k = tree.search_data(t1);
				IDS(k, goal, c);
			}
			if (t2 != null) {
				tree.insertnode(t2, n.id);
				multinode k = tree.search_data(t2);
				IDS(k, goal, c);
			}
			if (t3 != null) {
				tree.insertnode(t3, n.id);
				multinode k = tree.search_data(t3);
				IDS(k, goal, c);
			}
			if (t4 != null) {
				tree.insertnode(t4, n.id);
				multinode k = tree.search_data(t4);
				IDS(k, goal, c);
			}
		}
	}

	public void BFS(MultiTree tr, Map goal) {
		tree = tr;

		Queue<multinode> tmp = new Queue<multinode>();
		tmp.enqueue(tr.root);

		while (!tmp.isEmpty()) {
			multinode t = tmp.dequeue();

			if (t.data.isEqual(goal)) {
				tree.display_solution(t);
				return;
			} else {
				Map t1 = possibleMoves('l', t.data);
				Map t2 = possibleMoves('r', t.data);
				Map t3 = possibleMoves('u', t.data);
				Map t4 = possibleMoves('d', t.data);

				if (t1 != null) {
					tree.insertnode(t1, t.id);
					multinode k = tree.search_data(t1);
					tmp.enqueue(k);
				}
				if (t2 != null) {
					tree.insertnode(t2, t.id);
					multinode k = tree.search_data(t2);
					tmp.enqueue(k);
				}
				if (t3 != null) {
					tree.insertnode(t3, t.id);
					multinode k = tree.search_data(t3);
					tmp.enqueue(k);
				}
				if (t4 != null) {
					tree.insertnode(t4, t.id);
					multinode k = tree.search_data(t4);
					tmp.enqueue(k);
				}
			}
		}

	}

	
	// returns  h(n) of current state using Chebyshev distance
	private int chebyshev(Map cur, Map goal) {
		return Math.max(Math.abs(cur.x2 - goal.x1), Math.abs(cur.y2 - goal.y1));
	}
	
	
	public void aStar(MultiTree tr, Map goal) {
		tree = tr;

		MultiTree visited = new MultiTree(tr.root.data);
		PriorityQueue<multinode> tmp = new PriorityQueue<multinode>();
		int gn = tree.root.data.g;
		int hn = chebyshev(tree.root.data, goal);
		tmp.enqueue(tr.root, gn+hn);
		
		while (!tmp.isEmpty()) {
			multinode t = tmp.dequeue();
			if (t.data.isEqual(goal)) {
				tree.display_solution(t);
				return;
			} else {
				Map t1 = possibleMoves('l', t.data);
				Map t2 = possibleMoves('r', t.data);
				Map t3 = possibleMoves('u', t.data);
				Map t4 = possibleMoves('d', t.data);

				if (t1 != null && visited.search_data(t1) == null) {
					tree.insertnode(t1, t.id);
					visited.insertnode(t1, t.id);
					multinode k = tree.search_data(t1);
					t1.g = t.data.g + 1;
					gn = t1.g;
					hn = chebyshev(t1, goal);
					tmp.enqueue(k, gn+hn);
				}
				if (t2 != null && visited.search_data(t2) == null) {
					tree.insertnode(t2, t.id);
					visited.insertnode(t2, t.id);
					multinode k = tree.search_data(t2);
					t2.g = t.data.g + 1;
					gn = t2.g;
					hn = chebyshev(t2, goal);
					tmp.enqueue(k, gn+hn);				}
				if (t3 != null && visited.search_data(t3) == null) {
					tree.insertnode(t3, t.id);
					visited.insertnode(t3, t.id);
					multinode k = tree.search_data(t3);
					t3.g = t.data.g + 1;
					gn = t3.g;
					hn = chebyshev(t3, goal);
					tmp.enqueue(k, gn+hn);
				}
				if (t4 != null && visited.search_data(t4) == null) {
					tree.insertnode(t4, t.id);
					visited.insertnode(t4, t.id);
					multinode k = tree.search_data(t4);
					t4.g = t.data.g + 1;
					gn = t4.g;
					hn = chebyshev(t4, goal);
					tmp.enqueue(k, gn+hn);				}
			}
		}

	}
	
}