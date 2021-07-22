package br.com.ufc.web.purchaselist.model.request;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.ufc.web.purchaselist.entity.AdressEntity;
import br.com.ufc.web.purchaselist.entity.MarketplaceEntity;
//import br.com.ufc.web.purchaselist.entity.UserModel;

public class MarketplaceRequestModel {
	
	@NotBlank(message = "Name needed of repassed")
	private String name;
	
	@NotBlank(message = "Name needed of repassed")
	private String initial;
	
//	@NotNull()
//	private long idUser;
	
	@NotNull()
	private long idAdress;
	
	@Deprecated
	public MarketplaceRequestModel() {
		super();
	}

	public MarketplaceRequestModel(@NotBlank(message = "Name needed of repassed") String name,
			@NotBlank(message = "Initial needed of repassed") String initial, long idAdress) {
		super();
		this.name = name;
//		this.idUser = idUser;
		this.initial = initial;
		this.idAdress = idAdress;
	}

	public String getName() {
		return name;
	}

//	public long getIdUser() {
//		return idUser;
//	}
	
	public String getInitial() {
		return initial;
	}

	public long getIdAdress() {
		return idAdress;
	}

	public MarketplaceEntity toModel(AdressEntity adress) {
		return new MarketplaceEntity(this.getName(), this.getInitial(), adress);
	}

	@Override
	public String toString() {
		return "MarketplaceRequestModel [name=" + name + ", initial=" + initial + ", idAdress=" + idAdress + "]";
	}
			
}
