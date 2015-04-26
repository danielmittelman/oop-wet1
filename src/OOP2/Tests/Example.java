package OOP2.Tests;

import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import OOP2.Provided.Edge;
import OOP2.Provided.PriorityQueue;
import OOP2.Provided.QueueEmptyException;
import OOP2.Provided.Vertex;
import OOP2.Solution.BFSGraphWalk;
import OOP2.Solution.PriorityQueueImpl;
import OOP2.Solution.VertexImpl;

public class Example {
	@Test
	public void ExampleTest() {
	
		Vertex v = new VertexImpl("v",0);
		Vertex u = new VertexImpl("u",1);
		v.connect(u);
		Collection<Edge> edges = v.getSuccessors();
		Assert.assertEquals(1, edges.size());
		
		BFSGraphWalk bfs = new BFSGraphWalk(v);
		for (Vertex w : bfs) {
			Assert.assertNotNull(w);
		}
	}
}
