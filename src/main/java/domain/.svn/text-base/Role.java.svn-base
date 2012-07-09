package domain;


import java.util.HashSet;
import java.util.Set;

/**
 * Representation of a role.
 *
 */
public final class Role implements java.io.Serializable {


	private static final long serialVersionUID = 3958798350281356269L;
	private long roleid;
	private String name;
	private String description;
	private Set<ActivityRole> activityRoles = new HashSet<ActivityRole>(0);
	private Set<User> users = new HashSet<User>(0);

	public Role() {
	}



	public long getRoleid() {
		return this.roleid;
	}

	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<ActivityRole> getActivityRoles() {
		return this.activityRoles;
	}

	public void setActivityRoles(Set<ActivityRole> activityRoles) {
		this.activityRoles = activityRoles;
	}

	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
