/**
 * ContactService.java
 *
 * Created by: Jacob Barker
 * Date: March 23, 2025
 * Course: CS 320: Software Testing, Automation, and Quality Assurance (SNHU)
 *
 * This service manages a collection of Contact objects. It provides methods
 * to add, delete, and update contacts in an in-memory data structure.
 * Requirements:
 * - Must store unique contacts by their ID.
 * - Must allow updating firstName, lastName, phone, and address by ID.
 */

package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    // In-memory storage of contacts keyed by contactId
    private Map<String, Contact> contacts = new HashMap<>();

    /**
     * Adds a new Contact to the service, ensuring the contact ID is unique.
     *
     * @param contact The Contact object to be added
     * @throws IllegalArgumentException if the contact ID already exists
     */
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    /**
     * Deletes an existing Contact by its ID.
     *
     * @param contactId The ID of the Contact to remove
     * @throws IllegalArgumentException if no Contact exists with that ID
     */
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found for deletion.");
        }
        contacts.remove(contactId);
    }

    /**
     * Updates the first name of the Contact matching the given ID.
     *
     * @param contactId   The ID of the Contact to update
     * @param newFirstName The new first name
     * @throws IllegalArgumentException if no Contact found or name is invalid
     */
    public void updateFirstName(String contactId, String newFirstName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found for update.");
        }
        contact.setFirstName(newFirstName);
    }

    /**
     * Updates the last name of the Contact matching the given ID.
     *
     * @param contactId   The ID of the Contact to update
     * @param newLastName The new last name
     */
    public void updateLastName(String contactId, String newLastName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found for update.");
        }
        contact.setLastName(newLastName);
    }

    /**
     * Updates the phone number of the Contact matching the given ID.
     *
     * @param contactId The ID of the Contact to update
     * @param newPhone  The new phone number (10 digits)
     */
    public void updatePhone(String contactId, String newPhone) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found for update.");
        }
        contact.setPhone(newPhone);
    }

    /**
     * Updates the address of the Contact matching the given ID.
     *
     * @param contactId   The ID of the Contact to update
     * @param newAddress  The new address (<= 30 chars)
     */
    public void updateAddress(String contactId, String newAddress) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found for update.");
        }
        contact.setAddress(newAddress);
    }

    /**
     * Retrieves a Contact by its ID (optional helper for testing).
     *
     * @param contactId ID of the desired Contact
     * @return The Contact object if found, or null if none
     */
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
