package br.com.ufc.web.purchaselist.model.response;

public class UserResponseModel {
	
	private long id;
	private String name;
	private String email;
	private String password;
	
	public UserResponseModel() {
		super();
	}

	public UserResponseModel(long id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "UserResponseModel [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
}
