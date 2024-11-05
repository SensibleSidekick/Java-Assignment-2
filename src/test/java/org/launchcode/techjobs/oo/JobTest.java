package org.launchcode.techjobs.oo;

import org.junit.Test;

import javax.swing.text.Position;

import static org.junit.Assert.*;

public class JobTest {


    @Test
    public void testSettingJobId(){

        Job testJob1 = new Job("Data entry", new Employer("MMIT"), new Location("Yardley"), new PositionType("Entry-Level"), new CoreCompetency("Click buttons"));

        Job testJob2 = new Job("Software Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Entry-level"), new CoreCompetency("JavaScript"));

        assertNotEquals(testJob1.getId(), testJob2.getId());

    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob1 instanceof Job);
        assertEquals("Product tester", testJob1.getName());

        assertTrue(testJob1.getEmployer() instanceof Employer);
        assertEquals("ACME", testJob1.getEmployer().toString());

        assertTrue(testJob1.getLocation() instanceof Location);
        assertEquals("Desert", testJob1.getLocation().toString());

        assertTrue(testJob1.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testJob1.getPositionType().toString());

        assertTrue(testJob1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testJob1.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Data entry", new Employer("MMIT"), new Location("Yardley"), new PositionType("Entry-Level"), new CoreCompetency("Click buttons"));

        Job testJob2 = new Job("Data entry", new Employer("MMIT"), new Location("Yardley"), new PositionType("Entry-Level"), new CoreCompetency("Click buttons"));

        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob1 = new Job("Data entry", new Employer("MMIT"), new Location("Yardley"), new PositionType("Entry-Level"), new CoreCompetency("Click buttons"));

        String testString = testJob1.toString();

        assertEquals(System.lineSeparator(), testString.substring(0, System.lineSeparator().length()));
        assertEquals(System.lineSeparator(), testString.substring(testString.length() - System.lineSeparator().length()));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob1 = new Job("Data entry", new Employer("MMIT"), new Location("Yardley"), new PositionType("Entry-Level"), new CoreCompetency("Click buttons"));

        String testString = testJob1.toString();
        String expectedString = System.lineSeparator() + "ID: " + testJob1.getId() + System.lineSeparator() + "Name: " + testJob1.getName() + System.lineSeparator() + "Employer: " + testJob1.getEmployer() + System.lineSeparator() + "Location: " + testJob1.getLocation() + System.lineSeparator() + "Position Type: " + testJob1.getPositionType() + System.lineSeparator() + "Core Competency: " + testJob1.getCoreCompetency() + System.lineSeparator();

        assertEquals(expectedString, testString);

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob1 = new Job("Data entry", new Employer("") , new Location("Yardley"), new PositionType("Entry-Level"), new CoreCompetency("Click buttons"));

        String emptyField = "Data not available";
        String expectedString = System.lineSeparator() + "ID: " + testJob1.getId() + System.lineSeparator() + "Name: " + testJob1.getName() + System.lineSeparator() + "Employer: " + emptyField + System.lineSeparator() + "Location: " + testJob1.getLocation() + System.lineSeparator() + "Position Type: " + testJob1.getPositionType() + System.lineSeparator() + "Core Competency: " + testJob1.getCoreCompetency() + System.lineSeparator();

        assertEquals(expectedString, testJob1.toString());

    }
}
