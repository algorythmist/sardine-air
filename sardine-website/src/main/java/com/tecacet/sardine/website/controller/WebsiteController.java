package com.tecacet.sardine.website.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tecacet.sardine.website.model.BookingRecord;
import com.tecacet.sardine.website.model.CheckInRecord;
import com.tecacet.sardine.website.model.Fares;
import com.tecacet.sardine.website.model.Flight;
import com.tecacet.sardine.website.model.Passenger;
import com.tecacet.sardine.website.service.SardineFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequiredArgsConstructor
@Slf4j
public class WebsiteController {

    private final SardineFacade sardineFacade;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greetingForm(Model model) {
        SearchQuery query = new SearchQuery("NYC", "SFO", "2016-01-22");
        UIData uiData = new UIData();
        uiData.setSearchQuery(query);
        model.addAttribute("uidata", uiData);
        return "search";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String greetingSubmit(@ModelAttribute UIData uiData, Model model) {
        Flight[] flights = sardineFacade.getFlights(uiData.getSearchQuery());
        uiData.setFlights(Arrays.asList(flights));
        model.addAttribute("uidata", uiData);
        return "result";
    }

    @RequestMapping(value = "/book/{flightNumber}/{origin}/{destination}/{flightDate}/{fare}", method = RequestMethod.GET)
    public String bookQuery(@PathVariable String flightNumber,
                            @PathVariable String origin,
                            @PathVariable String destination,
                            @PathVariable String flightDate,
                            @PathVariable String fare,
                            Model model) {
        UIData uiData = new UIData();
        Flight flight = new Flight(flightNumber, origin, destination, flightDate, new Fares(fare, "AED"));
        uiData.setSelectedFlight(flight);
        uiData.setPassenger(new Passenger());
        model.addAttribute("uidata", uiData);
        return "book";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public String confirmBooking(@ModelAttribute UIData uiData, Model model) {
        Flight flight = uiData.getSelectedFlight();
        BookingRecord booking = new BookingRecord(flight.getFlightNumber(), flight.getOrigin(),
                flight.getDestination(), flight.getFlightDate(), null,
                flight.getFares().getFare());
        Set<Passenger> passengers = new HashSet<Passenger>();
        Passenger pax = uiData.getPassenger();
        pax.setBookingRecord(booking);
        passengers.add(uiData.getPassenger());
        booking.setPassengers(passengers);
        long bookingId = 0;
        try {
            bookingId = sardineFacade.submitBooking(booking);
            log.info("Booking created " + bookingId);
        } catch (Exception e) {
            log.error("BOOKING SERVICE NOT AVAILABLE...!!!");
        }
        model.addAttribute("message", "Your Booking is confirmed. Reference Number is " + bookingId);
        return "confirm";
    }

    @RequestMapping(value = "/search-booking", method = RequestMethod.GET)
    public String searchBookingForm(Model model) {
        UIData uiData = new UIData();
        uiData.setBookingid("5");
        model.addAttribute("uidata", uiData);
        return "bookingsearch";
    }

    @RequestMapping(value = "/search-booking-get", method = RequestMethod.POST)
    public String searchBookingSubmit(@ModelAttribute UIData uiData, Model model) {
        Long id = new Long(uiData.getBookingid());
        BookingRecord booking = sardineFacade.findBooking(id);
        Flight flight = new Flight(booking.getFlightNumber(), booking.getOrigin(), booking.getDestination()
                , booking.getFlightDate(), new Fares(booking.getFare(), "AED"));
        Passenger pax = booking.getPassengers().iterator().next();
        Passenger paxUI = new Passenger(pax.getFirstName(), pax.getLastName(), pax.getGender(), null);
        uiData.setPassenger(paxUI);
        uiData.setSelectedFlight(flight);
        uiData.setBookingid(id.toString());
        model.addAttribute("uidata", uiData);
        return "bookingsearch";
    }

    @RequestMapping(value = "/checkin/{flightNumber}/{origin}/{destination}/{flightDate}/{fare}/{firstName}/{lastName}/{gender}/{bookingid}", method = RequestMethod.GET)
    public String bookQuery(@PathVariable String flightNumber,
                            @PathVariable String origin,
                            @PathVariable String destination,
                            @PathVariable String flightDate,
                            @PathVariable String fare,
                            @PathVariable String firstName,
                            @PathVariable String lastName,
                            @PathVariable String gender,
                            @PathVariable String bookingid,
                            Model model) {


        CheckInRecord checkIn = new CheckInRecord(firstName, lastName, "28C", null,
                flightDate, flightDate, new Long(bookingid).longValue());

        long checkinId = sardineFacade.createCheckIn(checkIn);
        model.addAttribute("message", "Checked In, Seat Number is 28c , checkin id is " + checkinId);
        return "checkinconfirm";
    }

}
