package fr.frugume.config;

/**
 * Constantes de l'application.
 * @author bensmainea
 *
 */
public class ApplicationConstants {
	
    /**
     * Profil spring pour développement.
     */
    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    /**
     * Profil spring pour test.
     */
    public static final String SPRING_PROFILE_TEST = "recette";
    /**
     * Profil spring pour production.
     */
    public static final String SPRING_PROFILE_RELEASE = "release";

    /**
     * Constructeur privée par défaut.
     */
    private ApplicationConstants() {
    }

}
