package fr.frugume.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.frugume.utils.ComparableUtils;

public class UserDto implements Comparable<UserDto> {
	
	/** Id. */
	private Integer id;

	/** Prénom. */
	private String firstName;

	/** Nom. */
	private String lastName;

	/** login. */
	private String login;

	/** mdp. */
	@JsonIgnore
	private String password;
	
	/** role. */
	private String role;
	
	@Override
	public int compareTo(UserDto o) {
		return ComparableUtils.safeStringCompare(firstName, o.getFirstName());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
