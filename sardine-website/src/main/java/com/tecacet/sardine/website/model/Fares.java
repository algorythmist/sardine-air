package com.tecacet.sardine.website.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Fares {

   	private long id;
    private String fare;
    private String currency;
    
	public Fares(String fare,String currency) {
		super();
		this.fare = fare;
		this.currency = currency;
	}

}
