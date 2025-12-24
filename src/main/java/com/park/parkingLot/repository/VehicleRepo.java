package com.park.parkingLot.repository;

import com.park.parkingLot.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle,Long> {
}
