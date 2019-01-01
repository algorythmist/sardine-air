package com.tecacet.sardine.booking.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Passenger {

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOKING_ID")
    @JsonIgnore
    private BookingRecord bookingRecord;

    public Passenger(String firstName, String lastName, Gender gender, BookingRecord bookingRecord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.bookingRecord = bookingRecord;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Passenger)) {
            return false;
        }
        Passenger passenger = (Passenger)other;
        return this.firstName.equals(passenger.firstName) &&
                this.lastName.equals(passenger.lastName) &&
                this.gender == passenger.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, gender);
    }
}
