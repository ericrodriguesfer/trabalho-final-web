package br.com.ufc.web.purchaselist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class ProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Name needed of repassed")
	private String name;
	
	@NotBlank(message = "Description needed of repassed")
	@Size(min = 20, max = 250)
	private String description;
	
	@NotNull
	private double price;
	
	@NotNull
	@OneToOne
	private MarketplaceModel marketplace;
	
	@Deprecated
	public ProductModel() {
		super();
	}

	public ProductModel(@NotBlank(message = "Name needed of repassed") String name,
			@NotBlank(message = "Description needed of repassed") @Size(min = 20, max = 250) String description,
			@NotNull double price, MarketplaceModel marketplace) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.marketplace = marketplace;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public MarketplaceModel getMarketplace() {
		return marketplace;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", marketplace=" + marketplace + "]";
	}
	
}
