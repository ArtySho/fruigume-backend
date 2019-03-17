package fr.frugume.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
