package br.com.ufc.web.purchaselist.model.request;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.ufc.web.purchaselist.entity.UserModel;

public class UserRequestModel {
	
	@NotBlank(message = "Name needed of repassed")
	private String name;
	
	@NotBlank(message = "E-mail needed of repassed")
	@Email(message = "Email not format valid")
	@Column(unique = true)
	private String email;
	
	@NotBlank(message = "Password needed of repassed")
	private String password;
	
	@Deprecated
	public UserRequestModel() {
		super();
	}
	
	public UserRequestModel(@NotBlank(message = "Name needed of repassed") String name,
			@NotBlank(message = "E-mail needed of repassed") @Email(message = "Email not format valid") String email,
			@NotBlank(message = "Password needed of repassed") String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
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

	public UserModel toModel() {
		return new UserModel(this.getName(), this.getEmail(), this.getPassword());
	}

	@Override
	public String toString() {
		return "UserRequestModel [name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
}
