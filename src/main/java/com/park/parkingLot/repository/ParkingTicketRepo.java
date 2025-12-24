package com.park.parkingLot.repository;

import com.park.parkingLot.entity.ParkingTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingTicketRepo extends JpaRepository<ParkingTicket,Long> {


    Optional<ParkingTicket> findByVehicleNoAndActiveTrue(String vehicleNo);

}
