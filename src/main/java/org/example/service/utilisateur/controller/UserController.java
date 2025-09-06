package org.example.service.utilisateur.controller;

import org.example.service.utilisateur.exception.InvalidInsertion;
import org.example.service.utilisateur.model.User;
import org.example.service.utilisateur.service.UserService;
import org.example.service.utilisateur.utils.UserUtils;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;



public class UserController {

    private static final UserUtils utils = new UserUtils();

    private static final File file = new File(utils.MY_FILE);

    private final UserService userService = new UserService() ;



    public void sign(User user) throws IOException, RuntimeException {
        if (!file.exists())
            throw new FileNotFoundException(utils.FILE_NOT_FOUND());

        try{
            if (!userService.login(user))
                userService.inscription(user);
            System.out.println("user " +user.getName()+ " have a compte !");

        }catch (EOFException e) {
            System.out.println("fichier corrompu ou vide ,  creation d'un nouveau fichier !");
        }

        catch (IOException e) {
            throw new RuntimeException("Erreur d'E/S" +e.getMessage());
        }
    }


    public void printProfil(User user) throws IOException, InvalidInsertion {
        if (!file.exists())
            throw new FileNotFoundException(new UserUtils().FILE_NOT_FOUND());

        User oldUser = userService.profil(user);

        if (!userService.login(oldUser))
        {
            System.out.println( oldUser.getName()+ " do not have profils ");
            System.out.println("do you want to create a count ? y/n");

            var scr = new Scanner(System.in);

            if (scr.next().equals("N") || scr.next().equals("n"))
                return;
            else if (scr.next().equals("y") || scr.next().equals("Y")) {
                userService.inscription(oldUser);
                System.out.println("ok !");
            }else {
                throw new InvalidInsertion("insert correct answer !");
            }
        }

        User newUser = (oldUser !=null) ? oldUser : user ;

        System.out.println(
                "name : " +newUser.getName()+
                "\nsurname :" +newUser.getSurname()+
                "\nphone :" +newUser.getPhone()+
                "\nemail :" +newUser.getEmail()+
                "\ngender :" +user.getGender()
        );
    }
}


