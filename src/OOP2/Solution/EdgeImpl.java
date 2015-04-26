package OOP2.Solution;

import OOP2.Provided.Edge;
import OOP2.Provided.Vertex;


public class EdgeImpl implements Edge, Comparable<Edge> {

	private Vertex mDestVertex;
	
	public EdgeImpl(Vertex toVertex) {
		mDestVertex = toVertex;
	}
	
	@Override
	public Vertex getEndpoint() {
		return mDestVertex;
	}
	
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof EdgeImpl)) {
			return false;
		}
		
		return mDestVertex.equals(((EdgeImpl) other).getEndpoint());
	}

	@Override
	public int compareTo(Edge o) {
		return this.equals(o) ? 0 : 1;
	}

}
