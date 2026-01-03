package com.park.parkingLot.controller;


import com.park.parkingLot.dto.ParkRequest;
import com.park.parkingLot.dto.ParkingTicketResponse;
import com.park.parkingLot.entity.ParkingTicket;
import com.park.parkingLot.service.ParkingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ParkingController {

    private final ParkingService parkingService;


    private ParkingTicketResponse mapToResponse(ParkingTicket ticket) {

        ParkingTicketResponse response = new ParkingTicketResponse();

        response.setTicketId(ticket.getId());
        response.setVehicleNo(ticket.getVehicleNo());
        response.setSlotNo(ticket.getParkingSlot().getSlotNo());
        response.setAmount(ticket.getAmount());
        response.setEntryTime(ticket.getEntryTime());
        response.setExitTime(ticket.getExitTime());
        response.setActive(ticket.isActive());

        return response;
    }



    @PostMapping("/park")
    public ResponseEntity<ParkingTicketResponse> parkVehicle(@Valid @RequestBody ParkRequest parkRequest){



        ParkingTicket ticket = parkingService.parkVehicle(
                parkRequest.getVehicleNo(),
                parkRequest.getVehicleType(),
                parkRequest.getHours()
        );

        ParkingTicketResponse response = mapToResponse(ticket);

        return ResponseEntity.ok(response);


    }


    @PostMapping("/unpark/{vehicleNo}")
    public ResponseEntity<ParkingTicket> unpark(@PathVariable String vehicleNo) {
        return ResponseEntity.ok(parkingService.unParkVehicle(vehicleNo));
    }





}
