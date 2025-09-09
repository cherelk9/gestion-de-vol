package org.example.service.reservation.model;

public enum TypeOfReservation {

    VIP("VIP"), ECO("économique"), BUSINESS ("business");
    private final String name;

    TypeOfReservation(String name) {
        this.name =name;
    }

    private String getName() {return name;}
}
