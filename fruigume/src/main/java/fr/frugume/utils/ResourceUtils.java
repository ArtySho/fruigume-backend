package fr.frugume.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Classe utilitaire concernant la gestion des resources.
 *
 * @author Hakim BENSMAINE
 */
public class ResourceUtils {
    private ResourceUtils() {
    }

    /**
     * Crée un stream pointant sur le fichier avec le chemin donné.
     *
     * @param filePath Le chemin vers le fichier
     * @return Un stream pointant sur ce fichier (si celui ci existe)
     * @throws FileNotFoundException Si le fichier est introuvable
     */
    public static InputStream getFile(String filePath) throws FileNotFoundException {
        InputStream stream = ResourceUtils.class.getClassLoader().getResourceAsStream(filePath);
        if (stream == null) throw new FileNotFoundException(filePath);
        return stream;
    }
}
