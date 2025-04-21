/**
 * ContactTest.java
 *
 * Created by: Jacob Barker
 * Updated: April 20 2025
 * Course: CS 320 (SNHU)
 *
 * Validates constructor AND setter constraints for Contact.
 */
package contactTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import contact.Contact;

class ContactTest {

    @Test
    void testValidContact() {
        Contact c = new Contact("12345", "John", "Doe", "1234567890", "123 Main Street");
        assertEquals("12345",          c.getContactId());
        assertEquals("John",           c.getFirstName());
        assertEquals("Doe",            c.getLastName());
        assertEquals("1234567890",     c.getPhone());
        assertEquals("123 Main Street", c.getAddress());
    }

    @Test
    void testContactIdTooLong() { assertThrows(IllegalArgumentException.class,
        () -> new Contact("12345678901", "Jane", "Doe", "1234567890", "123 Main")); }

    @Test
    void testContactIdNull()    { assertThrows(IllegalArgumentException.class,
        () -> new Contact(null, "Jane", "Doe", "1234567890", "123 Main")); }

    /* ------------- First & last name constructor constraints ------------- */
    @Test
    void testFirstNameTooLong() { assertThrows(IllegalArgumentException.class,
        () -> new Contact("ID01", "FirstNameTooLong", "Doe", "1234567890", "123 Main")); }

    @Test
    void testFirstNameNull()    { assertThrows(IllegalArgumentException.class,
        () -> new Contact("ID02", null, "Doe", "1234567890", "123 Main")); }

    @Test
    void testLastNameTooLong()  { assertThrows(IllegalArgumentException.class,
        () -> new Contact("ID03", "Jane", "LastNameTooLong", "1234567890", "123 Main")); }

    @Test
    void testLastNameNull()     { assertThrows(IllegalArgumentException.class,
        () -> new Contact("ID04", "Jane", null, "1234567890", "123 Main")); }

    /* ------------- Phone constructor constraints ------------- */
    @Test
    void testPhoneShort()       { assertThrows(IllegalArgumentException.class,
        () -> new Contact("ID05", "Jane", "Doe", "123456789",  "123 Main")); }

    @Test
    void testPhoneLong()        { assertThrows(IllegalArgumentException.class,
        () -> new Contact("ID06", "Jane", "Doe", "12345678901","123 Main")); }

    @Test
    void testPhoneNonDigits()   { assertThrows(IllegalArgumentException.class,
        () -> new Contact("ID07", "Jane", "Doe", "12345abcde","123 Main")); }

    @Test
    void testPhoneNull()        { assertThrows(IllegalArgumentException.class,
        () -> new Contact("ID08", "Jane", "Doe", null,           "123 Main")); }

    /* ------------- Address constructor constraints ------------- */
    @Test
    void testAddressTooLong()   { String longAddr =
        "This address string is definitely more than thirty characters long!";
        assertThrows(IllegalArgumentException.class,
            () -> new Contact("ID09", "Jane", "Doe", "1234567890", longAddr)); }

    @Test
    void testAddressNull()      { assertThrows(IllegalArgumentException.class,
        () -> new Contact("ID10", "Jane", "Doe", "1234567890", null)); }

    /* --- New Setter coverage --- */
    private Contact newContact() {
        return new Contact("ABC123", "Amy", "Ng", "4055551234", "1 Maple St");
    }

    @Test
    void testSettersAcceptValidValues() {
        Contact c = newContact();
        c.setFirstName("Ava");
        c.setLastName("Li");
        c.setPhone("3035559988");
        c.setAddress("9 Birch Road");
        assertAll(
            () -> assertEquals("Ava",          c.getFirstName()),
            () -> assertEquals("Li",           c.getLastName()),
            () -> assertEquals("3035559988",   c.getPhone()),
            () -> assertEquals("9 Birch Road", c.getAddress())
        );
    }

    /* --- Negative‑path setter checks --- */
    @Test
    void testFirstNameSetterTooLong() {
        Contact c = newContact();
        assertThrows(IllegalArgumentException.class,
            () -> c.setFirstName("NameLongerThanTen"));
    }

    @Test
    void testLastNameSetterNull() {
        Contact c = newContact();
        assertThrows(IllegalArgumentException.class,
            () -> c.setLastName(null));
    }

    @Test
    void testPhoneSetterNonDigits() {
        Contact c = newContact();
        assertThrows(IllegalArgumentException.class,
            () -> c.setPhone("abc1234567"));
    }

    @Test
    void testAddressSetterTooLong() {
        Contact c = newContact();
        assertThrows(IllegalArgumentException.class,
            () -> c.setAddress("A very very very very very long address string"));
    }
}
