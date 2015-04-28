package OOP2.Solution;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import OOP2.Provided.PriorityQueue;
import OOP2.Provided.QueueEmptyException;
import OOP2.Provided.Vertex;

public class PriorityQueueImpl implements PriorityQueue, Iterable<Vertex> {
	
	private UIDGenerator uidGenerator;
	private List<PQElement> vertices; 
	
	private class UIDGenerator {
		private int uid = 0;
		public int getUID() {
			return uid++;
		}
	}
	
	private class PQElement implements Comparable<PQElement> {
		private Vertex vertex;
		private int uid;
		private int tag;
		
		public Vertex getVertex() {
			return vertex;
		}

		public int getUid() {
			return uid;
		}

		public int getTag() {
			return tag;
		}

		public PQElement(Vertex vertex, int tag) {
			this.vertex = vertex;
			this.tag = tag;
			this.uid = uidGenerator.getUID();
		}

		@Override
		public int compareTo(PQElement o) {
			if (this.tag != o.tag) {
				return this.tag - o.tag;
			}
			// TODO: sanity check!
			return this.uid - o.uid;
		}
	}
	
	/*
	 * must have a constructor that does not take arguments.
	 */
	public PriorityQueueImpl() {
		vertices = new ArrayList<PQElement>();
	}

	@Override
	public void enqueue(Vertex v, int tag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vertex dequeue() throws QueueEmptyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vertex peek() throws QueueEmptyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Vertex> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
