package br.com.ufc.web.purchaselist.model.response;

public class AdressResponseModel {
	
	private long id;
	private String street;
	private long number;
	private String neighborhood;
	private String city;
	
	public AdressResponseModel() {
		super();
	}
	
	public AdressResponseModel(long id, String street, long number, String neighborhood, String city) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public long getNumber() {
		return number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "AdressResponseModel [id=" + id + ", street=" + street + ", number=" + number + ", neighborhood="
				+ neighborhood + ", city=" + city + "]";
	}
	
}
