package org.example.service.utilisateur.model;

import org.example.service.reservation.model.Reservation;
import org.example.service.reservation.model.TypeOfReservation;
import org.example.service.utilisateur.dto.UserDto;
import org.example.service.utilisateur.utils.UserUtils;
import org.example.service.vols.model.Compagnie;
import org.example.service.vols.model.Vol;

import java.io.*;

public class User implements Serializable {

    @Serial
    private static  final long serialVersionUID = 1L;

    private final UserUtils Utils = new UserUtils();

    private final File file = new File(Utils.MY_FILE);

    private final String id;
    private final String name;
    private final String surname;
    private final String email;
    private final String phone;
    private final Gender gender;
    private final int age;
    private  String reservationId;
    private int nReservation;
    private TypeOfReservation typeOfReservation;

    private String volId; // foreign key of vol
    private final String compagnyId;



    public User(
            String id,
            String name,
            String surname,
            int age,
            String email,
            String phone,
            Gender gender,
            String reservationId,
            int nReservation,
            TypeOfReservation tReservation,
            String volId,
            String compagnyId) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
        this.reservationId = reservationId;
        this.nReservation = nReservation;
        this.typeOfReservation = tReservation;
        this.volId = volId;
        this.compagnyId = compagnyId;
    }


    public String getId() {return id;}
    public Gender getGender() {return gender;}
    public String getPhone() {return phone;}
    public String getEmail() {return email;}
    public String getSurname() {return surname;}
    public String getName() {return name;}
    public int getAge() {return age;}
    public String getVolId() {return volId;}
    public String getCompagnyId() {return compagnyId;}
    public String getReservationId() {return reservationId;}
    public int getnReservation() {return nReservation;}
    public TypeOfReservation getTypeOfReservation() {return typeOfReservation;}

    public void setnReservation(int nReservation) {this.nReservation = nReservation;}
    public void setTypeOfReservation(TypeOfReservation typeOfReservation) {this.typeOfReservation = typeOfReservation;}
    public void setReservationId(String reservationId) {this.reservationId = reservationId;}
    public void setVolId(String volId) {this.volId = volId;}

    public User createUser(
            String id,
            String name,
            String surname,
            int age,
            String email,
            String phone,
            Gender gender,
            String reservationId,
            int nReservation,
            TypeOfReservation typeOfReservation,
            String volId,
            String compagnyId
    ) throws IOException {

        if (!file.exists())
            throw new FileNotFoundException(new UserUtils().FILE_NOT_FOUND());

        try (var ob = new ObjectOutputStream(
                new BufferedOutputStream( new FileOutputStream(file))
        )) {
            ob.writeObject(
                    new User(
                            id,
                            name,
                            surname,
                            age,
                            email,
                            phone,
                            gender,
                            reservationId,
                            nReservation,
                            typeOfReservation,
                            volId,
                            compagnyId
                    )
            );
        }
        return null;
    }

    /*
    *      int age,
            Gender gender,
            String phone,
            String email,
            String surname,
            String name,
            String id
    * */

    public UserDto createUserDto(User user) {
        return new UserDto(
                user.getAge(),
                user.getGender(),
                user.getPhone(),
                user.getEmail(),
                user.getSurname(),
                user.getName(),
                user.getId()
        );
    }

    @Override
    public String toString() {
        return "User{" +
                "compagnyId='" + new Compagnie().getId() + '\'' +
                "numero de reservation "+ new Reservation().getNumberOfReservation()+ '\''+
                "type of reservation " + new Reservation().getTypeOfReservation()+'\''+
                ", volId='" + new Vol().getId() + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
