package br.com.ufc.web.purchaselist.model.request;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.ufc.web.purchaselist.entity.AdressEntity;

public class AdressRequestModel {

	@NotBlank(message = "Street of adress needed of repassed")
	private String street;
	
	@NotNull()
	private long number;
	
	@NotBlank(message = "Neighborhood of adress needed of repassed")
	private String neighborhood;
	
	@NotBlank(message = "City of adress needed of repassed")
	private String city;
	
	@Deprecated
	public AdressRequestModel() {
		super();
	}

	public AdressRequestModel(@NotBlank(message = "Street of adress needed of repassed") String street,
			@NotNull() long number,
			@NotBlank(message = "Neighborhood of adress needed of repassed") String neighborhood,
			@NotBlank(message = "City of adress needed of repassed") String city) {
		super();
		this.street = street;
		this.number = number;
		this.neighborhood = neighborhood;
		this.city = city;
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
	
	public AdressEntity toModel() {
		return new AdressEntity(this.getStreet(), this.getNumber(), this.getNeighborhood(), this.getCity());
	}

	@Override
	public String toString() {
		return "AdressRequestModel [street=" + street + ", number=" + number + ", neighborhood=" + neighborhood
				+ ", city=" + city + "]";
	}
	
}
