package org.example.service.vols.dto;

import org.example.service.vols.model.Compagnie;
import org.example.service.vols.model.TypeOfVol;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class VolDto implements Serializable {
    private  String id;
    private  int volNumber ;
    private  String destination;
    private  LocalDateTime heureDepart;
    private  Date dateVol;
    private  TypeOfVol typeOfVol;
    private  int nombreDePlaces;

    private  String compagnyId;

    public VolDto(String id, int volNumber, String destination, LocalDateTime heureDepart,
                  Date dateVol, TypeOfVol typeOfVol, int nombreDePlaces
    ) {
        this.id = id;
        this.volNumber = volNumber;
        this.destination = destination;
        this.heureDepart = heureDepart;
        this.dateVol = dateVol;
        this.typeOfVol = typeOfVol;
        this.nombreDePlaces = nombreDePlaces;
        this.compagnyId = new Compagnie().getId();
    }

    public int getNombreDePlaces() { return nombreDePlaces;}
    public TypeOfVol getTypeOfVol() {return typeOfVol;}
    public Date getDateVol() {return dateVol;}
    public LocalDateTime getHeureDepart() {return heureDepart;}
    public String getDestination() {return destination;}
    public int getVolNumber() {return volNumber;}
    public String getId() {return id;}
    public String getCompagnyId() {return new Compagnie().getId();}

    public void setId(String id) {this.id = id;}
    public void setVolNumber(int volNumber) {this.volNumber = volNumber;}
    public void setDestination(String destination) {this.destination = destination;}
    public void setHeureDepart(LocalDateTime heureDepart) {this.heureDepart = heureDepart;}
    public void setDateVol(Date dateVol) {this.dateVol = dateVol;}
    public void setTypeOfVol(TypeOfVol typeOfVol) {this.typeOfVol = typeOfVol;}
    public void setNombreDePlaces(int nombreDePlaces) {this.nombreDePlaces = nombreDePlaces;}
    public void setCompagnyId(String compagnyId) {this.compagnyId = compagnyId;}
}
