package org.example.service.utilisateur.dto;

import org.example.service.utilisateur.model.Gender;

import java.io.Serializable;

public class UserDto implements Serializable {

    private  String id;
    private  String name;
    private  String surname;
    private  String email;
    private  String phone;
    private  Gender gender;
    private  int age;

    public UserDto() {}

    public UserDto(int age, Gender gender, String phone, String email, String surname, String name, String id) {
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.surname = surname;
        this.name = name;
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
