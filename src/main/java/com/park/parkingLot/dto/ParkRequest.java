package com.park.parkingLot.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParkRequest {

    @NotBlank(message = "Vehicle number cannot be empty")
    private String vehicleNo;

    @NotBlank(message = "Vehicle type is required")
    private String vehicleType;

    @NotNull(message = "Hours is required")
    @Min(value = 1, message = "Minimum parking duration is 1 hour")
    private Integer hours;

}
