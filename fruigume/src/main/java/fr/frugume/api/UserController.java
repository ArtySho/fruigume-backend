package fr.frugume.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.frugume.model.dto.UserDto;
import fr.frugume.service.UserService;

/**
 * API de gestion des utilisateurs.
 *
 * @author Hakim BENSMAINE
 */
@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
    private UserService userService;


    /**
     * Récupération de tous les utilisateurs.
     *
     * @return La liste des utilisateurs enregistrés.
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    List<UserDto> getAll() throws IOException {
        return userService.getAll();
    }
}
