package br.com.ufc.web.purchaselist.model.request;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.ufc.web.purchaselist.entity.AdressModel;
import br.com.ufc.web.purchaselist.entity.MarketplaceModel;
//import br.com.ufc.web.purchaselist.entity.UserModel;

public class MarketplaceRequestModel {
	
	@NotBlank(message = "Name needed of repassed")
	private String name;
	
//	@NotNull()
//	private long idUser;
	
	@NotNull()
	private long idAdress;
	
	@Deprecated
	public MarketplaceRequestModel() {
		super();
	}

	public MarketplaceRequestModel(@NotBlank(message = "Name needed of repassed") String name,
			long idAdress) {
		super();
		this.name = name;
//		this.idUser = idUser;
		this.idAdress = idAdress;
	}

	public String getName() {
		return name;
	}

//	public long getIdUser() {
//		return idUser;
//	}

	public long getIdAdress() {
		return idAdress;
	}
	
	public MarketplaceModel toModel(AdressModel adress) {
		return new MarketplaceModel(this.getName(), adress);
	}

	@Override
	public String toString() {
		return "MarketplaceRequestModel [name=" + name + ", idAdress=" + idAdress + "]";
	}
			
}
