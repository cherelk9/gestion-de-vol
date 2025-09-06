package org.example.service.vols.model;

public enum TypeOfVol {

    JOUR("day"), NUIT("night");
    private final String typeName;
    TypeOfVol(String typeName) {
        this.typeName = typeName;
    }
    public String getTypeName() {return typeName;}
}
