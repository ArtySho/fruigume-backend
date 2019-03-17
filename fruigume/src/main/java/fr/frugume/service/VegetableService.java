package fr.frugume.service;

import java.io.IOException;
import java.util.List;

import fr.frugume.model.dto.VegetableDto;

/**
 * Service de gestion des fruits & légumes.
 *
 * @author Hakim Bensmaine.
 */
public interface VegetableService {
    /**
     * Récupère tous les fruits et légumes en "base".
     *
     * @return La liste des fruits et légumes.
     * @throws java.io.FileNotFoundException
     *             Erreur de lecture du fichier de données.
     */
    List<VegetableDto> getAll() throws IOException;
    
    /**
     * Récupère un fruit/legume via son identifiant.
     *
     * @return Un fruit/legume.
     * @throws java.io.FileNotFoundException
     *             Erreur de lecture du fichier de données.
     */
    VegetableDto getById(Integer id) throws IOException;
}
