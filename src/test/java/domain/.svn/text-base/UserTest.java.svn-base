package domain;

import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

public class UserTest extends TestCase {
	public void testUser() {
		User user = new User();
		user.setUserid("u1");
		user.setUsername("name");
		assertEquals("u1", user.getUserid());
		assertEquals("name", user.getUsername());
		
		Role role = new Role();
		role.setRoleid(1);
		role.setName("scan monkey");
		role.setDescription("scan docs and inject work");
		
		Set<User> users = new HashSet<User>();
		users.add(user);
		role.setUsers(users);
		
		assertEquals(role.getRoleid(), 1);
		assertEquals(role.getName(), "scan monkey");
		assertEquals(role.getDescription(), "scan docs and inject work");
		assertEquals(role.getUsers(), users);
	}
}
