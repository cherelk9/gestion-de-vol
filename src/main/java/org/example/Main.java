package org.example;

import org.example.service.utilisateur.controller.UserController;
import org.example.service.utilisateur.exception.InvalidInsertion;
import org.example.service.utilisateur.model.Gender;
import org.example.service.utilisateur.model.User;
import org.example.service.utilisateur.utils.UserUtils;

import java.io.File;
import java.io.IOException;

public class Main {



    public static void main(String[] args)  {

        UserController controller = new UserController();
        var file = new File(new UserUtils().MY_FILE);
        User user1 = new User(
                "1",
                "elembe",
                "lionel",
                26,
                "lionel.cherel@gmail.com",
                "652928749",
                Gender.MALE
        );

        User user2 = new User(
                "2",
                "mbessa",
                "marceline",
                60,
                "marceline.merveille@gmail.com",
                "677547403",
                Gender.FEMALE
        );


            try {

                if (file.exists()){
                    controller.sign(user1);
                    controller.printProfil(user1);
                    controller.sign(user2);
                    controller.printProfil(user2);
                }



            } catch (IOException | InvalidInsertion e) {
                throw new RuntimeException(e);
            }

    }
}