package org.example;

import org.example.service.utilisateur.controller.UserController;
import org.example.service.utilisateur.model.Gender;
import org.example.service.utilisateur.model.User;
import org.example.service.utilisateur.utils.UserUtils;

import java.io.File;
import java.io.IOException;

public class Main {



    public static void main(String[] args) throws IOException {

        UserController controller = new UserController();

        User user1 = new User(
                "1",
                "elembe",
                "lionel",
                26,
                "lionel.cherel@gmail.com",
                "652928749",
                Gender.MALE
        );


            try {
                if (new File(new UserUtils().MY_FILE).exists()){
                    controller.sign(user1);
                    controller.printProfil(user1);
                }




            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }
}