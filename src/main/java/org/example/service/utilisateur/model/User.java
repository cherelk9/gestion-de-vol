package org.example.service.utilisateur.model;

import org.example.service.utilisateur.utils.UserUtils;

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

    public User(String id, String name, String surname, int age, String email, String phone, Gender gender) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
    }

    public String getId() {return id;}
    public Gender getGender() {return gender;}
    public String getPhone() {return phone;}
    public String getEmail() {return email;}
    public String getSurname() {return surname;}
    public String getName() {return name;}
    public int getAge() {return age;}

    public User createUser(
            String id,
            String name,
            String surname,
            int age,
            String email,
            String phone,
            Gender gender
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
                            gender
                    )
            );
        }
        return null;
    }

    public String toString() {
        return  " name :" +this.name +
                "\n surname :"+this.surname+ "\n age :"+ this.age + "\n phone  number :"
                +this.phone+ "\n email :" +this.email + "\n gender  :" +this.gender;
    }
}
