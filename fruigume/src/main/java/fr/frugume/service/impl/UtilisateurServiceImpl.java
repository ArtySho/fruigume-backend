package fr.frugume.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import fr.frugume.model.User;
import fr.frugume.model.dto.UserDto;
import fr.frugume.model.mapper.UserMapper;
import fr.frugume.repository.UserRepository;
import fr.frugume.service.UserService;

/**
 * Service de gestion des utilisteurs.
 *
 * @author Hakim Bensmaine.
 */
@Service
public class UtilisateurServiceImpl extends CachedService implements UserService {

	/**
	 * Gestionnaire du référenciel des nautilisteurstures.
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Mapper du modèle avec le DTO.
	 */
	private UserMapper userMapper = new UserMapper();

	/**
	 * Liste des objets enregistrés.
	 */
	private List<UserDto> references;

	/**
	 * Methode de récupèration des objets referentiels.
	 *
	 * @return Une liste d'objet representant un réferentiel.
	 * @throws IOException
	 *             Erreur de lecture du fichier.
	 */
	@Override
	public List<UserDto> getAll() throws IOException {
		if (CollectionUtils.isEmpty(references) || areDataExpired()) {
			references = mapReferences();
			updateDataFreshness();
		}
		return references;
	}
	
	@Override
	public UserDto getById(Integer id) throws IOException {
		UserDto ret = null;
		if (id != null) {
			List<UserDto> all = getAll();
			for (UserDto dto : all) {
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
	private List<UserDto> mapReferences() throws IOException {
		List<UserDto> result = new ArrayList<>();
		List<User> models = getAllFromRepository();
		if (models != null) {
			for (User reference : models) {
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
	private List<User> getAllFromRepository() throws IOException {
		return userRepository.getAll();
	}

    /**
     * methode de convertion unitaire d'un objet model en DTO
     *
     * @param reference un objet model.
     * @return un dto.
     */
	private UserDto mapReference(User reference) {
		return userMapper.userToUserDto(reference);
	}
}
