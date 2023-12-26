package demo.jdk17;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NullSafeNavigationTest {

	@Test
	void test() {
		
		PersonWithAddr person = new PersonWithAddr();
        person.name = "John Doe";
        
        Addr addr = new Addr();
        addr.streetNm = "Crossing st";
        person.addr = addr;
        
        
		String street = person?.addr?.street;
	}

}

class PersonWithAddr {
    public String name;
    public Addr addr;
    
}


class Addr {
	public String streetNm;
}