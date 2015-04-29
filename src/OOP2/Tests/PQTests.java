package OOP2.Tests;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import OOP2.Provided.PriorityQueue;
import OOP2.Provided.QueueEmptyException;
import OOP2.Provided.Vertex;
import OOP2.Solution.PriorityQueueImpl;
import OOP2.Solution.VertexImpl;

public class PQTests {
	@Rule
	public ExpectedException exception = ExpectedException.none();
	  
	@Test
	public void IllegalArgumentExceptionTest() {
		PriorityQueue pq = new PriorityQueueImpl();
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Null argument received");
		pq.enqueue(null, 0);
	}
	
	@Test
	public void QueueEmptyExceptionTest() throws QueueEmptyException {
		PriorityQueue pq = new PriorityQueueImpl();
		
		exception.expect(QueueEmptyException.class);
		pq.dequeue();
		pq.peek();
	}
	
	@Test
	public void PQTest() throws QueueEmptyException {
		PriorityQueueImpl pq = new PriorityQueueImpl();
		
		pq.enqueue(new VertexImpl("Element 6", 6), 5);
		pq.enqueue(new VertexImpl("Element 3", 3), 3);
		pq.enqueue(new VertexImpl("Element 4", 4), 3);
		pq.enqueue(new VertexImpl("Element 8", 8), 6);
		pq.enqueue(new VertexImpl("Element 5", 5), 4);
		pq.enqueue(new VertexImpl("Element 1", 1), -42);
		pq.enqueue(new VertexImpl("Element 2", 2), 1);
		pq.enqueue(new VertexImpl("Element 7", 7), 5);
		
		// In this loop we check if the elements were put in, in the right order.
		for (int i = 1; i <= 8; i++) {
			Assert.assertFalse(pq.isEmpty());
			Assert.assertEquals(i, pq.peek().Value());
			Assert.assertTrue(pq.dequeue().equals(new VertexImpl("Element " + Integer.toString(i), i)));
			
		}
		Assert.assertTrue(pq.isEmpty());
		
		pq.enqueue(new VertexImpl("Element 6", 6), 5);
		pq.enqueue(new VertexImpl("Element 3", 3), 3);
		pq.enqueue(new VertexImpl("Element 4", 4), 3);
		pq.enqueue(new VertexImpl("Element 8", 8), 6);
		pq.enqueue(new VertexImpl("Element 5", 5), 4);
		pq.enqueue(new VertexImpl("Element 1", 1), -42);
		pq.enqueue(new VertexImpl("Element 2", 2), 1);
		pq.enqueue(new VertexImpl("Element 7", 7), 5);
		
		// Testing the iterator
		Iterator<Vertex> it = pq.iterator();
		
		for (int i = 1; i <= 8; i++) {
			Assert.assertTrue(it.hasNext());
			Assert.assertTrue(it.next().equals(new VertexImpl("Element " + Integer.toString(i), i)));
		}
		Assert.assertFalse(it.hasNext());
	}
}
