package OOP2.Solution;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import OOP2.Provided.Edge;
import OOP2.Provided.Vertex;

public class DFSGraphWalk implements Iterable<Vertex> {
	
	private Vertex origin;
	
	/*
	 * you must implement a constructor that takes an initial vertex for 
	 * the iteration.
	 */
	public DFSGraphWalk(Vertex origin) {
		this.origin = origin;
	}

	@Override
	public Iterator<Vertex> iterator() {
		return new Iterator<Vertex>() {
			List<Vertex> open = new ArrayList<Vertex>();
			List<Vertex> closed = new ArrayList<Vertex>();
			Vertex current = null;

			@Override
			public boolean hasNext() {
				if (closed.isEmpty() && open.isEmpty() && current == null) {
					return true;
				}
				
				if (open.isEmpty()) {
					return false;
				}
				
				return true;
			}

			@Override
			public Vertex next() {
				// For the first iteration
				if (current == null) {
					current = origin;
					open.add(0, current);
				}
				
				current = open.remove(0);
				
				// Add one adjacent vertex of current to open
				for (Edge e : current.getSuccessors()) {
					Vertex v = e.getEndpoint();
					if (!closed.contains(v)) {
						open.add(0, v);
					}
				}
				
				closed.add(current);
				return current;
			}

			@Override
			public void remove() {
			}
		};
	}
}
