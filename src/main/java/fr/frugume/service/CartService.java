package fr.frugume.service;

import java.io.IOException;
import java.util.List;

import fr.frugume.model.dto.CartDto;

/**
 * Service de gestion des paniers.
 *
 * @author Hakim Bensmaine.
 */
public interface CartService {
    /**
     * Récupère tous les paniers en "base".
     *
     * @return La liste des paniers.
     * @throws java.io.FileNotFoundException
     *             Erreur de lecture du fichier de données.
     */
    List<CartDto> getAll() throws IOException;

    List<CartDto> getAllById(int userId) throws IOException;
}
