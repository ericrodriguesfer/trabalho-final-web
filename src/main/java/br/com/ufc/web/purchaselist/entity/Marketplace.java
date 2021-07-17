package br.com.ufc.web.purchaselist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
public class Marketplace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "Name needed of repassed")
	private String name;

	@NotBlank(message = "Quantity products needed of repassed")
	private long quantityProducts;

	@NotNull
	@ManyToOne
	private User user;

	@NotNull
	@OneToOne
	private Adress adress;

	@Deprecated
	public Marketplace() {
		super();
	}

	public Marketplace(@NotBlank(message = "Name needed of repassed") String name, User user, Adress adress) {
		super();
		this.name = name;
		this.quantityProducts = 0;
		this.user = user;
		this.adress = adress;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getQuantityProducts() {
		return quantityProducts;
	}

	public User getUser() {
		return user;
	}

	public Adress getAdress() {
		return adress;
	}

	@Override
	public String toString() {
		return "Marketplace [id=" + id + ", name=" + name + ", quantityProducts=" + quantityProducts + ", user=" + user
				+ ", adress=" + adress + "]";
	}

}
