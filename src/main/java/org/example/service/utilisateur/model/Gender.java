package org.example.service.utilisateur.model;

public enum Gender {
    MALE("M"), FEMALE("F");
    private final String typeName;

    Gender(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
