/**
 * AppointmentTest.java
 *
 * Created by: Jacob Barker
 * Date: April 6, 2025
 * Course: CS 320: Software Testing, Automation, and Quality Assurance (SNHU)
 *
 * Unit tests for the Appointment class, verifying that constraints
 * (e.g., ID <= 10 chars, date not null or in the past, description <= 50 chars)
 * are properly enforced.
 */

package appointmentTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import appointment.Appointment;

import java.util.Calendar;
import java.util.Date;

class AppointmentTest {

    @Test
    void testAppointmentValid() {
        // Construct a future date for testing
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 5); // 5 days in the future
        Date futureDate = cal.getTime();

        Appointment appt = new Appointment("12345", futureDate, "Regular Checkup");
        assertEquals("12345", appt.getAppointmentId());
        assertEquals(futureDate, appt.getAppointmentDate());
        assertEquals("Regular Checkup", appt.getDescription());
    }

    @Test
    void testAppointmentIdTooLong() {
        // ID with 11 characters should fail
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 5);
        Date futureDate = cal.getTime();

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Description");
        });
    }

    @Test
    void testAppointmentIdNull() {
        // Null ID should fail
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 5);
        Date futureDate = cal.getTime();

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Description");
        });
    }

    @Test
    void testAppointmentDateNull() {
        // Null date should fail
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", null, "Description");
        });
    }

    @Test
    void testAppointmentDateInPast() {
        // A date set in the past should fail
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1); // 1 day in the past
        Date pastDate = cal.getTime();

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345", pastDate, "Past appointment");
        });
    }

    @Test
    void testDescriptionTooLong() {
        // Description over 50 chars should fail
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 5);
        Date futureDate = cal.getTime();

        String longDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, too long!";
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("ABCDE", futureDate, longDesc);
        });
    }

    @Test
    void testDescriptionNull() {
        // Null description should fail
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 5);
        Date futureDate = cal.getTime();

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("ABCDE", futureDate, null);
        });
    }
}
