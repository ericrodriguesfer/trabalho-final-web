package br.com.ufc.web.purchaselist.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
public class AdressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Street of adress needed of repassed")
	private String street;
	
	@NotNull()
	private long number;
	
	@NotBlank(message = "Neighborhood of adress needed of repassed")
	private String neighborhood;
	
	@NotBlank(message = "City of adress needed of repassed")
	private String city;
	
	@Deprecated
	public AdressEntity() {
		super();
	}

	public AdressEntity(@NotBlank(message = "Street of adress needed of repassed") String street,
			@NotNull() long number,
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

	public void setStreet(String street) {
		this.street = street;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Adress [id=" + id + ", street=" + street + ", number=" + number + ", neighborhood=" + neighborhood
				+ ", city=" + city + "]";
	}
	
}
