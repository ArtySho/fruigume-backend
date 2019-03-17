package fr.frugume.service;

import java.io.IOException;
import java.util.List;

import fr.frugume.model.dto.UserDto;

/**
 * Service de gestion des utilisateurs.
 *
 * @author Hakim Bensmaine.
 */
public interface UserService {
    /**
     * Récupère tous les utilisateurs en "base".
     *
     * @return La liste des utilisateurs.
     * @throws java.io.FileNotFoundException
     *             Erreur de lecture du fichier de données.
     */
    List<UserDto> getAll() throws IOException;
    
    /**
     * Récupère un utilisateurs via son identifiant.
     *
     * @return Un utilisateur.
     * @throws java.io.FileNotFoundException
     *             Erreur de lecture du fichier de données.
     */
    UserDto getById(Integer id) throws IOException;
}
