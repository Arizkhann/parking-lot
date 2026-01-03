package com.park.parkingLot.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkingTicketResponse {

    private Long ticketId;
    private String vehicleNo;
    private int slotNo;
    private double amount;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private boolean active;

    // getters & setters
}
