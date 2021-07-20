package br.com.ufc.web.purchaselist.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

public class ProductUpdateRequestModel {
	
	@NotBlank(message = "Name needed of repassed")
	private String name;
	
	@NotBlank(message = "Description needed of repassed")
	@Size(min = 20, max = 250)
	private String description;
	
	@NotNull
	private double price;
	
	@Deprecated
	public ProductUpdateRequestModel() {
		super();
	}
	
	public ProductUpdateRequestModel(@NotBlank(message = "Name needed of repassed") String name,
			@NotBlank(message = "Description needed of repassed") @Size(min = 20, max = 250) String description,
			double price) {
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
