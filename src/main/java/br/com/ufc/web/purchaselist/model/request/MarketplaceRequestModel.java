package br.com.ufc.web.purchaselist.model.request;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import br.com.ufc.web.purchaselist.entity.AdressEntity;
import br.com.ufc.web.purchaselist.entity.MarketplaceEntity;
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
	
	public MarketplaceEntity toModel(AdressEntity adress) {
		return new MarketplaceEntity(this.getName(), adress);
	}

	@Override
	public String toString() {
		return "MarketplaceRequestModel [name=" + name + ", idAdress=" + idAdress + "]";
	}
			
}
