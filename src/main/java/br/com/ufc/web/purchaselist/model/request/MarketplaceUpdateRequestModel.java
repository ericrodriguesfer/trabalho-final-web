package br.com.ufc.web.purchaselist.model.request;

import javax.validation.constraints.NotBlank;

public class MarketplaceUpdateRequestModel {

	@NotBlank(message = "Name needed of repassed")
	private String name;
	
	@NotBlank(message = "Name needed of repassed")
	private String initial;
	
	@Deprecated
	public MarketplaceUpdateRequestModel() {
		super();
	}

	public MarketplaceUpdateRequestModel(@NotBlank(message = "Name needed of repassed") String name, @NotBlank(message = "Initial needed of repassed") String initial) {
		super();
		this.name = name;
		this.initial = initial;
	}

	public String getName() {
		return name;
	}
	
	public String getInitial() {
		return initial;
	}

	@Override
	public String toString() {
		return "MarketplaceUpdateRequestModel [name=" + name + ", initial=" + initial + "]";
	}
	
}
