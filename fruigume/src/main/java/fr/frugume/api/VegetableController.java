package fr.frugume.api;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.frugume.model.dto.VegetableDto;
import fr.frugume.service.VegetableService;

/**
 * API de gestion des fruits et légumes.
 *
 * @author Hakim BENSMAINE
 */
@RestController
@RequestMapping("vegetable")
public class VegetableController {

	@Autowired
    private VegetableService vegetableService;


    /**
     * Récupération de tous les fruits et légumes.
     *O
     * @return La liste des fruits et légumes enregistrés.
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    List<VegetableDto> getAll() throws IOException {
        return vegetableService.getAll();
    }
}
