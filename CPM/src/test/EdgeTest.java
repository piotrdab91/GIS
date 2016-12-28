package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Edge;
import Model.Milestone;
import Model.Node;

public class EdgeTest {

	@Test
	public void testEdge() {
		Node<Milestone> start = new Node<Milestone>(1, new Milestone("Rozpoczecie"));
		Node<Milestone> end = new Node<Milestone>(2, new Milestone("Koniec"));
		Edge<Milestone> task1 =  new Edge<Milestone>(start, end, 5);
		assertSame(start, task1.getStart());
	}
	
	public void testEdge_NumOfConnections() {
		Node<Milestone> start = new Node<Milestone>(1, new Milestone("Rozpoczecie"));
		Node<Milestone> end = new Node<Milestone>(2, new Milestone("Koniec"));
		assertEquals(1,start.getConnections().size());
	}
	
	@Test
	public void testEdgeChangeInEndNode(){

		Node<Milestone> start = new Node<Milestone>(1, new Milestone("Rozpoczecie"));
		Node<Milestone> end = new Node<Milestone>(2, new Milestone("Koniec"));
		end.getNodeProperties().setLatestStart(6);
		Edge<Milestone> task1 =  new Edge<Milestone>(start, end, 5);
		
		end.getNodeProperties().setEarliestFinish(5);
		end.getNodeProperties().setLatestFinish(11);
		
		assertEquals(0, end.getNodeProperties().getEarliestStart());
		assertEquals(5, end.getNodeProperties().getEarliestFinish());
		assertEquals(6, end.getNodeProperties().getLatestStart());
		assertEquals(11, end.getNodeProperties().getLatestFinish());
	}

}
