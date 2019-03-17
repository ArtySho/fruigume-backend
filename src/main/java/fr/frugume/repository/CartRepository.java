package fr.frugume.repository;

import java.io.IOException;
import java.util.List;

import fr.frugume.model.Cart;

/**
 * Gestion du référenciel des paniers.
 *
 * @author Hakim BENSMAINE
 */
public interface CartRepository {
    /**
     * Récupère les données des paniers.
     *
     * @return Une liste de paniers.
     * @throws java.io.FileNotFoundException
     *             Erreur de lecture du fichier de données.
     */
    List<Cart> getAll() throws IOException;
}
