package fr.epf.userdatabase;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.epf.userdatabase.domain.User;

public class UserTest {
	
	@Test
	public void test() {
		assertEquals("a", "a");
	}
	
	@Test
	public void testUser() {
		User user1 = User.builder()
				.firstName("tof")
				.lastName("tof")
				.build();
		
		User user2 = User.builder()
				.firstName("aa")
				.lastName("22")
				.build();
		
		assertEquals(user1,user2);
	}
}
