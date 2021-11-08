import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class CreateGraph {

	 private static final int MIN_TOTAL = 1;

	 private static final int MIN_BOAT_CAPACITY = 1;

	    private int cannibalatLeftBank;
	    private int missionaryatLeftBank;
		@SuppressWarnings("unused")
		private int cannibalatRightBank;
		@SuppressWarnings("unused")
		private int missionaryatRightBank;
		@SuppressWarnings("unused")
		private BoatLocation boatLocation;
		
		private String HeurisitcValue;
	    
	    private CreateGraph rootNode;

		public CreateGraph(int cannibalLeft, int missionaryLeft, BoatLocation location,
				int cannibalRight, int missionaryRight, int heurisitcValue) {
			this.cannibalatLeftBank = cannibalLeft;
			this.missionaryatLeftBank = missionaryLeft;
			this.boatLocation = location;
			this.cannibalatRightBank = cannibalRight;
			this.missionaryatRightBank = missionaryRight;
			this.HeurisitcValue = Integer.toString(heurisitcValue);
		}
	 
	 public List<CreateGraph> generateVerticesandEdges(){
		 
	     List<CreateGraph> graphVertices = new ArrayList<CreateGraph>();
		 
		 if(boatLocation == BoatLocation.LEFT_BANK) {
			 
			Validate(graphVertices, new CreateGraph(cannibalatLeftBank, missionaryatLeftBank - 2, boatLocation.RIGHT_BANK,
					cannibalatRightBank, missionaryatRightBank + 2, cannibalatLeftBank + missionaryatLeftBank - 3)); // Two missionaries cross left to right.
			Validate(graphVertices, new CreateGraph(cannibalatLeftBank - 2, missionaryatLeftBank, boatLocation.RIGHT_BANK,
					cannibalatRightBank + 2, missionaryatRightBank, cannibalatLeftBank + missionaryatLeftBank - 3)); // Two cannibals cross left to right.
			Validate(graphVertices, new CreateGraph(cannibalatLeftBank - 1, missionaryatLeftBank - 1, boatLocation.RIGHT_BANK,
					cannibalatRightBank + 1, missionaryatRightBank + 1, cannibalatLeftBank + missionaryatLeftBank - 3)); // One missionary and one cannibal cross left to right.
			Validate(graphVertices, new CreateGraph(cannibalatLeftBank, missionaryatLeftBank - 1, boatLocation.RIGHT_BANK,
					cannibalatRightBank, missionaryatRightBank + 1, cannibalatLeftBank + missionaryatLeftBank - 2)); // One missionary crosses left to right.
			Validate(graphVertices, new CreateGraph(cannibalatLeftBank - 1, missionaryatLeftBank, boatLocation.RIGHT_BANK,
					cannibalatRightBank + 1, missionaryatRightBank, cannibalatLeftBank + missionaryatLeftBank - 2)); // One cannibal crosses left to right.
		 }else {
			 
			 Validate(graphVertices, new CreateGraph(cannibalatLeftBank, missionaryatLeftBank + 2, boatLocation.LEFT_BANK,
					 cannibalatRightBank, missionaryatRightBank - 2, cannibalatLeftBank + 1 + missionaryatLeftBank)); // Two missionaries cross right to left.
			 Validate(graphVertices, new CreateGraph(cannibalatLeftBank + 2, missionaryatLeftBank, boatLocation.LEFT_BANK,
					 cannibalatRightBank - 2, missionaryatRightBank, cannibalatLeftBank + 1 + missionaryatLeftBank)); // Two cannibals cross right to left.
			 Validate(graphVertices, new CreateGraph(cannibalatLeftBank + 1, missionaryatLeftBank + 1, boatLocation.LEFT_BANK,
					 cannibalatRightBank - 1, missionaryatRightBank - 1,  cannibalatLeftBank + 1 + missionaryatLeftBank)); // One missionary and one cannibal cross right to left.
			 Validate(graphVertices, new CreateGraph(cannibalatLeftBank, missionaryatLeftBank + 1, boatLocation.LEFT_BANK,
					 cannibalatRightBank, missionaryatRightBank - 1,  cannibalatLeftBank + 1 + missionaryatLeftBank)); // One missionary crosses right to left.
			 Validate(graphVertices, new CreateGraph(cannibalatLeftBank + 1, missionaryatLeftBank, boatLocation.LEFT_BANK,
					 cannibalatRightBank - 1, missionaryatRightBank,  cannibalatLeftBank + 1 + missionaryatLeftBank)); // One cannibal crosses right to left.
		 }
			 
		return graphVertices;
		 
	 }
	 
	 private void Validate(List<CreateGraph> graphVertices, CreateGraph createGraph) {
		// TODO Auto-generated method stub
		if(createGraph.isValid())
		{
			createGraph.setRootNode(this);
			graphVertices.add(createGraph);
		}
	}

	private void setRootNode(CreateGraph createGraph) {
		// TODO Auto-generated method stub
		this.rootNode = createGraph;
	}

	public boolean isValid() {
		 if(cannibalatLeftBank >=0 && missionaryatLeftBank >=0 && cannibalatRightBank >= 0 && missionaryatRightBank >= 0
	               && (missionaryatLeftBank == 0 || missionaryatLeftBank >= cannibalatLeftBank)
	               && (missionaryatRightBank == 0 || missionaryatRightBank >= cannibalatRightBank))
		 {return true;}
		 return false;
	 }
	 public boolean isSolution() {
		 if(cannibalatLeftBank == 0 && missionaryatLeftBank == 0) {
			 return true;
		 }
		 return false;
	 }
	 
	 @Override
		public String toString() {
			if (boatLocation == BoatLocation.LEFT_BANK) {
				return "(" + cannibalatLeftBank +"CL" + "," + missionaryatLeftBank + "ML" + ",L,"
	        			+ cannibalatRightBank +"CR" + "," + missionaryatRightBank +"MR" + ")";
			} else {
				return "(" + cannibalatLeftBank + "CL" + "," + missionaryatLeftBank +"ML" + ",R,"
	        			+ cannibalatRightBank + "CR" + "," + missionaryatRightBank +"MR" + ")";
			}
	     }
	 public CreateGraph getRootNode() {
			return rootNode;
		}
	 
	 public int getheurisitcValue()
	 {
		 int val = Integer.parseInt(HeurisitcValue);
		 return val;
	 }
}
