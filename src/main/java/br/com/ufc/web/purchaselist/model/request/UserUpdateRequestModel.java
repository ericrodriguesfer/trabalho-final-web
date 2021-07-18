package br.com.ufc.web.purchaselist.model.request;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserUpdateRequestModel {

	@NotBlank(message = "Name needed of repassed")
	private String name;
	
	@NotBlank(message = "E-mail needed of repassed")
	@Email(message = "Email not format valid")
	@Column(unique = true)
	private String email;

	@Deprecated
	public UserUpdateRequestModel() {
		super();
	}

	public UserUpdateRequestModel(@NotBlank(message = "Name needed of repassed") String name,
			@NotBlank(message = "E-mail needed of repassed") @Email(message = "Email not format valid") String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "UserUpdateRequestModel [name=" + name + ", email=" + email + "]";
	}
	
}
