package fr.frugume.repository.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.frugume.model.User;
import fr.frugume.repository.UserRepository;

/**
 * Gestion du référenciel des utilisateurs.
 *
 * @author Hakim BENSMAINE
 */
@Repository
public class UserRepositoryImpl extends BasicReferenceRepositoryImpl implements UserRepository {
    private static final String DATA_FILE = "users.json";

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAll() throws IOException {
        return super.getAll(DATA_FILE, User[].class);
    }
}
