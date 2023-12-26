package demo.jdk8;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.junit.jupiter.api.Test;

class ApacheCollectionsTest {

	@Test
	void testFiltersForSimpleCollection() {
		// Sample collection (List of integers)
        List<Integer> numbersImmutable = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numbersMutable = new ArrayList<>(numbersImmutable);

        Predicate<Integer> predicate = n -> n.intValue() > 5;

        // Using Apache Commons Collections filter
        boolean modified = CollectionUtils.filter(numbersMutable, predicate);
        
        assertTrue(modified);
        assertTrue(numbersMutable.size() == 5);
	}

	@Test
	void testFiltersForComplexCollection() {
		
        // Sample collection (List of Person objects)
        List<PersonJDK8> persons = new ArrayList<>();
        persons.add(new PersonJDK8("John", 25, Gender.MALE));
        persons.add(new PersonJDK8("Alice", 30, Gender.FEMALE));
        persons.add(new PersonJDK8("Bob", 22, Gender.MALE));
        persons.add(new PersonJDK8("Eve", 28, Gender.FEMALE));

        // Define a complex predicate using Apache Commons Collections Predicate
        Predicate<PersonJDK8> complexPredicate = person -> person.getAge() > 25 && person.getGender() == Gender.FEMALE;

        // Use CollectionUtils.filter to apply the predicate
        CollectionUtils.filter(persons, complexPredicate);
        
        assertTrue(persons.size() == 2);
	}

}

class PersonJDK8 {
	private String name;
	private int age;
	private Gender gender;

	public PersonJDK8(String name, int age, Gender gender) {
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
