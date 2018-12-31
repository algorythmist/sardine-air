package com.tecacet.sardine.search.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
    
    private int count;

	public Inventory(int count) {
		super();
		this.count = count;
	}

}
