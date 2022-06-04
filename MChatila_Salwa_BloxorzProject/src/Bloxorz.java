import java.util.Scanner;

public class Bloxorz {

	public static void main(String[] args) {

		float start, end;
		Scanner con = new Scanner(System.in);
		System.out.println("==============================");
		System.out.println("Welcome To Bloxorz Path Finder");
		System.out.println("==============================");

		int[][] t = { { 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 1, 1, 1, 0 } };

		System.out.println();
		Map stageI = new Map(t, 1, 1, 1, 1);
		Map stageG = new Map(t, 4, 7, 4, 7);
		PathFinder s = new PathFinder();
		MultiTree stage1 = new MultiTree(stageI);

		System.out.println("BLOXORZ - STAGE 01");
		System.out.println("Initial state = (1, 1, 1, 1)");
		System.out.println("Goal state = (4, 7, 4, 7)");

		System.out.println();
		System.out.println("-------Using DFS----------");
		s.DFS(stage1, stageG);
		System.out.println("-------Using IDS----------");
		s.IDS(stage1, stageG);
		System.out.println("-------Using BFS----------");
		s.BFS(stage1, stageG);
		System.out.println("-------Using aStar----------");
		s.aStar(stage1, stageG);

		Map current = new Map(t);
		current.displayTerrain();
		Map goal = new Map(t);

		try {
			do {
				System.out.println("Please enter valid coordinates of your bloxorz");
				System.out.print("x: ");
				int x = con.nextInt();
				System.out.print("y: ");
				int y = con.nextInt();
				current.x1 = x;
				current.x2 = x;
				current.y1 = y;
				current.y2 = y;

			} while (!current.checkTile());
		} catch (Exception e) {
			System.out.println("Error Occured please check your inputs");
		}

		try {
			do {
				System.out.println("Please enter valid coordinates of your goal");
				System.out.print("x: ");
				int x = con.nextInt();
				System.out.print("y: ");
				int y = con.nextInt();
				goal.x1 = x;
				goal.x2 = x;
				goal.y1 = y;
				goal.y2 = y;

			} while (!goal.checkTile());
		} catch (Exception e) {
			System.out.println("Error Occured please check your inputs");
		}

		MultiTree cu = new MultiTree(current);
		PathFinder f = new PathFinder();

		try {
			if (current.checkTile() && goal.checkTile()) {
				start = 0;
				end = 0;
				System.out.println("-------Using DFS----------");
				start = System.nanoTime();
				f.DFS(cu, goal);
				end = (System.nanoTime() - start) / 1000000000;
				System.out.println("DFS took: " + end + " seconds.");

				start = 0;
				end = 0;
				System.out.println("-------Using IDS----------");
				start = System.nanoTime();
				f.IDS(cu, goal);
				end = (System.nanoTime() - start) / 1000000000;
				System.out.println("IDS took: " + end + " seconds.");

				start = 0;
				end = 0;
				System.out.println("-------Using BFS----------");
				start = System.nanoTime();
				f.BFS(cu, goal);
				end = (System.nanoTime() - start) / 1000000000;
				System.out.println("BFS took: " + end + " seconds.");

				start = 0;
				end = 0;
				System.out.println("-------Using aStar----------");
				start = System.nanoTime();
				f.aStar(cu, goal);
				end = (System.nanoTime() - start) / 1000000000;
				System.out.println("aSTAR took: " + end + " seconds.");
			}
		} catch (Exception e) {
			System.out.println("Couldn't find the path check inputs and try again!");
		}

	}

}