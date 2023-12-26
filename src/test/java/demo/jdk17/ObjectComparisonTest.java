package demo.jdk17;

import java.util.Objects;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class ObjectComparisonTest {

	@Test
	public void test() {
		
		Employee p1 = new Employee();
		Employee p2 = new Employee();
		
		String x = p1.lastName;
		
		boolean match = Objects.equals(p1.getLastName(), p2.getLastName())
							&& Objects.equals(p1.getFirstName(), p2.getFirstName());

	}
}

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
class Employee {
	String name;
	String lastName;
	String firstName;
	int age;
	Gender gender;
}