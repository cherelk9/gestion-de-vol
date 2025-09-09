package org.example.service.reservation.service;

import org.example.service.reservation.model.Reservation;
import org.example.service.reservation.model.TypeOfReservation;
import org.example.service.reservation.repository.ReservationRepository;
import org.example.service.reservation.utils.ReservationUtils;


import java.io.*;
import java.util.Optional;


public class ReservationService implements ReservationRepository {

    private final File file = new File(new ReservationUtils().RESERVATION_FILE);



    @Override
    public void createReservation(String userId, String compagnyId, TypeOfReservation typeOfReservation) throws IOException {

    }

    @Override
    public Reservation updateReservation(Reservation reservation) throws IOException {
        return null;
    }

    @Override
    public void deleteReservation(String userId, String reservationId) throws IOException {

    }

    @Override
    public Optional<Reservation> findReservationById(String reservationId) throws IOException {
        return Optional.empty();
    }
}
