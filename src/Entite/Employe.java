/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author HS-PC
 */
public class Employe extends Personne {

    private int code;
    private String pseudo;
    private String motDePasse;

    public Employe(String Cin, String Nom, String Prenom, java.util.Date DateNaiss, String NumTelephone, String Adresse, String sexe, String pseudo, String motDePasse) {
        super(Cin, Nom, Prenom, DateNaiss, NumTelephone, Adresse, sexe);
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
    }

    public Employe(String Cin, int code, String Nom, String Prenom, java.util.Date DateNaiss, String NumTelephone, String Adresse, String sexe) {
        super(Cin, Nom, Prenom, DateNaiss, NumTelephone, Adresse, sexe);
        this.code = code;
    }

    public Employe(String Cin, String Nom, String Prenom, java.util.Date DateNaiss, String NumTelephone, String Adresse, String sexe) {
        super(Cin, Nom, Prenom, DateNaiss, NumTelephone, Adresse, sexe);

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

}
