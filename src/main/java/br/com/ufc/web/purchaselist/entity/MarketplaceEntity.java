package br.com.ufc.web.purchaselist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
public class MarketplaceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "Name needed of repassed")
	private String name;

	@NotNull
	private long quantityProducts;

//	@NotNull
//	@ManyToOne
//	private UserModel user;

	@NotNull
	@OneToOne
	private AdressEntity adress;

	@Deprecated
	public MarketplaceEntity() {
		super();
	}

	public MarketplaceEntity(@NotBlank(message = "Name needed of repassed") String name, AdressEntity adress) {
		super();
		this.name = name;
		this.quantityProducts = 0;
//		this.user = user;
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

//	public UserModel getUser() {
//		return user;
//	}

	public AdressEntity getAdress() {
		return adress;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Marketplace [id=" + id + ", name=" + name + ", quantityProducts=" + quantityProducts + ", adress=" + adress + "]";
	}

}
