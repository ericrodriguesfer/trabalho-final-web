package br.com.ufc.web.purchaselist.model.request;

public class ProductUpdateRequestModel {
	
	private String name;
	private String description;
	private double price;
	
	public ProductUpdateRequestModel() {
		super();
	}
	
	public ProductUpdateRequestModel(String name, String description, double price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
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
	
	@Override
	public String toString() {
		return "ProductUpdateRequestModel [name=" + name + ", description=" + description + ", price=" + price + "]";
	}
	
}
