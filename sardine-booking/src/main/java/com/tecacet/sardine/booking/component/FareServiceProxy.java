package com.tecacet.sardine.booking.component;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name="fares-proxy")
@RibbonClient(name="fares")
public interface FareServiceProxy {

    @RequestMapping(value="fares/get", method = RequestMethod.GET)
    Fare getFare(@RequestParam(value="flightNumber") String flightNumber,
                 @RequestParam(value = "flightDate") String flightDate);
}
