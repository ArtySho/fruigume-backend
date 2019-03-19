package fr.frugume.api;

import java.io.IOException;
import java.util.List;

import fr.frugume.model.Cart;
import fr.frugume.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import fr.frugume.model.dto.CartDto;
import fr.frugume.service.CartService;

/**
 * API de gestion des paniers.
 *
 * @author Hakim BENSMAINE
 */
@RestController
@RequestMapping("cart")
public class CartController {

	@Autowired
    private CartService cartService;


    /**
     * Récupération de tous les paniers.
     *
     * @return La liste des paniers enregistrés.
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    List<CartDto> getAll() throws IOException {
        return cartService.getAll();
    }

    /**
     * Récupération du panier de l'utilisateur
     *
     * @return Cart du user
     */
    @RequestMapping(
            value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CartDto findById(@PathVariable(value = "id") Integer id) throws IOException {
        try {
            CartDto cart = cartService.findOne(id);
            return cart;
        } catch(IOException e){
            throw new IOException(e.getMessage());
        }
    }
}
