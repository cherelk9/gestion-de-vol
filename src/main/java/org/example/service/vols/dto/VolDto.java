package org.example.service.vols.dto;

import org.example.service.vols.model.Compagnie;
import org.example.service.vols.model.TypeOfVol;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class VolDto implements Serializable {
    private final String id;
    private final int volNumber ;
    private final String destination;
    private final LocalDateTime heureDepart;
    private final Date dateVol;
    private final TypeOfVol typeOfVol;
    private final int nombreDePlaces;

    private final String compagnyId;

    public VolDto(String id, int volNumber, String destination, LocalDateTime heureDepart,
                  Date dateVol, TypeOfVol typeOfVol, int nombreDePlaces,
                  String compagnyId
    ) {
        this.id = id;
        this.volNumber = volNumber;
        this.destination = destination;
        this.heureDepart = heureDepart;
        this.dateVol = dateVol;
        this.typeOfVol = typeOfVol;
        this.nombreDePlaces = nombreDePlaces;
        this.compagnyId = compagnyId;
    }

    public int getNombreDePlaces() { return nombreDePlaces;}
    public TypeOfVol getTypeOfVol() {return typeOfVol;}
    public Date getDateVol() {return dateVol;}
    public LocalDateTime getHeureDepart() {return heureDepart;}
    public String getDestination() {return destination;}
    public int getVolNumber() {return volNumber;}
    public String getId() {return id;}
    public String getCompagnyId() {return new Compagnie().getId();}
}
