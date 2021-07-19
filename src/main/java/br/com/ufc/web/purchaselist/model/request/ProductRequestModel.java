package br.com.ufc.web.purchaselist.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import br.com.ufc.web.purchaselist.entity.MarketplaceModel;
import br.com.ufc.web.purchaselist.entity.ProductModel;

public class ProductRequestModel {
	
	@NotBlank(message = "Name needed of repassed")
	private String name;
	
	@NotBlank(message = "Description needed of repassed")
	@Size(min = 20, max = 250)
	private String description;
	
	@NotNull
	private double price;
	
	@NotNull
	private long idMarketplace;
	
	@Deprecated
	public ProductRequestModel() {
		super();
	}

	public ProductRequestModel(@NotBlank(message = "Name needed of repassed") String name,
			@NotBlank(message = "Description needed of repassed") @Size(min = 20, max = 250) String description,
			double price, long idMarketplace) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.idMarketplace = idMarketplace;
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

	public long getIdMarketplace() {
		return idMarketplace;
	}
	
	public ProductModel toModel(MarketplaceModel marketplace) {
		return new ProductModel(this.getName(), this.getDescription(), this.getPrice(), marketplace);
	}

	@Override
	public String toString() {
		return "ProductRequestModel [name=" + name + ", description=" + description + ", price=" + price
				+ ", idMarketplace=" + idMarketplace + "]";
	}
		
}
