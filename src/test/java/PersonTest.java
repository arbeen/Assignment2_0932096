import assignment2.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testValidPersonCreation() {
        Person person = Person.builder()
                .id("1")
                .firstName("Arbin")
                .lastName("Shrestha")
                .age(27)
                .gender("Male")
                .build();

        assertNotNull(person);
        assertEquals("1", person.getId(), "ID should match.");
        assertEquals("Arbin", person.getFirstName(), "First name should match.");
        assertEquals("Shrestha", person.getLastName(), "Last name should match.");
        assertEquals(27, person.getAge(), "Age should match.");
        assertEquals("Male", person.getGender(), "Gender should match.");
    }

//    ID null
    @Test
    public void testPersonWithNullId() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .firstName("Arbin")
                    .lastName("Shrestha")
                    .age(27)
                    .gender("Male")
                    .build();
        });
        assertEquals("ID cannot be null.", exception.getMessage(), "Exception message should match.");
    }

    @Test
    public void testPersonWithBlankFirstName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .id("1")
                    .firstName("  ")  // Blank First name
                    .lastName("Shrestha")
                    .age(27)
                    .gender("Male")
                    .build();
        });
        assertEquals("First name cannot be null or blank.", exception.getMessage(), "Exception message should match.");
    }

    @Test
    public void testPersonWithBlankLastName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .id("2")
                    .firstName("Arbin")
                    .lastName("  ")  // Blank last name
                    .age(27)
                    .gender("Male")
                    .build();
        });
        assertEquals("Last name cannot be null or blank.", exception.getMessage(), "Exception message should match.");
    }

    @Test
    public void testPersonWithNegativeAge() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .id("3")
                    .firstName("Arbin")
                    .lastName("Shrestha")
                    .age(-5)  // Negative age
                    .gender("Male")
                    .build();
        });
        assertEquals("Age cannot be negative.", exception.getMessage(), "Exception message should match.");
    }

    @Test
    public void testPersonWithNullFirstName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .id("4")
                    .firstName(null)  // Null first name
                    .lastName("Shrestha")
                    .age(27)
                    .gender("Male")
                    .build();
        });
        assertEquals("First name cannot be null or blank.", exception.getMessage(), "Exception message should match.");
    }

    @Test
    public void testPersonWithNullLastName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .id("5")
                    .firstName("Arbin")
                    .lastName(null)  // Null last name
                    .age(27)
                    .gender("Male")
                    .build();
        });
        assertEquals("Last name cannot be null or blank.", exception.getMessage(), "Exception message should match.");
    }
}
