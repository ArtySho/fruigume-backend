package fr.frugume.model.mapper;

import fr.frugume.model.Vegetable;
import fr.frugume.model.dto.VegetableDto;

/**
 * Gestion du mapping du modèle de fruit/legume avec le DTO.
 *
 * @author hakim BENSMAINE
 */
public class VegetableMapper {
    /**
     * Map le modèle d'un fruit/legume avec le DTO
     *
     * @param modele modèle de fruit/legume
     * @return DTO de fruit/legume
     */
    public VegetableDto vegetableToVegetableDto(Vegetable modele) {
    	VegetableDto dto = null;
    	if (modele != null) {
    		dto = new VegetableDto();
    		dto.setId(modele.getId());
    		dto.setName(modele.getName());
    		dto.setDescription(modele.getDescription());
    		dto.setAverageWeight(modele.getAverageWeight());
    		dto.setPrice(modele.getPrice());
    		dto.setUnit(modele.getUnit());
    		
    	}
    	return dto;
    }
    
    /**
     * Map le dto d'un fruit/legume avec le modèle
     *
     * @param dto dto de fruit/legume
     * @return Modèle de fruit/legume
     */
    public Vegetable vegetableDtoToVegetable(VegetableDto dto) {
    	Vegetable entity = null;
    	if (dto != null) {
    		entity = new Vegetable();
    		entity.setId(dto.getId());
    		entity.setName(dto.getName());
    		entity.setDescription(dto.getDescription());
    		entity.setAverageWeight(dto.getAverageWeight());
    		entity.setPrice(dto.getPrice());
    		entity.setUnit(dto.getUnit());
    		
    	}
    	return entity;
    }
}
