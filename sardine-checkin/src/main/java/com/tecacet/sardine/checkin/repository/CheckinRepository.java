package com.tecacet.sardine.checkin.repository;

import com.tecacet.sardine.checkin.entity.CheckInRecord;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckinRepository extends JpaRepository<CheckInRecord, Long> {

}
