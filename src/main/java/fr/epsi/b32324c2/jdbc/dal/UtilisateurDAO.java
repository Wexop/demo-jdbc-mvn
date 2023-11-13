package fr.epsi.b32324c2.jdbc.dal;

import fr.epsi.b32324c2.jdbc.entites.Utilisateur;

public interface UtilisateurDAO {

    Utilisateur login(String login, String psw) throws Exception;
}
