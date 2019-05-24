package com.tecacet.sardine.checkin.component;

import com.tecacet.sardine.checkin.entity.CheckInRecord;
import com.tecacet.sardine.checkin.repository.CheckinRepository;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class CheckinComponent {

    private final CheckinRepository checkinRepository;
    private final Sender sender;


    public long checkIn(CheckInRecord checkIn) {
        checkIn.setCheckInTime(LocalDateTime.now());
        log.info("Saving checkin ");
        //save
        long id = checkinRepository.save(checkIn).getId();
        log.info("Successfully saved checkin ");
        //send a message back to booking to update status
        log.info("Sending booking id " + id);
        sender.send(id);
        return id;
    }

}	
