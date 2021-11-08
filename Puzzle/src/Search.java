import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Search {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  System.out.println("Cannibal and Missionaires");
	      System.out.println("Choose the search method: ");
		  System.out.println("\t 1. Greedy Best-first search");
		  System.out.println("\t 2. A* Search");
		  System.out.print("\nType your choice and press ENTER: ");
		  
		  String optionStr = null;
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			optionStr = in.nextLine();

			int option = Integer.parseInt(optionStr);
			CreateGraph initialState = new CreateGraph(3, 3, BoatLocation.LEFT_BANK, 0, 0, 5);
			switch(option) {
			case 1:
				executeBestFirstSearch(initialState);
				break;
			case 2:
				executeASearch(initialState);
				break;
			default:
				System.out.println("[ERROR] Invalid search option.");
			}
}

	private static void executeASearch(CreateGraph initialState) {
		// TODO Auto-generated method stub
		ASearch bfs = new ASearch();
		CreateGraph sol = bfs.exec(initialState);
		printPath(sol);
	}

	private static void executeBestFirstSearch(CreateGraph initialState) {
		// TODO Auto-generated method stub
		BestFirstSearch bfs = new BestFirstSearch();
		CreateGraph sol = bfs.exec(initialState);
		printPath(sol);
	}

	private static void printPath(CreateGraph sol) {
		// TODO Auto-generated method stub
		if (null == sol) {
			System.out.print("\nNo solution found.");
		} else {
	
			List<CreateGraph> path = new ArrayList<CreateGraph>();
			
			CreateGraph Node = sol;
			while(null!=Node) {
				path.add(Node);
				Node = Node.getRootNode();
			}

			int depth = path.size() - 1;
			for (int i = depth; i >= 0; i--) {
				Node = path.get(i);
				if (Node.isSolution()) {
					System.out.print(Node.toString());
				} else {
					System.out.print(Node.toString() + " -> ");
				}
			}
			System.out.println("");
			
		}
	}
}


