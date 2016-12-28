package test;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Model.Graph;
import Model.Milestone;
import Model.Node;
import graphAlgorithms.TopologicalSorter;

public class TopologicalSorterTest {

	@Test
	public void testSortKhansAlgortithm_Tree() {
		Graph<Milestone> graph = new Graph<Milestone>(6, Milestone.class);
		List<Node<Milestone>> list = new ArrayList<Node<Milestone>>();
		graph.addEdge(0, 1, 5);
		graph.addEdge(1, 2, 5);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 4, 5);
		graph.addEdge(5, 1, 6);

		TopologicalSorter sorter = new TopologicalSorter();

		try {
			list = sorter.sortKhansAlgortithm(graph);
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}

		assertEquals(0, list.get(0).getNumber());
		assertEquals(5, list.get(1).getNumber());
		assertEquals(1, list.get(2).getNumber());
		assertEquals(2, list.get(3).getNumber());
		assertEquals(3, list.get(4).getNumber());
		assertEquals(4, list.get(5).getNumber());
		
	}
@Test
	public void testSortKhansAlgortithm_Graph() {
		Graph<Milestone> graph = new Graph<Milestone>(9, Milestone.class);
		List<Node<Milestone>> list = new ArrayList<Node<Milestone>>();
		graph.addEdge(0, 8, 5);
		graph.addEdge(0, 4, 5);
		graph.addEdge(8, 1, 5);
		graph.addEdge(8, 3, 5);
		graph.addEdge(4, 3, 6);
		graph.addEdge(4, 7, 6);
		graph.addEdge(4, 2, 6);
		graph.addEdge(1, 6, 6);
		graph.addEdge(3, 5, 6);
		graph.addEdge(7, 5, 6);
		graph.addEdge(5, 6, 6);
		graph.addEdge(6, 2, 6);
		

		TopologicalSorter sorter = new TopologicalSorter();

		try {
			list = sorter.sortKhansAlgortithm(graph);
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}

		assertEquals(0, list.get(0).getNumber());
		assertEquals(8, list.get(1).getNumber());
		assertEquals(4, list.get(2).getNumber());
		assertEquals(1, list.get(3).getNumber());
		assertEquals(3, list.get(4).getNumber());
		assertEquals(7, list.get(5).getNumber());
		assertEquals(5, list.get(6).getNumber());
		assertEquals(6, list.get(7).getNumber());
		assertEquals(2, list.get(8).getNumber());
	}

	/*
	 * @Test public void testCountIndegree() { Graph<Milestone> graph = new
	 * Graph<Milestone>(6, Milestone.class); graph.addEdge(0, 1, 5);
	 * graph.addEdge(1, 2, 5); graph.addEdge(2, 3, 5); graph.addEdge(3, 4, 5);
	 * graph.addEdge(5, 1, 6); TopologicalSorter sorter = new
	 * TopologicalSorter(graph);
	 * 
	 * sorter.countIndegree();
	 * 
	 * ArrayList<Node<Milestone>> list = graph.getNodesList(); assertEquals(0,
	 * list.get(0).getNodeProperties().getInDegree()); assertEquals(0,
	 * list.get(5).getNodeProperties().getInDegree()); assertEquals(2,
	 * list.get(1).getNodeProperties().getInDegree());
	 * 
	 * for (int i = 2; i < 5; i++) { assertEquals(1,
	 * list.get(i).getNodeProperties().getInDegree()); }
	 * 
	 * }
	 * 
	 * @Test public void testAddRoots() throws ClassNotFoundException,
	 * NoSuchMethodException, SecurityException { Graph<Milestone> graph = new
	 * Graph<Milestone>(6, Milestone.class); graph.addEdge(0, 1, 5);
	 * graph.addEdge(1, 2, 5); graph.addEdge(2, 3, 5); graph.addEdge(3, 4, 5);
	 * graph.addEdge(5, 1, 6); TopologicalSorter sorter = new
	 * TopologicalSorter(); sorter.countIndegree(); List<Node<Milestone>> list =
	 * sorter.addRoots();
	 * assertTrue(list.contains(graph.getNodesList().get(0)));
	 * assertTrue(list.contains(graph.getNodesList().get(5)));
	 * 
	 * 
	 * }
	 */

@Test (expected = InvalidAlgorithmParameterException.class )
public void testSortKhansAlgortithm_Cyclc() throws InvalidAlgorithmParameterException {
	Graph<Milestone> graph = new Graph<Milestone>(5, Milestone.class);
	List<Node<Milestone>> list = new ArrayList<Node<Milestone>>();
	graph.addEdge(0, 1, 5);
	graph.addEdge(1, 2, 5);
	graph.addEdge(2, 3, 5);
	graph.addEdge(3, 4, 5);
	graph.addEdge(4, 1, 6);
	
	TopologicalSorter sorter = new TopologicalSorter();

		list = sorter.sortKhansAlgortithm(graph);

	}
}


