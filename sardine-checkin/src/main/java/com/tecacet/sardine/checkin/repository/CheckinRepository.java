package com.tecacet.sardine.checkin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tecacet.sardine.checkin.entity.CheckInRecord;

public interface CheckinRepository extends JpaRepository<CheckInRecord, Long> {

}
