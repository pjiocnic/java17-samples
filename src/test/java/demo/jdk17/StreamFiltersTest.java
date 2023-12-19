package demo.jdk17;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class StreamFiltersTest {

	@Test
	void testFilters() {
		// Sample collection (List of Person objects)
		List<Person> persons = Arrays.asList(new Person("John", 25, Gender.MALE),
				new Person("Alice", 30, Gender.FEMALE), new Person("Bob", 22, Gender.MALE),
				new Person("Eve", 28, Gender.FEMALE));

		// Using Java Streams filter with a complex predicate
		List<Person> filteredPersons = persons.stream()
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

class Person {
	private String name;
	private int age;
	private Gender gender;

	public Person(String name, int age, Gender gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Gender getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", age=" + age + ", gender=" + gender + '}';
	}
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