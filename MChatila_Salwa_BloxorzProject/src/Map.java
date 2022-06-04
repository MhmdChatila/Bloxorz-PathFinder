public class Map {
	// map of given level
	int terrain[][];
	// current state represented as (x1, y1, x2, y2)
	int x1;
	int y1;
	int x2;
	int y2;
	// action taken
	String action = "Initial state: ";
	// g(n) of current state
	int g;

	// Constructor to initialize map and initial state
	// x1, y1 is always less than x2, y2 respectively
	public Map(int[][] terrain, int x1, int y1, int x2, int y2) {
		super();
		this.terrain = terrain;
		if (x1 < x2) {
			this.x1 = x1;
			this.x2 = x2;
		} else {
			this.x1 = x2;
			this.x2 = x1;
		}
		if (y1 < y2) {
			this.y1 = y1;
			this.y2 = y2;
		} else {
			this.y1 = y2;
			this.y2 = y1;
		}
		this.g = 0;
	}

	public Map(Map m) {
		if (m != null) {
			this.terrain = m.terrain;
			this.x1 = m.x1;
			this.x2 = m.x2;
			this.y1 = m.y1;
			this.y2 = m.y2;
			this.g = m.g;
		}
	}
	
	public Map() {
		super();
	}
	
	public Map(int[][] terrain) {
		super();
		this.terrain = terrain;
	}

	// Method to check if the current state is equal to goal state
	public boolean isEqual(Map m) {
		if (x1 == m.x1 && x2 == m.x2 && y1 == m.y1 && y2 == m.y2)
			return true;
		else
			return false;
	}

	// Method to return string of state description
	public String toString() {
		return action + "(" + x1 + ", " + y1 + ", " + x2 + ", " + y2 + ")";
	}

	public boolean checkTile() {
		if (terrain[x1][y1] == 1 && terrain[x2][y2] == 1)
			return true;
		else
			return false;
	}

	// print the terrain
	public void displayTerrain() {
		System.out.print(" ");
		for (int i = 0; i < terrain[0].length; i++) {
			System.out.print(" "+i+" ");
		}
		System.out.println();
		
		for (int i = 0; i < terrain.length; i++) {
			System.out.print(i);
			for (int j = 0; j < terrain[0].length; j++) {
				if(terrain[i][j]==1) {
					System.out.print(" * ");
				}else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}
	}

}