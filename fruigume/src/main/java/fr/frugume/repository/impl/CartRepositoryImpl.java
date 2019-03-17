package fr.frugume.repository.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.frugume.model.Cart;
import fr.frugume.repository.CartRepository;

/**
 * Gestion du référenciel des paniers.
 *
 * @author Hakim BENSMAINE
 */
@Repository
public class CartRepositoryImpl extends BasicReferenceRepositoryImpl implements CartRepository {
    private static final String DATA_FILE = "carts.json";

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Cart> getAll() throws IOException {
        return super.getAll(DATA_FILE, Cart[].class);
    }
}
