package OOP2.Tests;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import OOP2.Provided.Vertex;
import OOP2.Solution.DFSGraphWalk;
import OOP2.Solution.VertexImpl;

public class DFSTests {
	VertexImpl[] vertices = new VertexImpl[10];
	
	private void connect(int from, int to) {
		if (from > 10 || from < 0 || to > 10 || to < 0) {
			return;
		}
		if (vertices[from] == null || vertices[to] == null) {
			return;
		}
		vertices[from].connect(vertices[to]);
	}
	
	@Test
	public void DFSWalkTest() {
		for (int i = 0; i < 10; i++) {
			vertices[i] = new VertexImpl(Integer.toString(i), i);
		}
		
		connect(0, 1);
		connect(2, 0);
		connect(2, 1);
		//connect(3, 2);
		connect(3, 4);
		//connect(4, 2);
		connect(4, 5);
		connect(4, 8);
		connect(6, 4);
		connect(8, 6);
		connect(8, 7);
		connect(7, 9);
		connect(8, 9);
		
		DFSGraphWalk dfs = new DFSGraphWalk(vertices[3]);
		Iterator<Vertex> it = dfs.iterator();
		Assert.assertTrue(it.hasNext());
		Assert.assertEquals(3, it.next().Value());
		Assert.assertEquals(4, it.next().Value());
		Assert.assertEquals(8, it.next().Value());
		Assert.assertEquals(9, it.next().Value());
		Assert.assertEquals(7, it.next().Value());
		Assert.assertEquals(6, it.next().Value());
		Assert.assertEquals(5, it.next().Value());
		Assert.assertFalse(it.hasNext());
	}
}
