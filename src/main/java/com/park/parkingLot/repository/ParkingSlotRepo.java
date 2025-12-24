package com.park.parkingLot.repository;

import com.park.parkingLot.entity.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingSlotRepo extends JpaRepository<ParkingSlot,Long> {

    Optional<ParkingSlot> findFirstBySupportedVehicleTypeAndOccupiedFalse(String type);

    Optional<ParkingSlot> findBySlotNo(int slotNo);


}
