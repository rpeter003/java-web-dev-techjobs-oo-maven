package com.company.incomplete;

import com.company.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JobTests {
    static Job job1,job2,job3,job4,job5,job6,job7,job8,job9;
    @BeforeAll
    static void Job(){
       job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
       job3 = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));
       job4 = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"),
               new CoreCompetency("Tasting ability"));
       job5 = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"),
               new CoreCompetency("Persistence"));
       job6 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control")
               , new CoreCompetency("Persistence"));
       job7 = new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"),
               new CoreCompetency("Persistence"));
       job8 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(""),
               new CoreCompetency("Persistence"));
       job9 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality " +
               "control"), new CoreCompetency(""));
    }

    // you can rename the tests, or delete them and rewrite them from scratch, but I went ahead and provided you the names of tests I created -- I followed the writeup pretty honestly
    @Test
    public void testSettingJobId() {
        assertEquals(1, (job2.getId())-(job1.getId()));
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(job1.getId() != 0);
        assertTrue(job1.getName() != "");
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(job1 instanceof Job);

    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job3.equals(job4));
    }

    // I found the instructions around the three toString() tests a little confusing, so I created three tests following the three bullet points:
    // you can follow TDD if you want, or you can write the implementation first and then get the tests to pass, either is a fine approach
    @Test
    public void testToStringContainsBlankLines() {
        char firstChar = job5.toString().charAt(0);
        char lastChar = job5.toString().charAt(job5.toString().length()-1);
        assertTrue(firstChar == lastChar);
    }
    @Test
    public void testToStringHasLabelsForEachField() {
        String expected = String.format("\nID: %d\nName: %s\nEmployer: %s\nLocation: %s\nPositionType: " +
                        "%s\nCoreCompetency: %s\n",  job1.getId(), job1.getName(), job1.getEmployer().getValue(),
           job1.getLocation().getValue(), job1.getPositionType().getValue(), job1.getCoreCompetency().getValue());
        String actual = job1.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringDataNotAvailable() {
        String expected = String.format("\nID: %d\nName: Data not available\nEmployer: %s\nLocation: " +
                "%s\nPositionType: %s\nCoreCompetency: %s\n",  job5.getId(), job5.getEmployer().getValue(),job5.getLocation().getValue(), job5.getPositionType().getValue(), job5.getCoreCompetency().getValue());
        String actual = job5.toString();
        assertEquals(expected, actual);
    }
}


