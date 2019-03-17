package fr.frugume.repository;

import java.io.IOException;
import java.util.List;

import fr.frugume.model.Vegetable;

/**
 * Gestion du référenciel des fruits/légumes.
 *
 * @author Hakim BENSMAINE
 */
public interface VegetableRepository {
    /**
     * Récupère les données des fruits & légumes.
     *
     * @return Une liste de fruits & légumes.
     * @throws java.io.FileNotFoundException
     *             Erreur de lecture du fichier de données.
     */
    List<Vegetable> getAll() throws IOException;
}
