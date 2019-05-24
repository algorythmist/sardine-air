package com.tecacet.sardine.checkin.controller;

import com.tecacet.sardine.checkin.component.CheckinComponent;
import com.tecacet.sardine.checkin.entity.CheckInRecord;
import com.tecacet.sardine.checkin.repository.CheckinRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequestMapping("/checkin")
@RequiredArgsConstructor
public class CheckInController {

    private final CheckinComponent checkInComponent;
    private final CheckinRepository checkinRepository;

    @RequestMapping("/get/{id}")
    CheckInRecord getCheckIn(@PathVariable long id) {
        return checkinRepository.getOne(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    long checkIn(@RequestBody CheckInRecord checkIn) {
        return checkInComponent.checkIn(checkIn);
    }

}
