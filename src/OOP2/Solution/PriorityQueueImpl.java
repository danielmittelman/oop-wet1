package OOP2.Solution;


import java.util.ArrayList;
import java.util.Collections;
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
			return this.uid - o.uid;
		}
	}
	
	/*
	 * must have a constructor that does not take arguments.
	 */
	public PriorityQueueImpl() {
		vertices = new ArrayList<PQElement>();
		uidGenerator = new UIDGenerator();
	}

	@Override
	public void enqueue(Vertex v, int tag) {
		if (v == null) {
			throw new IllegalArgumentException("Null argument received");
		}
		vertices.add(new PQElement(v, tag));
	}

	@Override
	public Vertex dequeue() throws QueueEmptyException {
		if (vertices.isEmpty()) {
			throw new QueueEmptyException();
		}
		Collections.sort(vertices);
		return vertices.remove(0).getVertex();
	}

	@Override
	public Vertex peek() throws QueueEmptyException {
		if (vertices.isEmpty()) {
			throw new QueueEmptyException();
		}
		Collections.sort(vertices);
		return vertices.get(0).getVertex();
	}

	@Override
	public boolean isEmpty() {
		return vertices.isEmpty();
	}

	@Override
	public Iterator<Vertex> iterator() {
		return new Iterator<Vertex>() {
			private Iterator<PQElement> iter = vertices.iterator();
			
			@Override
			public boolean hasNext() {
				return iter.hasNext();
			}

			@Override
			public Vertex next() {
				Collections.sort(vertices);
				return iter.next().getVertex();
			}

			@Override
			public void remove() {
				iter.remove();
			}
		};
	}
	
}
