package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Action;
import Model.Milestone;

public class ActionTest {

	Milestone fact1 = new Milestone (1);
	Milestone fact2 = new Milestone (2);

	@Test
	public void testActionNodeNodeDoubleString() {
		Action task = new Action(fact1, fact2, 20, "Betonowanie");
		assertSame(fact1, task.getStart());
		assertSame(fact2, task.getEnd());
		assertEquals(20, task.getWeight(),0.0001);
		assertEquals("Betonowanie", task.getName());
	}

	@Test
	public void testSetName() {
		Action task = new Action(fact1, fact2, 20, "Betonowanie");
		assertEquals("Betonowanie", task.getName());
		task.setName("Wykopy");
		assertEquals("Wykopy", task.getName());
		
	}

}
