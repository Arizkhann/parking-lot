package com.park.parkingLot.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkRequest {

    private String vehicleNo;
    private String vehicleType;
    private int hours;

}
