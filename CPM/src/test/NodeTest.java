package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Node;

public class NodeTest {

	@Test
	public void constructorTest() {
		Node v = new Node (1);
		assertEquals(1, v.getNumber());
	}
	@Test 
	public void setNumberTest(){
		Node v = new Node (1);
		v.setNumber(2);
		assertEquals(2, v.getNumber());
	}

}
