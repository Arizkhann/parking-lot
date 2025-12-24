package com.park.parkingLot.controller;


import com.park.parkingLot.dto.ParkRequest;
import com.park.parkingLot.entity.ParkingTicket;
import com.park.parkingLot.service.ParkingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ParkingController {

    private final ParkingService parkingService;

    @PostMapping("/park")
    public ResponseEntity<?> parkVehicle(@RequestBody ParkRequest parkRequest){

        return ResponseEntity.ok(parkingService.parkVehicle(parkRequest.getVehicleNo(),parkRequest.getVehicleType(),parkRequest.getHours()));

    }


    @PostMapping("/unpark/{vehicleNo}")
    public ResponseEntity<ParkingTicket> unpark(@PathVariable String vehicleNo) {
        return ResponseEntity.ok(parkingService.unParkVehicle(vehicleNo));
    }





}
