package br.com.ufc.web.purchaselist.model.response;

public class MarketplaceSimplifiedResponseModel {

	private String name;
	private String initial;

	public MarketplaceSimplifiedResponseModel() {
		super();
	}

	public MarketplaceSimplifiedResponseModel(String name, String initial) {
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
		return "MarketplaceSimplifiedResponseModel [name=" + name + ", initial=" + initial + "]";
	}
	
}
