package com.park.parkingLot.service;


import com.park.parkingLot.entity.ParkingSlot;
import com.park.parkingLot.entity.ParkingTicket;
import com.park.parkingLot.exception.ActiveTicketNotFoundException;
import com.park.parkingLot.exception.SlotNotAvailableException;
import com.park.parkingLot.repository.ParkingSlotRepo;
import com.park.parkingLot.repository.ParkingTicketRepo;
import com.park.parkingLot.strategy.PricingStrategy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ParkingService {

    private final ParkingSlotRepo parkingSlotRepo;
    private  final ParkingTicketRepo parkingTicketRepo;
    private final PricingStrategy pricingStrategy;

    @Transactional
    public ParkingTicket parkVehicle(String vehicleNo, String vehicleType,int hours){

        ParkingSlot slot=parkingSlotRepo.findFreeSlotWithLock(vehicleType).orElseThrow(()-> new SlotNotAvailableException("No slot available "));

        slot.setOccupied(true);
        parkingSlotRepo.save(slot);

        double amount=pricingStrategy.calculatedPrice(vehicleType,hours);

        ParkingTicket parkingTicket=new ParkingTicket();

        parkingTicket.setVehicleNo(vehicleNo);
        parkingTicket.setHours(hours);
        parkingTicket.setAmount(amount);
        parkingTicket.setEntryTime(LocalDateTime.now());
        parkingTicket.setActive(true);

        parkingTicket.setParkingSlot(slot);

        return parkingTicketRepo.save(parkingTicket);

    }


    //unpark vehicle

    @Transactional
    public ParkingTicket unParkVehicle(String vehicleNo){

        ParkingTicket ticket=parkingTicketRepo.findByVehicleNoAndActiveTrue(vehicleNo).orElseThrow(()->new ActiveTicketNotFoundException("Active ticket not found for vehicle"+vehicleNo));

        ticket.setExitTime(LocalDateTime.now());
        ticket.setActive(false);

        //free the slot

        ParkingSlot slot=ticket.getParkingSlot();

        slot.setOccupied(false);
        parkingSlotRepo.save(slot);

        return  parkingTicketRepo.save(ticket);


    }





}
