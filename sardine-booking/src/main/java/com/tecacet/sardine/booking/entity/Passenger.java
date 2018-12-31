package com.tecacet.sardine.booking.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Passenger {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
    
    private String firstName;
    private String lastName;
    private String gender;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BOOKING_ID")
    @JsonIgnore
    private BookingRecord bookingRecord;

	public Passenger(String firstName, String lastName, String gender,BookingRecord bookingRecord ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.bookingRecord= bookingRecord;
	}

}
