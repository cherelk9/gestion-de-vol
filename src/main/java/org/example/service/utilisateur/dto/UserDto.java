package org.example.service.utilisateur.dto;

import org.example.service.reservation.model.Reservation;
import org.example.service.utilisateur.model.Gender;
import org.example.service.utilisateur.model.User;
import org.example.service.vols.model.Compagnie;
import org.example.service.vols.model.Vol;

import java.io.Serial;
import java.io.Serializable;

public class UserDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private  String id;
    private  String name;
    private  String surname;
    private  String email;
    private  String phone;
    private  Gender gender;
    private  int age;

    public UserDto() {}

    public UserDto(
            int age,
            Gender gender,
            String phone,
            String email,
            String surname,
            String name,
            String id ) {

        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.surname = surname;
        this.name = name;
        this.id = id;
    }

    public int getAge() {return age;}
    public Gender getGender() {return gender;}
    public String getPhone() {return phone;}
    public String getEmail() {return email;}
    public String getSurname() {return surname;}
    public String getName() {return name;}
    public String getId() {return id;}
    public String getVolId() {return new Vol().getId();}

    /*
    *       String id,
            String name,
            String surname,
            int age,
            String email,
            String phone,
            Gender gender,
            String volId,
            String compagnyId
    * */

    public String getCompgnyId()  {return new Compagnie().getId();}

    public User createUser(UserDto user) {
        return new User(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getAge(),
                user.getEmail(),
                user.getPhone(),
                user.getGender(),
                new Reservation().getId(),
                new Reservation().getNumberOfReservation(),
                new Reservation().getTypeOfReservation(),
                user.getVolId(),
                user.getCompgnyId()
        );
    }

}
