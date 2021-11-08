import java.util.List;

public class DepthFirstSearch {


	public CreateGraph exec(CreateGraph Node) {
		int depth = 13;
		return DFSSearchFunction(Node, depth);
		
	}

	private CreateGraph DFSSearchFunction(CreateGraph node, int depth) {
		if(node.isSolution()) {
			return node;
		}
		else if(depth ==0){
			return null;
		}
		else {
			List<CreateGraph> childrens = node.generateVerticesandEdges();
			for (CreateGraph child : childrens) {
				CreateGraph result = DFSSearchFunction(child, depth - 1);
				if (null != result) {
					return result;
				}
			}
		}
		return null;
	}
}
