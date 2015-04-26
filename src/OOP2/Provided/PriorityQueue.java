package OOP2.Provided;

import OOP2.Provided.Vertex;

public interface PriorityQueue {

	/**
	 * @param v the Vertex to enqueue
	 * @param tag the tag of the vertex
	 */
	public void enqueue(Vertex v, int tag);

	/**
	 * @return the Vertex at the head of the queue
	 * @throws QueueEmptyException
	 * Removes & returns the Vertex at the head of the queue
	 */
	public Vertex dequeue() throws QueueEmptyException;
	
	/**
	 * @return the Vertex at the head of the queue
	 * @throws QueueEmptyException
	 * Returns the Vertex at the head of the queue without removing it
	 */
	public Vertex peek() throws QueueEmptyException;

	/**
	 * @return true if the queue is empty
	 */
	public boolean isEmpty();

}
