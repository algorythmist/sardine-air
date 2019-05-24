package com.tecacet.sardine.booking.component;

import static org.junit.Assert.assertTrue;

import com.tecacet.sardine.booking.entity.BookingRecord;
import com.tecacet.sardine.booking.entity.BookingStatus;
import com.tecacet.sardine.booking.entity.Inventory;
import com.tecacet.sardine.booking.entity.Passenger;
import com.tecacet.sardine.booking.repository.InventoryRepository;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.transaction.Transactional;

@Ignore
//TODO: This requires fares service to be running
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingComponentTest {

    @Autowired
    private BookingComponent bookingComponent;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Test(expected = BookingException.class)
    public void updateStatus_noSuchId() {
        bookingComponent.updateStatus(BookingStatus.BOOKING_CONFIRMED, 10L);
    }

    @Test(expected = BookingException.class)
    public void book_fareChanged() {
        LocalDate date = LocalDate.of(2016, 1, 22);
        BookingRecord record = new BookingRecord("SA-101", "SFO", "GBP", date, LocalDateTime.now(), BigDecimal.valueOf(1000.11));
        bookingComponent.book(record);
    }

    @Test
    @Transactional
    public void book() {
        LocalDate date = LocalDate.of(2016, 1, 22);
        Inventory inventory = new Inventory("SA-101", date, 10);
        inventoryRepository.save(inventory);

        BookingRecord record = new BookingRecord("SA-101", "SFO", "GBP", date, LocalDateTime.now(), BigDecimal.valueOf(101));
        record.addPassenger("John", "Muir", Passenger.Gender.OTHER);

        long id = bookingComponent.book(record);
        assertTrue(id > 0);
    }
}
