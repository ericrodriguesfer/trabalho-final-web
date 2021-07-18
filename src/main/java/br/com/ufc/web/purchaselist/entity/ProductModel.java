package br.com.ufc.web.purchaselist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
public class ProductModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Name needed of repassed")
	private String name;
	
	@NotBlank(message = "Description needed of repassed")
	@Min(value = 20)
	@Max(value = 250)
	private String description;
	
	@NotBlank(message = "Price needed of repassed")
	private double price;
	
	@NotNull
	@OneToOne
	private MarketplaceModel marketplace;
	
	@Deprecated
	public ProductModel() {
		super();
	}

	public ProductModel(@NotBlank(message = "Name needed of repassed") String name,
			@NotBlank(message = "Description needed of repassed") @Min(20) @Max(250) String description,
			@NotBlank(message = "Price needed of repassed") double price, MarketplaceModel marketplace) {
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", marketplace=" + marketplace + "]";
	}
	
}
