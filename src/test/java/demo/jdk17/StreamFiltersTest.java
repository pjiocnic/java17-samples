package demo.jdk17;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

class StreamFiltersTest {

	@Test
	void testFilters() {
		// Sample collection (List of Person objects)
		List<PersonJDK17> persons = Arrays.asList(new PersonJDK17("John", 25, Gender.MALE),
				new PersonJDK17("Alice", 30, Gender.FEMALE), new PersonJDK17("Bob", 22, Gender.MALE),
				new PersonJDK17("Eve", 28, Gender.FEMALE));

		// Using Java Streams filter with a complex predicate
		List<PersonJDK17> filteredPersons = persons.stream()
				.filter(person -> person.getAge() > 25 && person.getGender() == Gender.FEMALE)
				.collect(Collectors.toList());
		
		assertTrue(filteredPersons != null);
	}
	
	@Test
	void TestFiltersUsingCustomPredicates() {
		
		// Sample list of strings
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Avocado", "Grape");

        // Create an instance of the CustomPredicate class
        CustomPredicate customPredicate = new CustomPredicate();

        // Use Java Streams to filter based on the custom predicate
        List<String> result = fruits.stream()
                			          .filter(customPredicate)
                			          .toList();   // Need JDK17 else get an error "The method toList() is undefined for the type Stream<String>"
        
        // If JDK 8 use following
        // Use Java Streams to filter based on the custom predicate
//        List<String> result = strings.stream()
//                .filter(customPredicate)
//                .collect(Collectors.toList());
        
        
        // Define the fruits you want to check for
        List<String> expectedFruits = Arrays.asList("Apple", "Avocado");

        // Check if the list contains only the expected fruits
        boolean containsOnlyExpectedFruits = result.stream()
                								   .allMatch(expectedFruits::contains);
        
        assertTrue(containsOnlyExpectedFruits);
	}

}

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
class PersonJDK17 {
	String name;
	int age;
	Gender gender;
}

enum Gender {
	MALE, FEMALE
}

class CustomPredicate implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return s.startsWith("A");
    }
}