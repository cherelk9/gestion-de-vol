package org.example.service.vols.repositories;

import org.example.service.utilisateur.exception.UserNotFoundException;
import org.example.service.vols.dto.VolDto;
import org.example.service.vols.model.Vol;

import java.io.File;
import java.io.IOException;


public interface CompagnyRepository {

    void createVol(VolDto vol) throws IOException;
    void getUserByVol(String userId, Vol vol) throws IOException, UserNotFoundException;
    void getUsersByVol(Vol vol) throws IOException;
    void getAllVol() throws IOException;
    void getAllUsers() throws IOException;

    void getAllReservation(File fileReservation) throws IOException;

}
