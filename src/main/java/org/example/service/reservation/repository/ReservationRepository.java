package org.example.service.reservation.repository;

import org.example.service.reservation.model.Reservation;
import org.example.service.reservation.model.TypeOfReservation;

import java.io.IOException;
import java.util.Optional;

public interface ReservationRepository {

    void createReservation(String userId, String compagnyId, TypeOfReservation typeOfReservation) throws IOException;
    Reservation updateReservation(Reservation reservation) throws IOException;
    void deleteReservation(String userId, String reservationId) throws IOException;
    Optional<Reservation> findReservationById(String reservationId) throws IOException;

}
