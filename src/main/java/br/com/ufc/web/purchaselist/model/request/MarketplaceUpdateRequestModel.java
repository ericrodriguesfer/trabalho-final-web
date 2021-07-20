package br.com.ufc.web.purchaselist.model.request;

import javax.validation.constraints.NotBlank;

public class MarketplaceUpdateRequestModel {

	@NotBlank(message = "Name needed of repassed")
	private String name;
	
	@Deprecated
	public MarketplaceUpdateRequestModel() {
		super();
	}

	public MarketplaceUpdateRequestModel(@NotBlank(message = "Name needed of repassed") String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "MarketplaceUpdateRequestModel [name=" + name + "]";
	};
	
}
