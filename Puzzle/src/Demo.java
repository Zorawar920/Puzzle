import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Demo {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println("Cannibal and Missionaires");
      System.out.println("Choose the search method: ");
	  System.out.println("\t 1. Breadth-first search");
	  System.out.println("\t 2. Depth-first search");
	  System.out.print("\nType your choice and press ENTER: ");

	String optionStr = null;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		optionStr = in.nextLine();

		int option = Integer.parseInt(optionStr);
		CreateGraph initialState = new CreateGraph(3, 3, BoatLocation.LEFT_BANK, 0, 0, 5);
		switch(option) {
		case 1:
			executeBFS(initialState);
			break;
		case 2:
			executeDFS(initialState);
			break;
		default:
			System.out.println("[ERROR] Invalid search option.");
		}
	}

	private static void executeDFS(CreateGraph initialState) {
		// TODO Auto-generated method stub
		DepthFirstSearch search = new DepthFirstSearch();
		CreateGraph solution = search.exec(initialState);
		printSolution(solution);
	}

	private static void printSolution(CreateGraph solution) {
		// TODO Auto-generated method stub
		if (null == solution) {
			System.out.print("\nNo solution found.");
		} else {
	
			List<CreateGraph> path = new ArrayList<CreateGraph>();
			
			CreateGraph Node = solution;
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

	private static void executeBFS(CreateGraph initialState) {
		// TODO Auto-generated method stub
		BreadthFirstSearch search = new BreadthFirstSearch();
		CreateGraph solution = search.exec(initialState);
		printSolution(solution);
		
	}

}
