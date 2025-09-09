package org.example.service.vols.model;

import org.example.service.utilisateur.model.User;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * compagny (
 *     ...
 * )

 * */

public class Compagnie implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private  String id;
    private  String compagnieName;
    private  int nombreDeVols;

    private final Set<Vol> vols = new HashSet<>();
    private final Set<User> users = new HashSet<>();

    public Compagnie() {}

    public Compagnie(String id, String compagnieName, int nombreDeVols) {
        this.id = id;
        this.compagnieName = compagnieName;
        this.nombreDeVols = nombreDeVols;
    }

    public String getId() {return id;}
    public Set<User> getUsers() {return users;}
    public Set<Vol> getVols() {return vols;}
    public int getNombreDeVols() {return nombreDeVols;}
    public String getCompagnieName() {return compagnieName;}
}
