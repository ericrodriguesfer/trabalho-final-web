package br.com.ufc.web.purchaselist.model.response;

public class ProductResponseModel {
	
	private long id;
	private String name;
	private String description;
	private double price;
	private MarketplaceSimplifiedResponseModel marketplace;
	
	public ProductResponseModel() {
		super();
	}

	public ProductResponseModel(long id, String name, String description, double price,
			MarketplaceSimplifiedResponseModel marketplace) {
		super();
		this.id = id;
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

	public MarketplaceSimplifiedResponseModel getMarketplace() {
		return marketplace;
	}

	@Override
	public String toString() {
		return "ProductResponseModel [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", marketplace=" + marketplace + "]";
	}

}
