package org.arbin;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@JsonDeserialize(builder = Person.PersonBuilder.class)
public class Person {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final String gender;

//    Person Builder
//    Commenting to create a PR
    public static class PersonBuilder {
        public Person build() {
            validate();
            return new Person(id, firstName, lastName, age, gender);
        }

        private void validate() {
            if (id == null) {
                throw new IllegalArgumentException("ID cannot be null.");
            }
            if (firstName == null || firstName.trim().isEmpty()) {
                throw new IllegalArgumentException("First name cannot be null or blank.");
            }
            if (lastName == null || lastName.trim().isEmpty()) {
                throw new IllegalArgumentException("Last name cannot be null or blank.");
            }
            if (age != null && age < 0) {
                throw new IllegalArgumentException("Age cannot be negative.");
            }
        }
    }
}
