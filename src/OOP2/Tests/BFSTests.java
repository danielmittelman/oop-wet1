package OOP2.Tests;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

import OOP2.Provided.Vertex;
import OOP2.Solution.BFSGraphWalk;
import OOP2.Solution.VertexImpl;

public class BFSTests {
	
	@Test
	public void BFSGraphWalkTest() {
		// Build a test graph
		Vertex v1 = new VertexImpl("A", 1);
		Vertex v2 = new VertexImpl("B", 2);
		Vertex v3 = new VertexImpl("C", 3);
		Vertex v4 = new VertexImpl("D", 4);
		Vertex v5 = new VertexImpl("E", 5);
		Vertex v6 = new VertexImpl("F", 6);
		v1.connect(v2);
		v2.connect(v4);
		v4.connect(v1);
		v4.connect(v5);
		v4.connect(v6);
		v5.connect(v4);
		v6.connect(v3);
		
		BFSGraphWalk graphWalk = new BFSGraphWalk(v1);
		
		// First check that the iterator runs without problems
		int counter = 0;
		for(Vertex v : graphWalk) {
			Assert.assertNotNull(v);
			counter++;
		}
		Assert.assertEquals(6, counter);
		
		// Now check that the iteration is in the correct order
		Queue<Vertex> correctOrder = new LinkedList<Vertex>(Arrays.asList(v1, v2, v4, v5 ,v6, v3));
		for(Vertex v : graphWalk) {
			Assert.assertEquals(correctOrder.poll(), v);
		}
		Assert.assertEquals(0, correctOrder.size());
		
		// Test again, beginning at v5
		graphWalk = new BFSGraphWalk(v5);
		correctOrder = new LinkedList<Vertex>(Arrays.asList(v5, v4, v1, v2, v6, v3));
		for(Vertex v : graphWalk) {
			Assert.assertEquals(correctOrder.poll(), v);
		}
		Assert.assertEquals(0, correctOrder.size());
		
		// Test again, beginning at v3
		graphWalk = new BFSGraphWalk(v3);
		correctOrder = new LinkedList<Vertex>(Arrays.asList(v3));
		for(Vertex v : graphWalk) {
			Assert.assertEquals(correctOrder.poll(), v);
		}
		Assert.assertEquals(0, correctOrder.size());
		
	}
	
}
