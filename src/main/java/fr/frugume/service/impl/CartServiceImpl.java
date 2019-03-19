package fr.frugume.service.impl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import fr.frugume.model.Article;
import fr.frugume.model.Cart;
import fr.frugume.model.dto.ArticleDto;
import fr.frugume.model.dto.CartDto;
import fr.frugume.repository.CartRepository;
import fr.frugume.service.CartService;
import fr.frugume.service.UserService;
import fr.frugume.service.VegetableService;

/**
 * Service de gestion des paniers.
 *
 * @author Hakim Bensmaine.
 */
@Service
public class CartServiceImpl extends CachedService implements CartService {

	/**
	 * Gestionnaire du référenciel des paniers.
	 */
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private VegetableService vegetableService;

	/**
	 * Liste des objets enregistrés.
	 */
	private List<CartDto> references;


	/**
	 * Methode de récupèration des objets referentiels.
	 *
	 * @return Une liste d'objet representant un réferentiel.
	 * @throws IOException
	 *             Erreur de lecture du fichier.
	 */
	public List<CartDto> getAll() throws IOException {
		if (CollectionUtils.isEmpty(references) || areDataExpired()) {
			references = mapReferences();

			updateDataFreshness();
		}
		return references;
	}

	/**
	 * Methode de récupèration des objets referentiels par id.
	 *
	 * @return Une liste d'objet representant un réferentiel.
	 * @throws IOException
	 *             Erreur de lecture du fichier.
	 */

	public List<CartDto> getAllById(int userId) throws IOException {

		List<CartDto> panier = getAll();
		List<CartDto> panierUtilisateur = new ArrayList<>();
		for (CartDto value : panier) {
			if(value.getUser().getId() == userId){
				panierUtilisateur.add(value);
			}
		}
		Collections.sort(panierUtilisateur);
		return panierUtilisateur;
	}

	/**
	 * Map une liste de modèle avec une nouvelle liste de DTO.
	 *
	 * @return La liste des nouveaux DTOs.
	 * @throws IOException
	 *             Echec de lecture des références.
	 */
	private List<CartDto> mapReferences() throws IOException {
		List<CartDto> result = new ArrayList<>();
		List<Cart> models = getAllFromRepository();
		if (models != null) {
			for (Cart reference : models) {
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
	private List<Cart> getAllFromRepository() throws IOException {
		return cartRepository.getAll();
	}

	/**
	 * methode de convertion unitaire d'un objet model en DTO
	 *
	 * @param reference
	 *            un objet model.
	 * @return un dto.
	 * @throws IOException
	 */
	private CartDto mapReference(Cart reference) throws IOException {
		CartDto dto = null;
		if (reference != null) {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			dto = new CartDto();
			dto.setId(reference.getId());
			try {
				dto.setDate(format.parse(reference.getDate()));
			} catch (ParseException e) {
				// Osef
				e.printStackTrace();
			}
			dto.setStatus(reference.getStatus());
			dto.setUser(userService.getById(reference.getUserId()));
			dto.setArticles(new ArrayList<>());
			if (reference.getArticles() != null) {
				for (Article art : reference.getArticles()) {
					if (art != null) {
						ArticleDto artDto = new ArticleDto();
						artDto.setQuantity(art.getQuantity());
						artDto.setVegetable(vegetableService.getById(art.getVegetableId()));
						dto.getArticles().add(artDto);
					}
				}
			}
		}

		return dto;
	}

}
