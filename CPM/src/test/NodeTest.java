package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Milestone;
import Model.Node;

public class NodeTest {

	@Test
	public void testNode_NumberCheck() {
		Node<Milestone> node = new Node<Milestone>(1, new Milestone("Rozpoczecie"));
		assertEquals(1, node.getNumber());
		assertEquals("Rozpoczecie", node.getNodeProperties().getName());
	}

	@Test
	public void testSetNumber() {
		Node<Milestone> node = new Node<Milestone>(1, new Milestone("Rozpoczecie"));
		node.setNumber(10);
		assertEquals(10, node.getNumber());
	}

	@Test
	public void testGetNodeProperties() {
		Milestone milestone = new Milestone("Koniec", 25, 32, 29, 36);
		Node<Milestone> node = new Node<Milestone>(1, milestone);
		assertSame(milestone, node.getNodeProperties());
	}
	@Test
	public void testChangeNodeProperties() {
		Node<Milestone> node = new Node<Milestone>(1, new Milestone("Rozpoczecie"));
		node.getNodeProperties().setLatestFinish(19);
		assertEquals(19, node.getNodeProperties().getLatestFinish());
	}


	/*
	 * 
	 * @Test public void testGetConnections() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testSetConnections() { fail("Not yet implemented"); }
	 */
}
