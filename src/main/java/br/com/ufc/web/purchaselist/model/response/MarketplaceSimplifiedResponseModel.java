package br.com.ufc.web.purchaselist.model.response;

public class MarketplaceSimplifiedResponseModel {

	private String name;

	public MarketplaceSimplifiedResponseModel() {
		super();
	}

	public MarketplaceSimplifiedResponseModel(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "MarketplaceSimplifiedResponseModel [name=" + name + "]";
	}
	
}
