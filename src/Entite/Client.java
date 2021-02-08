/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.Date;


/**
 *
 * @author HS-PC
 */
public class Client extends Personne{

    public Client(String Cin, String Nom, String Prenom, Date DateNaiss, String NumTelephone, String Adresse, String sexe) {
        super(Cin, Nom, Prenom, DateNaiss, NumTelephone, Adresse, sexe);
    }

    

      
    
    

    @Override
    public String Affiche() {
        return super.Affiche(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
