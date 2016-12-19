package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Edge;
import Model.Node;

public class EdgeTest {
	Node begin = new Node(1);
	Node end = new Node(2);
	Node middle = new Node(3);

	@Test
	public void testEdgeNodeNode() {
		Edge e1 = new Edge(begin, end);

		assertEquals(end, e1.getEnd());
	}

	@Test
	public void testEdgeNodeNodeDouble() {
		Edge e1 = new Edge(begin, end, 20);
		assertEquals(begin, e1.getStart());
		assertEquals(end, e1.getEnd());
		assertEquals(20, e1.getWeight(), 0.000001);

	}

	@Test
	public void testSetStart() {
		Edge e1 = new Edge(begin, end, 20);
		e1.setStart(middle);
		assertEquals(middle, e1.getStart());
	}

	@Test
	public void testSetEnd() {
		Edge e1 = new Edge(begin, end, 20);
		e1.setEnd(middle);
		assertEquals(middle, e1.getEnd());
	}
}
