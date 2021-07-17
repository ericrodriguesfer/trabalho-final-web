package br.com.ufc.web.purchaselist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Name needed of repassed")
	private String name;
	
	@NotBlank(message = "E-mail needed of repassed")
	@Email(message = "Email not format valid")
	@Column(unique = true)
	private String email;
	
	@NotBlank(message = "Password needed of repassed")
	private String password;
	
	@Deprecated
	public User() {
		super();
	}

	public User(@NotBlank(message = "Name needed of repassed") String name,
			@NotBlank(message = "E-mail needed of repassed") @Email(message = "Email not format valid") String email,
			@NotBlank(message = "Password needed of repassed") String password) {
		super();
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
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
}
