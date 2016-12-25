package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Model.Edge;
import Model.Graph;
import Model.Milestone;
import Model.Node;

public class GraphTest {

	@Test
	public void testGraphInt() {
		Graph<String> graph = new Graph<String>(5);
		assertEquals(2, graph.getNodesList().get(2).getNumber());
	}
	
	@Test
	public void testGraphIntCheckPropertiesField() {
		Graph<Milestone> graph = new Graph<Milestone>(5);
		assertEquals(null, graph.getNodesList().get(2).getNodeProperties());
	}
	/*Ten test nizej bedzie pokazuje jak  podpiac pod wezly obiekty klasy milstone. 
	 * Tworzac graf powstaja wezly z niezainicjalizowanym polem NodeProperties
	 * Bo nie wiem jak zrobic zainicjalizowac to odrazu, prawdopodobnie potrzebna jest jakas 
	 * refleksja*/
	@Test 
	public void testSettingNodesPropertiesField(){
		
		Graph<Milestone> graph = new Graph<Milestone>(5);
		ArrayList<Node<Milestone>> nodesList = graph.getNodesList();
		Integer i = 0;
		for (Node<Milestone> node : nodesList) {
			Milestone milestone  = new Milestone(i.toString()); 
			node.setNodeProperties(milestone);
			i++;
		}
		assertEquals("3", graph.getNodesList().get(3).getNodeProperties().getName());
	}

	@Test
	public void testAddEdgeEdgeOfT() {
		Graph<Milestone> graph = new Graph<Milestone>(5);
		Edge<Milestone> edge_1 = new Edge<>(graph.getNodesList().get(0), graph.getNodesList().get(1), 5);
		graph.addEdge(edge_1);
		
		for(int i = 0; i<2;i++)
			assertSame(edge_1, graph.getNodesList().get(i).getConnections().get(0));
		for(int i = 2; i<5; i++)
			assertEquals(0,  graph.getNodesList().get(i).getConnections().size());		
	}

	@Test
	public void testAddEdgeIntIntDouble_FirstNodeConnectionCheck() {
		Graph<Milestone> graph = new Graph <Milestone> (10);
		graph.addEdge(0, 1, 5);
		assertEquals(0, graph.getNodesList().get(0).getConnections().get(0).getStart().getNumber());
		assertEquals(1, graph.getNodesList().get(0).getConnections().get(0).getEnd().getNumber());
	}
	
	@Test
	public void testAddEdgeIntIntDouble_SecondNodeConnectionCheck() {
		Graph<Milestone> graph = new Graph <Milestone> (10);
		graph.addEdge(0, 1, 5);
		assertEquals(0, graph.getNodesList().get(1).getConnections().get(0).getStart().getNumber());
		assertEquals(1, graph.getNodesList().get(1).getConnections().get(0).getEnd().getNumber());
	}

	@Test
	public void testdeleteEdgeIntInt_One_Edge(){
		Graph<Milestone> graph = new Graph <Milestone> (10);
		graph.addEdge(0, 1, 5);
		graph.deleteEdge(0,1);
		
		for(int i = 0; i<10;i++ )
			assertEquals(0, graph.getNodesList().get(0).getConnections().size());
	}
	@Test
	public void testdeleteEdgeIntInt_More_Edges_(){
		Graph<Milestone> graph = new Graph <Milestone> (5);
		graph.addEdge(0, 1, 5);
		graph.addEdge(1, 2, 5);
		graph.addEdge(2, 3, 5);
		graph.addEdge(3, 4, 5);
		graph.deleteEdge(3,4);
		
		assertEquals(1, graph.getNodesList().get(0).getConnections().size());

		for(int i = 1; i<3;i++ )
			assertEquals(2, graph.getNodesList().get(i).getConnections().size());
		
		assertEquals(1, graph.getNodesList().get(3).getConnections().size());
		assertEquals(0, graph.getNodesList().get(4).getConnections().size());
		}
	

}
