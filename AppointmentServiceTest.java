/**
 * AppointmentServiceTest.java
 *
 * Created by: Jacob Barker
 * Date: April 6, 2025
 * Course: CS 320: Software Testing, Automation, and Quality Assurance (SNHU)
 *
 * Unit tests for the AppointmentService class, verifying we can
 * add and delete appointments with correct constraints.
 */

package appointmentTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import appointment.Appointment;
import appointment.AppointmentService;

import java.util.Calendar;
import java.util.Date;

class AppointmentServiceTest {

    @Test
    void testAddAppointment() {
        AppointmentService service = new AppointmentService();

        // Create a future date
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        Date futureDate = cal.getTime();

        Appointment appt = new Appointment("12345", futureDate, "Dentist Visit");
        service.addAppointment(appt);

        assertNotNull(service.getAppointment("12345"));
        assertEquals("Dentist Visit", service.getAppointment("12345").getDescription());
    }

    @Test
    void testAddDuplicateId() {
        AppointmentService service = new AppointmentService();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 3);
        Date futureDate = cal.getTime();

        Appointment appt1 = new Appointment("11111", futureDate, "First Appt");
        Appointment appt2 = new Appointment("11111", futureDate, "Second Appt");

        service.addAppointment(appt1);
        // Expect exception for duplicate ID
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(appt2);
        });
    }

    @Test
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 2);
        Date futureDate = cal.getTime();

        Appointment appt = new Appointment("22222", futureDate, "Vaccination");
        service.addAppointment(appt);

        service.deleteAppointment("22222");
        assertNull(service.getAppointment("22222"));
    }

    @Test
    void testDeleteAppointmentNotFound() {
        AppointmentService service = new AppointmentService();
        // Attempt to remove non-existent ID
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("DoesNotExist");
        });
    }
}
