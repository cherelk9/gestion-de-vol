package org.example.service.utilisateur.service;

import org.example.service.utilisateur.model.User;
import org.example.service.utilisateur.repository.UserRepository;
import org.example.service.utilisateur.utils.UserUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements UserRepository {

    private final File file = new File(new UserUtils().MY_FILE);

    private  void addUser(User user) throws IOException {
        if (!file.exists())
            throw new FileNotFoundException(new UserUtils().FILE_NOT_FOUND());

        try (var ob = new ObjectOutputStream(
                new BufferedOutputStream( new FileOutputStream(file))
        )){

            ob.writeObject(new User(
                    user.getId(),
                    user.getName(),
                    user.getSurname(),
                    user.getAge(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getGender()
            ));


            System.out.println(" use " + user.getName()+ " is save correctly !");
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

        } catch (IOException e){
            reinitializeFile();
            return false;
        }
        catch (ClassNotFoundException e) {
            throw new IOException("format de fichier invalide", e);
        }
    }

    private  List<User> getAllUser() throws IOException{
        if (!file.exists())
            throw new FileNotFoundException(new UserUtils().FILE_NOT_FOUND());

        try (var ob = new ObjectInputStream(
                new BufferedInputStream( new FileInputStream( new UserUtils().MY_FILE))
        )){

            Object userObject = ob.readObject();

            if (userObject instanceof List<?>)
            {
                @SuppressWarnings("unchecked")
                List<User> users = (List<User>) userObject;

                return users;
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        return new ArrayList<>();
    }

    @Override
    public User profil(User user) throws IOException {

        if (!file.exists())
            throw new FileNotFoundException(new UserUtils().FILE_NOT_FOUND());

        List<User> users = getAllUser();

        return users.stream().reduce(user, (u,v)->{
            assert u != null;
            if (!(u.getName().equals(user.getName()) && u.getAge()== user.getAge()))
                return null;
            return u;
        });
    }


    public void reinitializeFile() throws IOException {
        // Crée un nouveau fichier avec une structure valide
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new UserUtils().MY_FILE))) {
            oos.writeObject(new ArrayList<User>()); // Écrit une liste vide
        }
    }
}
