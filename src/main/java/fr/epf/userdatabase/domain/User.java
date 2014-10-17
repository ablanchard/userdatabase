package fr.epf.userdatabase.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Describe a user
 * @author alex
 *
 */

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(name="first_name")
	private String firstName ;

	@Column(name="last_name")
	private String lastName;
	
	public User(){
	}
	
	public User(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		
		private User user;
		
		private Builder() {
			user = new User();
		}
		
		public Builder id(Long id) {
			user.id = id;
			return this;
		}
		
		public Builder firstName(String firstName) {
			user.firstName = firstName;
			return this;
		}
		
		public Builder lastName(String lastName) {
			user.lastName = lastName;
			return this;
		}
		
		public User build() {
			return user;
		}
		
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
}
