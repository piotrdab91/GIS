package test;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Milestone;

public class MilestoneTest {


	
	@Test
	public void testMilestoneInt() {
		Milestone fact= new Milestone(1);
		assertEquals(fact.getNumber(), 1);
	}

	@Test
	public void testMilestoneIntString() {
		Milestone fact= new Milestone(1,"Rozpoczecie");
		assertEquals(fact.getNumber(), 1);
		assertEquals(fact.getName(), "Rozpoczecie");	
	}

	@Test
	public void testSetEarliestStart() {
		Milestone startPoint = new Milestone(1, "Start");  
		startPoint.setEarliestStart(5);
		assertEquals(5, startPoint.getEarliestStart());
	}



	@Test
	public void testSetEarliestFinish() {
		Milestone startPoint = new Milestone(1, "Start");  
		startPoint.setEarliestFinish(52);
		assertEquals(52, startPoint.getEarliestFinish());
	}

	@Test
	public void testSetLatestStart() {
		Milestone startPoint = new Milestone(1, "Start");  
		startPoint.setLatestStart(13);
		assertEquals(13, startPoint.getLatestStart());
	}


	@Test
	public void testSetLatestFinish() {
		Milestone startPoint = new Milestone(1, "Start");  
		startPoint.setLatestFinish(22);
		assertEquals(22, startPoint.getLatestFinish());
	}


	@Test
	public void testSetNumberAfterSort() {
		Milestone startPoint = new Milestone(1, "Start"); 
		startPoint.setNumberAfterSort(5);
		assertEquals(5, startPoint.getNumberAfterSort());
	}


	@Test
	public void testSetName() {
		Milestone startPoint = new Milestone(1, "Start"); 
		assertEquals("Start", startPoint.getName());
		startPoint.setName("End");
		assertEquals("End", startPoint.getName());
	}


	@Test
	public void testSetNumber() {
		Milestone fact= new Milestone(1);
		fact.setNumber(2);
		assertEquals(2,fact.getNumber());
	}
	

}
