package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;  // ← CHANGED: Use JUnit4, NOT Suite

@RunWith(JUnit4.class)  // ← SIMPLIFIED: No Suite needed
public class AgeTest {

    @Test
    public void testVotingAge() {
        Agevalidator agecheck = new Agevalidator();
        // Age 20 = CAN VOTE (assuming standard voting age 18)
        assertEquals("Right to Vote", agecheck.checkAge(20));
    }
    
    @Test
    public void testUnderAge() {
        Agevalidator agecheck = new Agevalidator();
        assertEquals("No right to Vote", agecheck.checkAge(15));
    }
}