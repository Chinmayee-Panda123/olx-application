package com.olx.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.olx.user.dto.ActiveStatus;

@Entity
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 20)
    private String username;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, length = 50)
    private String roles;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "enum('TRUE','FALSE')")
    private ActiveStatus active;

    @Column(length = 45)
    private String firstname;

    @Column(length = 45)
    private String lastname;

    public UserEntity() {}

	public UserEntity(int id, String username, String password, String roles, ActiveStatus active, String firstname,
			String lastname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.active = active;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public UserEntity(String username, String password, String roles, ActiveStatus active, String firstname,
			String lastname) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.active = active;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public ActiveStatus getActive() {
		return active;
	}

	public void setActive(ActiveStatus active) {
		this.active = active;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

    
}
