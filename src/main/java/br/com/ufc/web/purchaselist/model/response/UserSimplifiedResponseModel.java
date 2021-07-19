package br.com.ufc.web.purchaselist.model.response;

public class UserSimplifiedResponseModel {

	private long id;
	private String name;
	private String email;
	
	public UserSimplifiedResponseModel() {
		super();
	}

	public UserSimplifiedResponseModel(long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
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

	@Override
	public String toString() {
		return "UserSimplifiedResponseModel [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	
}
