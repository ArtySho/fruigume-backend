package fr.frugume.repository.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.frugume.utils.ResourceUtils;

/**
 * Gestion des référenciels.
 *
 * @author Hakim BENSMAINE
 */
@Repository
public class BasicReferenceRepositoryImpl {
    /**
     * @inheritDoc
     */
    protected <T> List<T> getAll(String dataFileName, Class<T[]> type) throws IOException {
        InputStream dataFile = ResourceUtils.getFile(dataFileName);
        ObjectMapper objectMapper = new ObjectMapper();
        return Arrays.stream(objectMapper.readValue(dataFile, type))
                .distinct()
                .collect(Collectors.toList());
    }
}
