import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {
	
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
		for (CreateGraph child : children) {
			if (!explored.contains(child) || !visited.contains(child)) {
				if (child.isSolution()) {
					return child;
				}
				visited.add(child);
			}
		}
	}
}
}
