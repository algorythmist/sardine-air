package com.tecacet.sardine.booking.component;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.tecacet.sardine.booking.entity.BookingRecord;
import com.tecacet.sardine.booking.entity.BookingStatus;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingComponentTest {

    @Autowired
    private BookingComponent bookingComponent;

    @Test(expected = BookingException.class)
    public void updateStatus_noSuchId() {
        bookingComponent.updateStatus(BookingStatus.BOOKING_CONFIRMED, 10L);
    }

    @Test
    public void book() {
        BookingRecord record = new BookingRecord("SA-101", "SFO", "GBP", LocalDate.of(2019,2,12),
                LocalDateTime.now(), BigDecimal.valueOf(1000.11));
        bookingComponent.book(record);
    }
}
