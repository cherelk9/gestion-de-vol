package org.example;

import org.example.service.utilisateur.controller.UserController;
import org.example.service.utilisateur.exception.InvalidInsertion;
import org.example.service.utilisateur.exception.UserNotFoundException;
import org.example.service.utilisateur.model.Gender;
import org.example.service.utilisateur.model.User;
import org.example.service.utilisateur.utils.UserUtils;
import org.example.service.vols.controller.CompagnyController;
import org.example.service.vols.dto.VolDto;
import org.example.service.vols.model.Compagnie;
import org.example.service.vols.model.TypeOfVol;
import org.example.service.vols.model.Vol;


import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {



    public static void main(String[] args) throws EOFException {

        CompagnyController compagnyController = new CompagnyController();

        Compagnie compagnie = new Compagnie(
                "5",
                "aire france",
                6
        );

        Vol vol = new Vol(
                "3",
                4,
                "france",
                LocalDateTime.now(),
                new Date(),
                TypeOfVol.NUIT,
                400,
                compagnie.getId()
        );

        VolDto v = vol.createVol(vol);

        UserController controller = new UserController();
        var file = new File(new UserUtils().MY_FILE);
        User user1 = new User(
                "1",
                "elembe",
                "lionel",
                26,
                "lionel.cherel@gmail.com",
                "652928749",
                Gender.MALE,
                vol.getId(),
                compagnie.getId()
        );

        User user2 = new User(
                "2",
                "mbessa",
                "marceline",
                60,
                "marceline.merveille@gmail.com",
                "677547403",
                Gender.FEMALE,
                vol.getId(),
                compagnie.getId()
        );



            try {

                BufferedInputStream inputStream;
                if (file.exists() ){
                    controller.sign(user1);
                    controller.printProfil(user1);
                    controller.sign(user2);
                    controller.printProfil(user2);
                    compagnyController.creerVol(v);
                    compagnyController.getUserByVol(v, vol.getId());
                }



            } catch (IOException | InvalidInsertion | UserNotFoundException e
        ) {
                throw new EOFException();
            }

    }
}