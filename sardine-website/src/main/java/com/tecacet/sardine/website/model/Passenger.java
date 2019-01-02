package com.tecacet.sardine.website.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Passenger {

    private long id;
    private String firstName;
    private String lastName;
    private String gender;

    @JsonIgnore
    private BookingRecord bookingRecord;

    public Passenger(String firstName, String lastName, String gender, BookingRecord bookingRecord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.bookingRecord = bookingRecord;
    }


}
