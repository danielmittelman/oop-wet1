package OOP2.Solution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import OOP2.Provided.Edge;
import OOP2.Provided.QueueEmptyException;
import OOP2.Provided.Vertex;

public class BFSGraphWalk implements Iterable<Vertex> {
	
	private Vertex mOrigin;

	public BFSGraphWalk(Vertex origin) {
		mOrigin = origin;
	}

	@Override
	public Iterator<Vertex> iterator() {
		return new Iterator<Vertex>() {
			PriorityQueueImpl openQueue = new PriorityQueueImpl();
			List<Vertex> closedList = new ArrayList<Vertex>();
			Vertex currentVertex;
			
			@Override
			public boolean hasNext() {
				// If this is the first call to the iterator, there is a next
				if(closedList.isEmpty() && openQueue.isEmpty() && currentVertex == null) {
					return true;
				}
				
				// If both the list and queue are empty, and this is not the first iteration,
				// the algorithm has ended
				if(!(closedList.isEmpty()) && openQueue.isEmpty()) {
					return false;
				}
				
				return true;
			}

			@Override
			public Vertex next() {
				if(currentVertex == null) {
					currentVertex = mOrigin;
					openQueue.enqueue(currentVertex, currentVertex.Value());
				}
				
				// Dequeue openQueue and set as currentVertex
				try {
					currentVertex = openQueue.dequeue();
				} catch (QueueEmptyException e1) {
					// This would never happen and does not need to be handled
				}
				
				// Add all the adjacent vertices of the current vertex to the openQueue
				for(Edge e : currentVertex.getSuccessors()) {
					Vertex v = e.getEndpoint();
					if(!(openQueue.contains(v) || closedList.contains(v))) {
						openQueue.enqueue(v, v.Value());
					}
				}
				
				// Set the current vertex as closed and return it
				closedList.add(currentVertex);
				return currentVertex;
			}
		};
	}
}
