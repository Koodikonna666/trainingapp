package hh.palvelinohjelmointi.trainingapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private long id;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String passwordHash;
	
	@Column(name = "role", nullable =false)
	private String role;
	
	@Column(name = "firstName", nullable =false)
	private String firstName;
	
	@Column(name = "lastName", nullable =false)
	private String lastName;
	
	@Column(name = "club", nullable =false)
	private String club;
	

	


	public User() {
		
	}
	
	
	public User(String username, String passwordHash, String role, String firstName, String lastName, String club) {
		super();
		this.passwordHash = passwordHash;
		this.role = role;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.club =club;
	}

	
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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


	public String getClub() {
		return club;
	}


	public void setClub(String club) {
		this.club = club;
	}



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	



	public String getPasswordHash() {
		return passwordHash;
	}


	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
