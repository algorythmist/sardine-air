package com.tecacet.sardine.booking.component;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.tecacet.sardine.booking.entity.BookingStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class Receiver {
	
	private final BookingComponent bookingComponent;

	//@RabbitListener(queues = "CheckINQ")
    public void processMessage(long bookingId ) {
		log.debug("Received booking id = {}", bookingId);
		bookingComponent.updateStatus(BookingStatus.CHECKED_IN, bookingId);
    }
	
}
