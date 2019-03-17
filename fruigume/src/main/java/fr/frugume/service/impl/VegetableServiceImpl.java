package fr.frugume.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import fr.frugume.model.Vegetable;
import fr.frugume.model.dto.VegetableDto;
import fr.frugume.model.mapper.VegetableMapper;
import fr.frugume.repository.VegetableRepository;
import fr.frugume.service.VegetableService;

/**
 * Service de gestion des fruits/legumes.
 *
 * @author Hakim Bensmaine.
 */
@Service
public class VegetableServiceImpl extends CachedService implements VegetableService {

	/**
	 * Gestionnaire du référenciel des fruits/legumes.
	 */
	@Autowired
	private VegetableRepository vegetableRepository;

	/**
	 * Mapper du modèle avec le DTO.
	 */
	private VegetableMapper vegetableMapper = new VegetableMapper();

	/**
	 * Liste des objets enregistrés.
	 */
	private List<VegetableDto> references;

	/**
	 * Methode de récupèration des objets referentiels.
	 *
	 * @return Une liste d'objet representant un réferentiel.
	 * @throws IOException
	 *             Erreur de lecture du fichier.
	 */
	public List<VegetableDto> getAll() throws IOException {
		if (CollectionUtils.isEmpty(references) || areDataExpired()) {
			references = mapReferences();
			updateDataFreshness();
		}
		return references;
	}
	
	@Override
	public VegetableDto getById(Integer id) throws IOException {
		VegetableDto ret = null;
		if (id != null) {
			List<VegetableDto> all = getAll();
			for (VegetableDto dto : all) {
				if (id.equals(dto.getId())) {
					ret = dto;
					break;
				}
			}
		}
		return ret;
	}
	
	/**
	 * Map une liste de modèle avec une nouvelle liste de DTO.
	 *
	 * @return La liste des nouveaux DTOs.
	 * @throws IOException
	 *             Echec de lecture des références.
	 */
	private List<VegetableDto> mapReferences() throws IOException {
		List<VegetableDto> result = new ArrayList<>();
		List<Vegetable> models = getAllFromRepository();
		if (models != null) {
			for (Vegetable reference : models) {
				result.add(mapReference(reference));
			}
		}
		// on ordonne par ordre alphabetique du fullName.
		Collections.sort(result);
		return result;
	}

    /**
     * Méthode d'appelle du répository.
     *
     * @return la liste d'objet model.
     */
	private List<Vegetable> getAllFromRepository() throws IOException {
		return vegetableRepository.getAll();
	}

    /**
     * methode de convertion unitaire d'un objet model en DTO
     *
     * @param reference un objet model.
     * @return un dto.
     */
	private VegetableDto mapReference(Vegetable reference) {
		return vegetableMapper.vegetableToVegetableDto(reference);
	}


}
