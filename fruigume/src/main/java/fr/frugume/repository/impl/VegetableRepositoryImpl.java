package fr.frugume.repository.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.frugume.model.Vegetable;
import fr.frugume.repository.VegetableRepository;

/**
 * Gestion du référenciel des fruits & legumes.
 *
 * @author Hakim BENSMAINE
 */
@Repository
public class VegetableRepositoryImpl extends BasicReferenceRepositoryImpl implements VegetableRepository {
    private static final String DATA_FILE = "vegetables.json";

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Vegetable> getAll() throws IOException {
        return super.getAll(DATA_FILE, Vegetable[].class);
    }
}
