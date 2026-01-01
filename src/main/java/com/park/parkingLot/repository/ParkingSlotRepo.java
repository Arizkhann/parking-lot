package com.park.parkingLot.repository;

import com.park.parkingLot.entity.ParkingSlot;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ParkingSlotRepo extends JpaRepository<ParkingSlot,Long> {

    Optional<ParkingSlot> findFirstBySupportedVehicleTypeAndOccupiedFalse(String type);

    Optional<ParkingSlot> findBySlotNo(int slotNo);


    //

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
        SELECT s FROM ParkingSlot s
        WHERE s.supportedVehicleType = :type
          AND s.occupied = false
    """)
    Optional<ParkingSlot> findFreeSlotWithLock(
            @Param("type") String type
    );





}
