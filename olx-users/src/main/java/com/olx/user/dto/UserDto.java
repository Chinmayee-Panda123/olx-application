package com.olx.user.dto;

public class UserDto {

    private int id;
    private String username;
    private String password;
    private String roles;
    private ActiveStatus active;
    private String firstname;
    private String lastname;

    public UserDto() {}

    

    public UserDto(int id, String username, String password, String roles, ActiveStatus active, String firstname,
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
