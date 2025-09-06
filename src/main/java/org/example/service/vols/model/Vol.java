package org.example.service.vols.model;

import org.example.service.vols.dto.VolDto;
import org.example.service.vols.utils.VolUtils;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Date;



public class Vol implements Serializable {

    private final File file = new File(new VolUtils().V_FILE);

    private  String id;
    private  int volNumber ;
    private  String destination;
    private  LocalDateTime heureDepart;
    private  Date dateVol;
    private  TypeOfVol typeOfVol;
    private  int nombreDePlaces;

    private  String compagnyId ;

    private final Compagnie compagny = new Compagnie();

    public Vol() {}

    public Vol (String id, int volNumber, String destination, LocalDateTime heureDepart, Date dateVol, TypeOfVol typeOfVol, int nombreDePlaces, String compagnyId) {
        this.id = id;
        this.volNumber = volNumber;
        this.destination = destination;
        this.heureDepart = heureDepart;
        this.dateVol = dateVol;
        this.typeOfVol = typeOfVol;
        this.nombreDePlaces = nombreDePlaces;
        this.compagnyId = compagnyId;
    }

    public Vol(String id, int volNumber, String destination, LocalDateTime heureDepart,
               Date dVole ,int nombreDePlaces, TypeOfVol typeOfVol, String compagnyId
    ) {
        this.id = id;
        this.volNumber = volNumber;
        this.destination = destination;
        this.heureDepart = heureDepart;
        this.dateVol = dVole;
        this.nombreDePlaces = nombreDePlaces;
        this.typeOfVol = typeOfVol;
        this.compagnyId = compagnyId;
    }

    public String getId() {return id;}
    public int getNombreDePlaces() {return nombreDePlaces;}
    public LocalDateTime getHeureDepart() {return heureDepart;}
    public String getDestination() {return destination;}
    public int getVolNumber() {return volNumber;}
    public Date getDateVol() {return dateVol;}
    public TypeOfVol getTypeOfVol() {return typeOfVol;}

    public  String getCompagnieId() {return compagny.getId();}



    public void addVol(VolDto volDto) throws IOException {

        if (!file.exists())
            throw new FileNotFoundException(new VolUtils().FILE_VOL_NOT_FOUND);

        try (var ob = new ObjectOutputStream(
                new BufferedOutputStream( new FileOutputStream( file ))
        )) {

            ob.writeObject(
                    new Vol(
                            volDto.getId(),
                            volDto.getVolNumber(),
                            volDto.getDestination(),
                            volDto.getHeureDepart(),
                            volDto.getDateVol(),
                            volDto.getNombreDePlaces(),
                            volDto.getTypeOfVol(),
                            volDto.getCompagnyId()

                    )
            );

            System.out.println("new vol add successful !");
        }
    }
}
