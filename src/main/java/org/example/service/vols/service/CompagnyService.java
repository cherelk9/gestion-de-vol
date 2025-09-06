package org.example.service.vols.service;

import org.example.service.utilisateur.exception.UserNotFoundException;
import org.example.service.utilisateur.model.User;
import org.example.service.vols.dto.VolDto;
import org.example.service.vols.model.Vol;
import org.example.service.vols.repositories.CompagnyRepository;
import org.example.service.vols.utils.CompagnyUtils;

import java.io.*;
import java.util.List;


public class CompagnyService implements CompagnyRepository {

    private final File file = new File(new CompagnyUtils().MY_VOL_FILE);


    /*
     *     private final String id;
     *     private final int volNumber ;
     *     private final String destination;
     *     private final LocalDateTime heureDepart;
     *     private final Date dateVol;
     *     private TypeOfVol;
     *     private final int nombreDePlaces;
     *
     *     private final Compagnie = new Compagnie();
     *     private final Set<User>  users = new HashSet<>();
     * */


    /**
     * Pour creer un vol :
     *  on doit recuperer tous les vols en questions
     *  en suite connaitre toutes les personnes qui se trouvent dans le vol.
     * */

    @Override
    public void createVol(VolDto vol) throws IOException {
        if (!file.exists())
            throw new FileNotFoundException(new CompagnyUtils().FILE_COMPAGNY_NOT_FOUND);

        new Vol().addVol(vol);
    }
/**
 * fi
 * */
    @Override
    public void getUserByVol(String userId, Vol vol) throws IOException, UserNotFoundException {

        if (!file.exists())
            throw new FileNotFoundException(new CompagnyUtils().FILE_COMPAGNY_NOT_FOUND);

        User user = findUserByVol(vol, userId);
        if (user == null)
            throw new UserNotFoundException("user not found exception !");

        System.out.println(
                "name :"+user.getName()+"\nle numero de vol est :" +user.getVolId()
        );
    }

    @Override
    public void getUsersByVol(Vol vol) throws IOException {

        if (!file.exists())
            throw new FileNotFoundException(new CompagnyUtils().FILE_COMPAGNY_NOT_FOUND);

        try (var ob = new ObjectInputStream(
                new BufferedInputStream( new FileInputStream(file))
        )) {
            Object object = ob.readObject();

            if (object instanceof List<?> newUser)
            {
                @SuppressWarnings("unchecked")
                List<User> users = (List<User>) newUser;
                users.stream()
                        .filter(p->p.getVolId().contains(vol.getId()))
                        .forEach(p->System.out.println(
                                "name :" +p.getName()+
                                        "\nnumero de vol :" +p.getVolId()
                        ));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void getAllVol() throws IOException {

        if (!file.exists())
            throw new FileNotFoundException(new CompagnyUtils().FILE_COMPAGNY_NOT_FOUND);

        try (var ob = new ObjectInputStream(
                new BufferedInputStream( new FileInputStream(file))
        )) {

            Object object = ob.readObject();

            if (object instanceof List<?> newVol)
            {
                @SuppressWarnings("unchecked")
                        List<Vol> vols = (List<Vol>) newVol;

                vols.forEach(
                        p->System.out.println(
                                "vol destination :"+p.getDestination()+"\ncompagny Id :"+p.getCompagnieId()+
                                        "\ndate of vol : "+p.getDateVol()+
                                        "\ntype of vol : "+p.getTypeOfVol()+
                                        "\ntime to go :"+p.getHeureDepart()+
                                        "\nvol number :"+p.getVolNumber()+
                                        "\nnumber of place :"+p.getNombreDePlaces()
                        )
                );
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void getAllUsers() throws IOException {

        if (!file.exists())
            throw new FileNotFoundException(new CompagnyUtils().FILE_COMPAGNY_NOT_FOUND);

        try (var ob = new ObjectInputStream(
                new BufferedInputStream( new FileInputStream(file))
        )) {
            Object object = ob.readObject();

            if (object instanceof List<?> newUser) {
                @SuppressWarnings("unchecked")
                List<User> users = (List<User>) newUser;
                users.forEach(p->System.out.println(
                        p.toString()
                ));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    private User findUserByVol(Vol vol, String userId) throws IOException {
        if (!file.exists())
            throw new FileNotFoundException(new CompagnyUtils().FILE_COMPAGNY_NOT_FOUND);

        try (var ob = new ObjectInputStream(
                new BufferedInputStream( new FileInputStream(file))
        )) {
            Object object = ob.readObject();

            if (object instanceof List<?> newUser)
            {
                @SuppressWarnings("unchecked")
                List<User> users = (List<User>) newUser;

                return (User) users.stream()
                        .filter(p->p.getId().equals(userId) && users.contains(vol.getId()));
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

}
