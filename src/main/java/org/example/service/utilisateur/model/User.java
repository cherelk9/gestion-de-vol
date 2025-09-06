package org.example.service.utilisateur.model;

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

    private final String volId; // foreign key of vol
    private final String compagnyId;



    public User(
            String id,
            String name,
            String surname,
            int age,
            String email,
            String phone,
            Gender gender,
            String volId,
            String compagnyId) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
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

    public User createUser(
            String id,
            String name,
            String surname,
            int age,
            String email,
            String phone,
            Gender gender,
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
                            volId,
                            compagnyId
                    )
            );
        }
        return null;
    }

    @Override
    public String toString() {
        return "User{" +
                "compagnyId='" + new Compagnie().getId() + '\'' +
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
