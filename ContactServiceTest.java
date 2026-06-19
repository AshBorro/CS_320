package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        assertDoesNotThrow(() -> {
            service.addContact(contact);
        });
    }

    @Test
    public void testAddNullContact() {

        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(null);
        });
    }

    @Test
    public void testDuplicateContactId() {

        ContactService service = new ContactService();

        Contact contact1 = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        Contact contact2 = new Contact(
                "12345",
                "Jane",
                "Doe",
                "0987654321",
                "456 Oak Street");

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    public void testDeleteContact() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        service.addContact(contact);

        assertDoesNotThrow(() -> {
            service.deleteContact("12345");
        });
    }

    @Test
    public void testDeleteContactNotFound() {

        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("99999");
        });
    }

    @Test
    public void testUpdateFirstName() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        service.addContact(contact);
        service.updateFirstName("12345", "Mike");

        assertEquals("Mike", contact.getFirstName());
    }

    @Test
    public void testUpdateLastName() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        service.addContact(contact);
        service.updateLastName("12345", "Jones");

        assertEquals("Jones", contact.getLastName());
    }

    @Test
    public void testUpdatePhone() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        service.addContact(contact);
        service.updatePhone("12345", "1112223333");

        assertEquals("1112223333", contact.getPhone());
    }

    @Test
    public void testUpdateAddress() {

        ContactService service = new ContactService();

        Contact contact = new Contact(
                "12345",
                "John",
                "Smith",
                "1234567890",
                "123 Main Street");

        service.addContact(contact);
        service.updateAddress("12345", "456 Oak Street");

        assertEquals("456 Oak Street", contact.getAddress());
    }

    @Test
    public void testUpdateContactNotFound() {

        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("99999", "Mike");
        });
    }
}