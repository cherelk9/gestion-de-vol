package org.example.service.utilisateur.utils;

import org.example.service.utilisateur.model.User;

import java.io.Serializable;

public class UserUtils implements Serializable {

    public String FILE_NOT_CONTAIN_USER = "file no contain user";

    public String FILE_NOT_FOUND() {
        return "file not found !";
    }

    public String MY_FILE = "user.txt";


}
