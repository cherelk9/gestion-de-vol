package org.example.service.utilisateur.service;

import org.example.service.utilisateur.model.User;
import org.example.service.utilisateur.repository.UserRepository;
import org.example.service.utilisateur.utils.UserUtils;

import java.io.*;

public class UserService implements UserRepository {

    private static final File file = new File(new UserUtils().MY_FILE);

    private static void addUser(User user) throws IOException {
        if (!file.exists())
            throw new FileNotFoundException(new UserUtils().FILE_NOT_FOUND());

        try (var ob = new ObjectOutputStream(
                new BufferedOutputStream( new FileOutputStream(file))
        )){

            ob.writeObject(user.createUser(
                    user.getId(),
                    user.getName(),
                    user.getSurname(),
                    user.getAge(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getGender()
            ));


            System.out.println(" use " + user.getName()+ "is save correctly !");
        }
    }

    @Override
    public void inscription(User user) throws IOException {

        if (!file.exists())
            throw  new FileNotFoundException(new UserUtils().FILE_NOT_FOUND());
        try {
            addUser(user);
            System.out.println("inscription de "+user.getName()+ " effectue avec succès dans le fichier " +file.getName());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean login(User user) throws IOException {
        if (!file.exists())
            throw new FileNotFoundException(new UserUtils().FILE_NOT_FOUND());

        try (var ob = new ObjectInputStream(
                new BufferedInputStream( new FileInputStream( file ))
        )) {
            Object userObject = ob.readObject();

            if (userObject instanceof User newUserObject){

                return newUserObject.getName().equals(user.getName())
                        && newUserObject.getEmail().equals(user.getEmail());
            }
             return false;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User profil(User user) throws IOException {

        if (!file.exists())
            throw new FileNotFoundException(new UserUtils().FILE_NOT_FOUND());

        try (var ob = new ObjectInputStream(
                new BufferedInputStream( new FileInputStream(file))
        )){

            Object userObject = ob.readObject();

            if (userObject instanceof User newUserObject)
                return newUserObject;

            return null;

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
