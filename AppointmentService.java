/**
 * AppointmentService.java
 *
 * Created by: Jacob Barker
 * Date: April 6, 2025
 * Course: CS 320: Software Testing, Automation, and Quality Assurance (SNHU)
 *
 * This service manages a collection of Appointment objects. It provides methods
 * to add and delete appointments in an in-memory data structure.
 * Requirements:
 * - Must be able to add appointments with a unique appointment ID
 * - Must be able to delete appointments by appointment ID
 */

package appointment;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {

    // In-memory storage keyed by appointmentId
    private Map<String, Appointment> appointments = new HashMap<>();

    /**
     * Adds a new Appointment to the service, ensuring the appointment ID is unique.
     *
     * @param appointment The Appointment object to be added
     * @throws IllegalArgumentException if the appointment ID already exists
     */
    public void addAppointment(Appointment appointment) {
        if (appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID already exists.");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    /**
     * Deletes an existing Appointment by its ID.
     *
     * @param appointmentId The ID of the Appointment to remove
     * @throws IllegalArgumentException if no Appointment exists with that ID
     */
    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment not found for deletion.");
        }
        appointments.remove(appointmentId);
    }

    /**
     * Optional helper method: Retrieves an Appointment by ID (useful for testing).
     *
     * @param appointmentId ID of the desired Appointment
     * @return The Appointment object if found, or null if not
     */
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
