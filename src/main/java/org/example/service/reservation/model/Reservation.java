package org.example.service.reservation.model;

import java.io.Serial;
import java.io.Serializable;

/**
 * reservation (
 * ...
 * user_id : string
 * compagny_id : string
 * foreign key compagny_id, user_id reference compagny(id), User(id);
 * )
 *
 */

public class Reservation implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private  String id;
    private String compagnyId;
    private int numberOfReservation;
    private TypeOfReservation typeOfReservation;

    public Reservation(){}

    public Reservation(
            String id,
            String compagnyId,
           // String userId,
            int numberOfReservation,
            TypeOfReservation typeOfReservation) {
        this.id = id;
        this.compagnyId = compagnyId;
        this.numberOfReservation = numberOfReservation;
        this.typeOfReservation = typeOfReservation;
    }

    public String getId() {return id;}
    public String getCompagnyId() {return compagnyId;}
    public int getNumberOfReservation() {return numberOfReservation;}
    public TypeOfReservation getTypeOfReservation() {return typeOfReservation;}

    public void setTypeOfReservation(TypeOfReservation typeOfReservation) {this.typeOfReservation = typeOfReservation;}
    public void setCompagnyId(String compagnyId) {this.compagnyId = compagnyId;}
    public void setNumberOfReservation(int numberOfReservation) {this.numberOfReservation = numberOfReservation;}
}
