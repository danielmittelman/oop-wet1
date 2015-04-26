package OOP2.Provided;

import java.util.Collection;


public interface Vertex {

	/**
	 * @param other a vertex
	 * Creates a new edge (this -> other) in the graph
	 */
	public void connect(Vertex other);

	/**
	 * @param target a vertex
	 * returns a collection that includes the path to the target
	 */
	public Collection<Vertex> find(Vertex target);
	
	
	/**
	 * returns the number of vertices in the subgraph of this vertex
	 */
	public int size();
	
	/**
	 * @return all vertices v so that there is an edge (this -> v)
	 */
	public Collection<Edge> getSuccessors();
	
	
	/**
	 * returns the "number" of the vertex.
	 */
	public int Value();
	
	/**
	 * @param val a new integer value
	 * sets the value of the vertex to the new value.
	 */
	public int setValue(int val);

}
