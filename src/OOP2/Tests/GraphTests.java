package OOP2.Tests;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import OOP2.Provided.Edge;
import OOP2.Provided.Vertex;
import OOP2.Solution.EdgeImpl;
import OOP2.Solution.VertexImpl;

public class GraphTests {

	@Test
	public void GraphTest() {
		Vertex v1 = new VertexImpl("A", 1);
		Vertex v2 = new VertexImpl("B", 2);
		Vertex v3 = new VertexImpl("C", 3);
		Vertex v4 = new VertexImpl("D", 4);
		Vertex v5 = new VertexImpl("E", 5);
		Vertex v6 = new VertexImpl("F", 6);
		
		// Test equality and inequality
		Vertex v2_2 = new VertexImpl("B", 2);
		Assert.assertNotEquals(v3, v2);
		Assert.assertNotEquals(v1, v4);
		Assert.assertNotEquals(v4, v1);
		Assert.assertNotEquals(v2, v4);
		Assert.assertEquals(v1, v1);
		Assert.assertEquals(v2, v2_2);
		Assert.assertEquals(v2_2, v2);
		
		/* Build the graph.
		 * Note that all vertices have a single outgoing edge,
		 * with the exception of vertex D which has 3 outgoing edges,
		 * and vertex C which has none */
		v1.connect(v2);
		v2.connect(v4);
		v4.connect(v1);
		v4.connect(v5);
		v4.connect(v6);
		v5.connect(v4);
		v6.connect(v3);
		
		// Test Value() and setValue()
		Assert.assertEquals(2, v2_2.Value());
		v2_2.setValue(5);
		Assert.assertEquals(5, v2_2.Value());
		
		// Test the size() method of Vertex
		// If this thrown a StackOverflowError, you have entered an infinite loop
		Assert.assertEquals(6, v1.size());
		Assert.assertEquals(6, v2.size());
		Assert.assertEquals(1, v3.size());
		Assert.assertEquals(6, v4.size());
		Assert.assertEquals(6, v5.size());
		Assert.assertEquals(2, v6.size());
		
		/* Test the getSuccessors() method and that the order in which the edges are returned
		 * is similar to the one they were entered */
		Edge e1 = new EdgeImpl(v1);
		Edge e2 = new EdgeImpl(v5);
		Edge e3 = new EdgeImpl(v6);
		Collection<Edge> v4Edges = v4.getSuccessors();
		
		for(int i = 0 ; i < 20 ; i++) {
			Iterator<Edge> it = v4Edges.iterator();
			Assert.assertEquals(e1, it.next());
			Assert.assertEquals(e2, it.next());
			Assert.assertEquals(e3, it.next());
		}
		
		// Test the find() method
		// If this thrown a StackOverflowError, you have entered an infinite loop
		Collection<Vertex> path = v1.find(v4);
		Assert.assertEquals(3, path.size());
		
		path = v1.find(v6);
		Assert.assertEquals(4, path.size());
		
		path = v4.find(v4);
		Assert.assertEquals(1, path.size());
		
		path = v1.find(v3);
		Assert.assertEquals(5, path.size());
		
		// Test the find() method using an impossible path
		Vertex v7 = new VertexImpl("G", 7);
		path = v1.find(v7);
		// Assert what? what is the return value?
		
	}
}
