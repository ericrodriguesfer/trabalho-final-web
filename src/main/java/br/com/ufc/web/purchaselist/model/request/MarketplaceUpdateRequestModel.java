package br.com.ufc.web.purchaselist.model.request;

public class MarketplaceUpdateRequestModel {

	private String name;

	public MarketplaceUpdateRequestModel() {
		super();
	}

	public MarketplaceUpdateRequestModel(String name) {
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
