package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    private static Job test_job1 = new Job();
    private static Job test_job2 = new Job();
    private static Job test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    private static Job test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    private static Job test_job5 = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Taste"));

    // Constructor tests

    @Test
    public void testSettingJobId() {
        int id1 = this.test_job1.getId();
        int id2 = this.test_job2.getId();
        int idDifference = id2 - id1;
        assertNotEquals(id1, id2);
        assertEquals(1, idDifference, .001);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(test_job3 instanceof Job);
        assertTrue(test_job3.getEmployer() instanceof Employer);
        assertTrue(test_job3.getLocation() instanceof Location);
        assertTrue(test_job3.getPositionType() instanceof PositionType);
        assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", test_job3.getName());
        assertEquals("ACME", test_job3.getEmployer().getValue());
        assertEquals("Desert", test_job3.getLocation().getValue());
        assertEquals("Quality control", test_job3.getPositionType().getValue());
        assertEquals("Persistence", test_job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(test_job3.equals(test_job4));
    }

    // toString() tests

    @Test
    public void toStringIncludesBlankLineBeforeAndAfterJobEntry() {
        String test_string = test_job4.toString();
        assertTrue(test_string.startsWith("\n"));
        assertTrue(test_string.endsWith("\n"));
    }

    @Test
    public void toStringIncludesLabelAndValueForEachFieldOnNewLine() {
        String test_string = "\nID: 4\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality control\nCore Competency: Persistence\n";
        String test_string2 = test_job4.toString();
        assertEquals(test_string, test_string2);
    }

    @Test
    public void toStringIncludesFieldIfDataNotAvailable() {
        String test_string = "\nID: 5\nName: Ice cream taster\nEmployer: (Data not available)\nLocation: Home\nPosition Type: UX\nCore Competency: Taste\n";
        String test_string2 = test_job5.toString();
        assertEquals(test_string, test_string2);
    }

}
