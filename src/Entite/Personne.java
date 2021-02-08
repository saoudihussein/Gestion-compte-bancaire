/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;



import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author HS-PC
 */
public class Personne {

    private String Cin;

    private String Nom;

    private String Prenom;

    private Date DateNaiss;

    private String NumTelephone;

    private String Adresse;

    private String sexe;

    public Personne(String Cin, String Nom, String Prenom, Date DateNaiss, String NumTelephone, String Adresse, String sexe) {
        this.Cin = Cin;
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.DateNaiss = DateNaiss;
        this.NumTelephone = NumTelephone;
        this.Adresse = Adresse;
        this.sexe = sexe;
    }

    public String getCin() {
        return Cin;
    }

    public void setCin(String newCin) {
        Cin = newCin;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String newNom) {
        Nom = newNom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String newPrenom) {
        Prenom = newPrenom;
    }

    public Date getDateNaiss() {
        return DateNaiss;
    }

    public void setDateNaiss(Date DateNaiss) {
        this.DateNaiss = DateNaiss;
    }

    

    public String getNumTelephone() {
        return NumTelephone;
    }

    public void setNumTelephone(String newNumTelephone) {
        NumTelephone = newNumTelephone;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String newAdresse) {
        Adresse = newAdresse;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String newSexe) {
        sexe = newSexe;
    }

    public String Affiche() {
        return "Cin: " + this.Cin + "/n"
                + "Nom: " + this.Nom + "\n"
                + "Prénom: " + this.Prenom + "\n"
                + "Sexe: " + this.sexe + "\n"
                + "Adresse: " + this.Adresse + "\n"
                + "N° téléphone: " + this.NumTelephone;
    }

}
