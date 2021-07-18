package br.com.ufc.web.purchaselist.config;

import java.math.BigInteger;
import java.security.MessageDigest;

public class PasswordCryptograf {

	public static String endocePassword (String password) {
		String response = "";
		MessageDigest messageDigest;
		
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			BigInteger hash = new BigInteger(1, messageDigest.digest(password.getBytes()));
			
			response = hash.toString(16);
		} catch(Exception e) {
			return null;
		}
		
		return response;
	}
	
}
