package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Milestone;

public class MilestoneTest {

	@Test
	public void testMilestone() {
		Milestone fact1 = new Milestone();
		assertEquals(null, fact1.getName());
	}

	@Test
	public void testMilestoneString() {
		Milestone fact1 = new Milestone("Rozpoczecie");
		assertEquals("Rozpoczecie", fact1.getName());
	}

	@Test
	public void testMilestoneStringIntIntIntInt() {
		Milestone fact1 = new Milestone("Rozpoczecie", 0, 12, 5, 17);
		assertEquals("Rozpoczecie", fact1.getName());
		assertEquals(0, fact1.getEarliestStart());
		assertEquals(12, fact1.getEarliestFinish());
		assertEquals(5, fact1.getLatestStart());
		assertEquals(17, fact1.getLatestFinish());

	}

	//To musi dzialac tylko pokazalem jak sie robi junit testy 
/*
	@Test
	public void testSetNumberAfterSort() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEarliestStart() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEarliestFinish() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLatestStart() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLatestFinish() {
		fail("Not yet implemented");
	}
*/ 
}
