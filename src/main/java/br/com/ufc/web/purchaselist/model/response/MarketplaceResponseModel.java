package br.com.ufc.web.purchaselist.model.response;

public class MarketplaceResponseModel {
	
	private long id;
	private String name;
	private long quantityProducts;
	private String initial;
//	private UserSimplifiedResponseModel user;
	private AdressResponseModel adress;
	
	public MarketplaceResponseModel() {
		super();
	}

	public MarketplaceResponseModel(long id, String name, long quantityProducts,
			String initial, AdressResponseModel adress) {
		super();
		this.id = id;
		this.name = name;
		this.quantityProducts = quantityProducts;
		this.initial = initial;
//		this.user = user;
		this.adress = adress;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getQuantityProducts() {
		return quantityProducts;
	}

//	public UserSimplifiedResponseModel getUser() {
//		return user;
//	}
	
	public String getInitial() {
		return initial;
	}

	public AdressResponseModel getAdress() {
		return adress;
	}

	@Override
	public String toString() {
		return "MarketplaceResponseModel [id=" + id + ", name=" + name + ", quantityProducts=" + quantityProducts
				+ ", initial=" + initial + ", adress=" + adress + "]";
	}
	
}
