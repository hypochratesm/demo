package exam;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Test6Test {

	@Test
	void testSum() {
		//fail("Not yet implemented");
		
		Test6 ts6 = new Test6();
		assertEquals(30, ts6.sum(10,20));
	}

}
