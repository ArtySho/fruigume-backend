package fr.frugume.api;

import java.io.IOException;
import java.util.List;

import fr.frugume.model.Cart;
import fr.frugume.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
     * us#10
     *
     * @return les paniers de l'utilisateur triés du plus récent au plus ancien.
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    List<CartDto> getAllById(@PathVariable("userId") int userId) throws IOException {

        return cartService.getAllById(userId);
     
   }
   /***
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
