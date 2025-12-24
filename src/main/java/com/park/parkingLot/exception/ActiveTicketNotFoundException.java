package com.park.parkingLot.exception;

public class ActiveTicketNotFoundException extends RuntimeException {
    public ActiveTicketNotFoundException(String message) {
        super(message);
    }
}

