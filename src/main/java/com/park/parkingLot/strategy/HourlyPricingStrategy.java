package com.park.parkingLot.strategy;

import org.springframework.stereotype.Component;

@Component
public class HourlyPricingStrategy implements PricingStrategy{
    @Override
    public double calculatedPrice(String vehicleType, int hours) {
        return  hours * 50;
    }
}
