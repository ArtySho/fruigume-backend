package fr.frugume.model.mapper;

import fr.frugume.model.User;
import fr.frugume.model.dto.UserDto;

/**
 * Gestion du mapping du modèle de utilisateur avec le DTO.
 *
 * @author hakim BENSMAINE
 */
public class UserMapper {
    /**
     * Map le modèle d'un utilisateur avec le DTO
     *
     * @param modele modèle de utilisateur
     * @return DTO de utilisateur
     */
    public UserDto userToUserDto(User modele) {
    	UserDto dto = null;
    	if (modele != null) {
    		dto = new UserDto();
    		dto.setId(modele.getId());
    		dto.setFirstName(modele.getFirstName());
    		dto.setLastName(modele.getLastName());
    		dto.setLogin(modele.getLogin());
    		dto.setPassword(modele.getPassword());
    		dto.setRole(modele.getRole());
    		
    	}
    	return dto;
    }
}
