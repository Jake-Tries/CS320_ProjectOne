/**
 * Appointment.java
 *
 * Created by: Jacob Barker
 * Date: April 6, 2025
 * Course: CS 320: Software Testing, Automation, and Quality Assurance (SNHU)
 *
 * This class represents a single Appointment with:
 * - A unique appointment ID (not null, <= 10 chars, not updatable)
 * - An appointment Date (not null, cannot be in the past)
 * - A description (not null, <= 50 chars)
 */

package appointment;

import java.util.Date;

public class Appointment {

    //--------------------------------------------------------------------------
    // Fields
    //--------------------------------------------------------------------------
    private final String appointmentId;     // Must be non-null, <= 10 chars, not updatable
    private final Date appointmentDate;     // Must be non-null, not in the past
    private final String description;       // Must be non-null, <= 50 chars

    //--------------------------------------------------------------------------
    // Constructor
    //--------------------------------------------------------------------------
    /**
     * Constructs an Appointment object, enforcing:
     * - appointmentId: not null, <= 10 chars
     * - appointmentDate: not null, cannot be in the past
     * - description: not null, <= 50 chars
     *
     * @param appointmentId    Unique ID for the Appointment (cannot be updated)
     * @param appointmentDate  The appointment's date (cannot be in the past)
     * @param description      A brief description, <= 50 chars
     * @throws IllegalArgumentException if any field is invalid
     */
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date is invalid (null or in the past)");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid appointment description");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    //--------------------------------------------------------------------------
    // Getters only (no setters, as fields are not updatable)
    //--------------------------------------------------------------------------
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }
}
