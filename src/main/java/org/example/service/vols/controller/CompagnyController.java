package org.example.service.vols.controller;


import org.example.service.utilisateur.exception.UserNotFoundException;
import org.example.service.utilisateur.model.User;
import org.example.service.vols.dto.VolDto;
import org.example.service.vols.model.Compagnie;
import org.example.service.vols.model.UserByVol;
import org.example.service.vols.service.CompagnyService;
import org.example.service.vols.utils.CompagnyUtils;

import java.io.*;
import java.util.function.BiFunction;


public class CompagnyController {

    private final File file = new File(new CompagnyUtils().MY_VOL_FILE);

    private final CompagnyService compagnyService = new CompagnyService();


    /**
     * Initialiser un vol,
     * ajouter les clients dont l'id correspond au numero vol
     * donner une heure, donner un jour, donner point d'arriver, donner nombre de places ;
     * <p>
     *     private String id ;
     *     private int volNumber ;
     *     private String destination ;
     *     private LocalDateTime heureDepart ;
     *     private  Date dateVol;
     *     private  TypeOfVol typeOfVol;
     *     private  int nombreDePlaces;
     * */

    public void programVol(VolDto vol) throws IOException {
        if (!file.exists())
            throw new FileNotFoundException(new CompagnyUtils().FILE_COMPAGNY_NOT_FOUND);

        try (var ob = new ObjectOutputStream(
                new BufferedOutputStream( new FileOutputStream(file))
        )){

            /*
            * créer une bi fonction qui prend en parameter un utilisateur et un vol et return un record class
            *
            * */

            BiFunction<VolDto, User, UserByVol> newUserByVol = (p,y)->{
                if (y.getVolId().equals(p.getId())) {
                    return new UserByVol(
                            new VolDto(
                                    p.getId(),
                                    p.getVolNumber(),
                                    p.getDestination(),
                                    p.getHeureDepart(),
                                    p.getDateVol(),
                                    p.getTypeOfVol(),
                                    p.getNombreDePlaces(),
                                    p.getCompagnyId()),
                            new User(
                                    y.getId(),
                                    y.getName(),
                                    y.getSurname(),
                                    y.getAge(),
                                    y.getEmail(),
                                    y.getPhone(),
                                    y.getGender(),
                                    y.getReservationId(),
                                    y.getnReservation(),
                                    y.getTypeOfReservation(),
                                    p.getId(),
                                    new Compagnie().getId()
                            )
                    );
                }
                return null;
            };

            ob.writeObject(newUserByVol);
            System.out.println(" le vol numero : " +vol.getVolNumber()+ " a ete programme avec success !");
        }

    }

    public void getAllReservation(File file1) throws IOException {
        compagnyService.getAllReservation(file1);
    }

    public void getUserByVol(VolDto vol, String userId) throws IOException, UserNotFoundException {
        if (file.exists() && vol.getId().equals(userId)) compagnyService.getUserByVol(userId, vol.createVol(vol));
    }

    public void creerVol(VolDto vol) throws IOException {
        compagnyService.createVol(vol);
    }




}
