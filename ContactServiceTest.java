/**
 * ContactServiceTest.java
 *
 * Created by: Jacob Barker
 * Updated: April 20 2025
 * Course: CS 320 (SNHU)
 *
 * Unit tests for the ContactService class, ensuring that contacts can be
 * added, deleted, and updated according to the specified constraints.
 */

package contactTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import contact.Contact;
import contact.ContactService;

class ContactServiceTest {

    
    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        service.addContact(new Contact("12345", "John", "Doe", "1234567890", "123 Main St"));
        assertNotNull(service.getContact("12345"));
        assertEquals("John", service.getContact("12345").getFirstName());
    }

    @Test
    void testAddDuplicateId() {
        ContactService service = new ContactService();
        service.addContact(new Contact("12345", "Jane", "Doe", "1111111111", "456 Elm St"));
        assertThrows(IllegalArgumentException.class, () ->
            service.addContact(new Contact("12345", "Mark", "Twain", "2222222222", "789 Maple St")));
    }

    
    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        service.addContact(new Contact("55555", "Alice", "Smith", "9999999999", "1010 Oak Ave"));
        service.deleteContact("55555");
        assertNull(service.getContact("55555"));   // should be gone
        // deleting again should raise an exception in typical implementations
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("55555"));
    }

    @Test
    void testDeleteContactNotFound() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("DoesNotExist"));
    }

    /* ------------------------------------------------------------
     * Update tests 
     * ------------------------------------------------------------ */
    @Test
    void testUpdateFirstName() {
        ContactService service = new ContactService();
        service.addContact(new Contact("ABC", "John", "Doe", "1234567890", "1122 Birch Ln"));
        service.updateFirstName("ABC", "Jake");
        assertEquals("Jake", service.getContact("ABC").getFirstName());
    }

    @Test
    void testUpdatePhone() {
        ContactService service = new ContactService();
        service.addContact(new Contact("XYZ", "Tina", "Fey", "1234567890", "55 Fifth Ave"));
        service.updatePhone("XYZ", "9876543210");
        assertEquals("9876543210", service.getContact("XYZ").getPhone());
    }

    /* ------------------------------------------------------------
     * New tests 
     * ------------------------------------------------------------ */

    @Test
    void testUpdateLastName() {
        ContactService service = new ContactService();
        service.addContact(new Contact("ID1", "Bo", "Li", "1111111111", "Addr"));
        service.updateLastName("ID1", "Yu");
        assertEquals("Yu", service.getContact("ID1").getLastName());
    }

    @Test
    void testUpdateAddress() {
        ContactService service = new ContactService();
        service.addContact(new Contact("ID2", "Cy", "Ng", "2222222222", "Old"));
        service.updateAddress("ID2", "New Addr");
        assertEquals("New Addr", service.getContact("ID2").getAddress());
    }

    @Test
    void testUpdateFirstNameNullThrows() {
        ContactService service = new ContactService();
        service.addContact(new Contact("ID3", "Eve", "Ho", "3333333333", "Place"));
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("ID3", null));
    }

    @Test
    void testUpdatePhoneInvalidLengthThrows() {
        ContactService service = new ContactService();
        service.addContact(new Contact("ID4", "Al", "Ko", "4444444444", "Street"));
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("ID4", "short")); // <10 digits
    }

    @Test
    void testUpdateAllFieldsHappyPath() {
        ContactService service = new ContactService();
        service.addContact(new Contact("ID5", "Amy", "Ng", "5555555555", "Old"));
        service.updateFirstName("ID5", "Ann");
        service.updateLastName("ID5",  "Lu");
        service.updatePhone("ID5",     "6666666666");
        service.updateAddress("ID5",   "New");
        Contact c = service.getContact("ID5");
        assertAll(
            () -> assertEquals("Ann",  c.getFirstName()),
            () -> assertEquals("Lu",   c.getLastName()),
            () -> assertEquals("6666666666", c.getPhone()),
            () -> assertEquals("New",  c.getAddress())
        );
    }
}
