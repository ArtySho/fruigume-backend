package fr.frugume.repository;

import java.io.IOException;
import java.util.List;

import fr.frugume.model.User;

/**
 * Gestion du référenciel des utilisateurs.
 *
 * @author Hakim BENSMAINE
 */
public interface UserRepository {
    /**
     * Récupère les données des utilisateurs.
     *
     * @return Une liste de utilisateurs.
     * @throws java.io.FileNotFoundException
     *             Erreur de lecture du fichier de données.
     */
    List<User> getAll() throws IOException;
}
