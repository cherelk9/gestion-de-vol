package org.example.service.utilisateur.controller;

import org.example.service.utilisateur.exception.InvalidInsertion;
import org.example.service.utilisateur.model.User;
import org.example.service.utilisateur.service.UserService;
import org.example.service.utilisateur.utils.UserUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UserController {

    private final UserUtils utils = new UserUtils();

    private final File file = new File(utils.MY_FILE);

    private final UserService userService;

    public UserController() {
        userService = new UserService();
    }

    public void sign(User user) throws IOException {
        if (!file.exists())
            throw new FileNotFoundException(utils.FILE_NOT_FOUND());

        try {
            if (!userService.login(user))
                userService.inscription(user);
            System.out.println("l'utilisateur " +user.getName()+ " a deja un compte !");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printProfil(User user) throws IOException {
        if (!file.exists())
            throw new FileNotFoundException(utils.FILE_NOT_FOUND());

        try {
            if (userService.login(user)){
                User userProfil = userService.profil(user);
                System.out.println(userProfil.toString());

            }


            System.out.println("cet utilisateur n'a pas de compte! ");
            System.out.println("voulez vous créer un compte ? n/y");

            var scr = new Scanner(System.in);

            switch (scr.next()) {
                case "N", "n"-> {
                    break;
                }
                case "Y","y" -> {
                    userService.inscription(user);
                }
                default -> throw new InvalidInsertion(" vous avez entre la mauvaise valeur");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
