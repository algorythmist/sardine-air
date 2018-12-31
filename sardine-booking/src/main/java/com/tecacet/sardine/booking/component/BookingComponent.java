package com.tecacet.sardine.booking.component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.tecacet.sardine.booking.entity.BookingRecord;
import com.tecacet.sardine.booking.entity.BookingStatus;
import com.tecacet.sardine.booking.entity.Inventory;
import com.tecacet.sardine.booking.entity.Passenger;
import com.tecacet.sardine.booking.repository.BookingRepository;
import com.tecacet.sardine.booking.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class BookingComponent {

    //TODO: configure
    private static final String FareURL = "http://localhost:8080/fares";

    private final BookingRepository bookingRepository;
    private final InventoryRepository inventoryRepository;
    private final Sender sender;
    private final RestTemplate restTemplate = new RestTemplate();

    public void updateStatus(BookingStatus status, long bookingId) {
        BookingRecord record = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new BookingException("No record matches id "+bookingId));
        record.setStatus(status);
    }

    public long book(BookingRecord record) {
        checkFare(record);
        Inventory inventory = getInventory(record);
        log.info("Updating inventory");
        //update inventory
        inventory.setAvailable(inventory.getAvailable() - record.getPassengers().size());
        inventoryRepository.saveAndFlush(inventory);
        log.info("successfully updated inventory");
        //save booking
        record.setStatus(BookingStatus.BOOKING_CONFIRMED);
        Set<Passenger> passengers = record.getPassengers();
        passengers.forEach(passenger -> passenger.setBookingRecord(record));
        record.setBookingDate(LocalDateTime.now());
        long id =  bookingRepository.save(record).getId();
        log.info("Successfully saved booking");

        //send a message to search to update inventory
        log.info("sending a booking event");
        Map<String, Object> bookingDetails = new HashMap<String, Object>();
        bookingDetails.put("FLIGHT_NUMBER", record.getFlightNumber());
        bookingDetails.put("FLIGHT_DATE", record.getFlightDate());
        bookingDetails.put("NEW_INVENTORY", inventory.getBookableInventory());
        sender.send(bookingDetails);
        log.info("booking event successfully delivered "+ bookingDetails);
        return id;
    }

    private Inventory getInventory(BookingRecord record) {
        Inventory inventory =
                inventoryRepository.findByFlightNumberAndFlightDate(record.getFlightNumber(),record.getFlightDate())
                .orElseThrow(() -> new BookingException("No inventory record"));
        if(!inventory.isAvailable(record.getPassengers().size())){
            throw new BookingException("No more seats available");
        }
        log.info("successfully checked inventory" + inventory);
        return inventory;
    }

    private void checkFare(BookingRecord record) {
        log.info("Calling fares to get fare");
        //call fares to get fare
        Fare fare = restTemplate.getForObject(FareURL +"/get?flightNumber="+record.getFlightNumber()+"&flightDate="+record.getFlightDate(),Fare.class);
        log.info("calling fares to get fare "+ fare);
        if (!record.getFare().equals(fare.getFare())) {
            throw new BookingException("fare is tampered");
        }
    }

}
