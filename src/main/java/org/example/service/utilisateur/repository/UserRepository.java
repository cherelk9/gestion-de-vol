package org.example.service.utilisateur.repository;

import org.example.service.utilisateur.model.User;

import java.io.IOException;

public interface UserRepository {
    void inscription(User user) throws IOException;
    boolean login(User user) throws IOException;
    User profil(User user) throws IOException;
}
