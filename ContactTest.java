package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testValidContact() {

        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Smith", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345678901",
                    "John",
                    "Smith",
                    "1234567890",
                    "123 Main Street");
        });
    }

    @Test
    public void testNullContactId() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    null,
                    "John",
                    "Smith",
                    "1234567890",
                    "123 Main Street");
        });
    }

    @Test
    public void testNullFirstName() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    null,
                    "Smith",
                    "1234567890",
                    "123 Main Street");
        });
    }

    @Test
    public void testFirstNameTooLong() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "Johnathan11",
                    "Smith",
                    "1234567890",
                    "123 Main Street");
        });
    }

    @Test
    public void testNullLastName() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    null,
                    "1234567890",
                    "123 Main Street");
        });
    }

    @Test
    public void testLastNameTooLong() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smithfield1",
                    "1234567890",
                    "123 Main Street");
        });
    }

    @Test
    public void testInvalidPhone() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    "123",
                    "123 Main Street");
        });
    }

    @Test
    public void testNullPhone() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    null,
                    "123 Main Street");
        });
    }

    @Test
    public void testInvalidAddress() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    "1234567890",
                    "This address is definitely longer than thirty characters");
        });
    }

    @Test
    public void testNullAddress() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(
                    "12345",
                    "John",
                    "Smith",
                    "1234567890",
                    null);
        });
    }
}