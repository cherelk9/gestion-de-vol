package org.example.service.vols.model;

import org.example.service.utilisateur.model.User;
import org.example.service.vols.dto.VolDto;

import java.io.Serializable;

public record UserByVol(VolDto vol, User user) implements Serializable {}
