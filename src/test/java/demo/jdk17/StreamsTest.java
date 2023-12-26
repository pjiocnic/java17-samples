package demo.jdk17;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class StreamsTest {

	
	@Test
	void testConcatenation() {
        List<Person> persons = Arrays.asList(
                new Person(1, "Alice"),
                new Person(2, "Bob"),
                new Person(3, "Charlie")
        );

        // Concatenate ids using Java streams
        String concatenatedIds = persons.stream()
                .map(person -> Long.toString(person.getId())) // Convert long ids to Strings
                .collect(Collectors.joining(", ")); // Concatenate using a delimiter

        System.out.println("Concatenated ids: " + concatenatedIds);
	}
}

class Person {
    private long id;
    private String name;

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}