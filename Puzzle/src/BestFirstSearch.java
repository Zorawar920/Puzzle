import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class BestFirstSearch
{
	
	public CreateGraph exec(CreateGraph Node) {
		if(Node.isSolution()) {
			return Node;
		}
		Queue<CreateGraph> visited = new LinkedList<CreateGraph>();
		Set<CreateGraph> explored = new HashSet<CreateGraph>();
		visited.add(Node);
		while(true) {
			if(visited.isEmpty()) {
				return null;
			}
			CreateGraph cg = visited.poll();
			explored.add(cg);
			List<CreateGraph> children = cg.generateVerticesandEdges();
			List<Integer> arr = new ArrayList<Integer>();
			for (CreateGraph child : children) {
				if (!explored.contains(child) || !visited.contains(child)) {
					if (child.isSolution()) {
						return child;
					}
					int val = child.getheurisitcValue();
                    arr.add(val);
				}
			}
			int min = Collections.min(arr);
			for (CreateGraph child : children) {
			 if(child.getheurisitcValue() == min && !visited.contains(child)) {
				 visited.add(child);
			}
			}
		}
	}
}	   