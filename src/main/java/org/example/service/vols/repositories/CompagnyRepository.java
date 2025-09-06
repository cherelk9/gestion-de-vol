package org.example.service.vols.repositories;

import org.example.service.utilisateur.exception.UserNotFoundException;
import org.example.service.utilisateur.model.User;
import org.example.service.vols.dto.VolDto;
import org.example.service.vols.model.Vol;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Stream;

public interface CompagnyRepository {

    void createVol(VolDto vol) throws IOException;
    void getUserByVol(String userId, Vol vol) throws IOException, UserNotFoundException;
    void getUsersByVol(Vol vol) throws IOException;
    void getAllVol() throws IOException;
    void getAllUsers() throws IOException;

}
