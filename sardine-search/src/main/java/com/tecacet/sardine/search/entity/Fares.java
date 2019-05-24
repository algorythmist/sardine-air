package com.tecacet.sardine.search.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Fares {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private BigDecimal fare;
    private String currency;

    public Fares(String fare) {
        this(new BigDecimal(fare), "USD");
    }

    public Fares(BigDecimal fare, String currency) {
        this.fare = fare;
        this.currency = currency;
    }


}
