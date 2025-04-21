/**
 * Contact.java
 *
 * Created by: Jacob Barker
 * Date: March 23, 2025
 * Course: CS 320: Software Testing, Automation, and Quality Assurance (SNHU)
 *
 * This class represents a single Contact with an ID, first name, last name,
 * phone number, and address. It enforces constraints on each field to match
 * the project requirements (e.g., ID length, null checks, phone length).
 */

package contact;

public class Contact {

    // Contact fields
    private final String contactId;  // Must not be longer than 10 chars, not null, not updatable 
    private String firstName;        // Must not be longer than 10 chars, not null
    private String lastName;         // Must not be longer than 10 chars, not null
    private String phone;            // Exactly 10 digits, not null
    private String address;          // No longer than 30 chars, not null

    /**
     * Constructs a Contact object, enforcing the following constraints:
     * - contactId: not null, length <= 10, not updatable
     * - firstName: not null, length <= 10
     * - lastName: not null, length <= 10
     * - phone: not null, length == 10
     * - address: not null, length <= 30
     *
     * @param contactId Unique identifier for this contact (not updatable)
     * @param firstName The first name of the contact
     * @param lastName  The last name of the contact
     * @param phone     A 10-digit phone number
     * @param address   The contact's address (<= 30 chars)
     * @throws IllegalArgumentException if any field is invalid
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be exactly 10 digits");
        }

        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    //--------------------------------------------------------------------------//
    // Getters (contactId has no setter, as it's not updatable)
    //--------------------------------------------------------------------------//

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    //--------------------------------------------------------------------------
    // Setters for fields that may be updated
    //--------------------------------------------------------------------------

    /**
     * Updates the first name if it is valid (not null, <= 10 chars).
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    /**
     * Updates the last name if it is valid (not null, <= 10 chars).
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    /**
     * Updates the phone number if it is valid (not null, == 10 chars).
     */
    public void setPhone(String phone) {
    	if (phone == null || !phone.matches("\\d{10}")) {
    	    throw new IllegalArgumentException("Phone must be exactly 10 digits");
    	}
        this.phone = phone;
    }

    /**
     * Updates the address if it is valid (not null, <= 30 chars).
     */
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}
