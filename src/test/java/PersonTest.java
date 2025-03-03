import assignment2.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testValidPersonCreation() {
        Person person = Person.builder()
                .withId("1")
                .withFirstName("Arbin")
                .withLastName("Shrestha")
                .withAge(27)
                .withGender("Male")
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
                    .withFirstName("Arbin")
                    .withLastName("Shrestha")
                    .withAge(27)
                    .withGender("Male")
                    .build();
        });
        assertEquals("ID cannot be null.", exception.getMessage(), "Exception message should match.");
    }

    @Test
    public void testPersonWithBlankFirstName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .withId("1")
                    .withFirstName("  ")  // Blank First name
                    .withLastName("Shrestha")
                    .withAge(27)
                    .withGender("Male")
                    .build();
        });
        assertEquals("First name cannot be null or blank.", exception.getMessage(), "Exception message should match.");
    }

    @Test
    public void testPersonWithBlankLastName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .withId("2")
                    .withFirstName("Arbin")
                    .withLastName("  ")  // Blank last name
                    .withAge(27)
                    .withGender("Male")
                    .build();
        });
        assertEquals("Last name cannot be null or blank.", exception.getMessage(), "Exception message should match.");
    }

    @Test
    public void testPersonWithNegativeAge() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .withId("3")
                    .withFirstName("Arbin")
                    .withLastName("Shrestha")
                    .withAge(-5)  // Negative age
                    .withGender("Male")
                    .build();
        });
        assertEquals("Age cannot be negative.", exception.getMessage(), "Exception message should match.");
    }

    @Test
    public void testPersonWithNullFirstName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .withId("4")
                    .withFirstName(null)  // Null first name
                    .withLastName("Shrestha")
                    .withAge(27)
                    .withGender("Male")
                    .build();
        });
        assertEquals("First name cannot be null or blank.", exception.getMessage(), "Exception message should match.");
    }

    @Test
    public void testPersonWithNullLastName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.builder()
                    .withId("5")
                    .withFirstName("Arbin")
                    .withLastName(null)  // Null last name
                    .withAge(27)
                    .withGender("Male")
                    .build();
        });
        assertEquals("Last name cannot be null or blank.", exception.getMessage(), "Exception message should match.");
    }
}
