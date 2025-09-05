package org.example.service.utilisateur.model;

import java.io.Serializable;

public class User implements Serializable {

    private final String id;
    private final String name;
    private final String surname;
    private final String email;
    private final String phone;
    private final Gender gender;

    public User(String id, String name, String surname, String email, String phone, Gender gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
    }

    public String getId() {return id;}
    public Gender getGender() {return gender;}
    public String getPhone() {return phone;}
    public String getEmail() {return email;}
    public String getSurname() {return surname;}
    public String getName() {return name;}
}
