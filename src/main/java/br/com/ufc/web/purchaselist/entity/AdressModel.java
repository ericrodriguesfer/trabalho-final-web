package br.com.ufc.web.purchaselist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class AdressModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Street of adress needed of repassed")
	private String street;
	
	@NotBlank(message = "Number of adress needed of repassed")
	private long number;
	
	@NotBlank(message = "Neighborhood of adress needed of repassed")
	private String neighborhood;
	
	@NotBlank(message = "City of adress needed of repassed")
	private String city;
	
	@Deprecated
	public AdressModel() {
		super();
	}

	public AdressModel(@NotBlank(message = "Street of adress needed of repassed") String street,
			@NotBlank(message = "Number of adress needed of repassed") long number,
			@NotBlank(message = "Neighborhood of adress needed of repassed") String neighborhood,
			@NotBlank(message = "City of adress needed of repassed") String city) {
		super();
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
		return "Adress [id=" + id + ", street=" + street + ", number=" + number + ", neighborhood=" + neighborhood
				+ ", city=" + city + "]";
	}
	
}
