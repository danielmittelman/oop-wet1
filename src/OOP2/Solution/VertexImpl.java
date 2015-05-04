package OOP2.Solution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import OOP2.Provided.Edge;
import OOP2.Provided.Vertex;


public class VertexImpl implements Vertex {
	
	private String mName;
	private int mValue;
	private SortedSet<Edge> mEdges;
	

	public VertexImpl(String name,int val) {
		mName = name;
		mValue = val;
		mEdges = new TreeSet<Edge>();
	}

	@Override
	public void connect(Vertex other) {
		Edge newEdge = new EdgeImpl(other);
		mEdges.add(newEdge);
	}

	@Override
	public Collection<Vertex> find(Vertex target) {
		ArrayList<Vertex> path = new ArrayList<Vertex>();
		boolean foundPath = findRecursive(this, target, path);
		
		// If a path was found, return it, otherwise return an empty collection
		if(foundPath) {
			return path;
		} else {
			return new ArrayList<Vertex>();
		}
	}

	@Override
	public int size() {
		Set<Vertex> subgraphVertices = new LinkedHashSet<Vertex>();
		sizeRecursive(this, subgraphVertices);
		
		return subgraphVertices.size();
	}

	@Override
	public Collection<Edge> getSuccessors() {
		return new LinkedList<Edge>(mEdges);
	}

	@Override
	public int Value() {
		return mValue;
	}

	@Override
	public int setValue(int val) {
		mValue = val;
		return 0;
	}
	
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof VertexImpl)) {
			return false;
		}
		
		return ((VertexImpl) other).mName.equals(mName) && 
				((VertexImpl) other).mValue == mValue;
	}
	
	private boolean findRecursive(Vertex current, Vertex end, ArrayList<Vertex> path) {
		// Check if the current vertex was visited before
		if(!(path.isEmpty()) && path.contains(current)) {
			return false;
		} else {
			path.add(current);
		}
		
		// If the path was already found, stop and return
		if(path.get(path.size() - 1).equals(end)) {
			return true;
		}
		
		for(Edge e : current.getSuccessors()) {
			if(!path.contains(e.getEndpoint())) {
				boolean found = findRecursive(e.getEndpoint(), end, path);
				if(found) {
					return true;
				} else {
					path.remove(e.getEndpoint());
				}
			}
		}
		
		return false;
	}
	
	private void sizeRecursive(Vertex root, Set<Vertex> vertices) {
		// If the algorithm was in this vertex before, stop
		if(vertices.contains(root))
			return;
		
		// Add the current vertex to the vertices set
		vertices.add(root);
		
		// For each child, run the algorithm
		for(Edge e : root.getSuccessors()) {
			sizeRecursive(e.getEndpoint(), vertices);
		}
	}
}
