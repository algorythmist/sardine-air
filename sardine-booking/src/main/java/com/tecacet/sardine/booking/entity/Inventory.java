package com.tecacet.sardine.booking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Inventory {

    private static final int INVENTORY_BUFFER = 5;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
    
    private String flightNumber;
    private String flightDate;
    private int available;
    
    public Inventory(String flightNumber, String flightDate, int available) {
		super();
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.available = available;
	}

    public int getBookableInventory(){
        return available - INVENTORY_BUFFER;
    }

    public boolean isAvailable(int count){
        return (available-count > INVENTORY_BUFFER);
    }
}
