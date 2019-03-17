package fr.frugume.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.core.env.Environment;

import fr.frugume.config.ApplicationConstants;

/**
 * Classe utilitaire 
 * @author bensmainea
 *
 */
public final class DefaultProfileUtil {
	private static final String SPRING_PROFILE_DEFAULT = "spring.profiles.default";

	private DefaultProfileUtil() {
	}

	/**
	 * Set a default to use when no profile is configured.
	 *
	 * @param app
	 *            the Spring application.
	 */
	public static void addDefaultProfile(SpringApplication app) {
		Map<String, Object> defProperties = new HashMap<>();
		/**
		 * The default profile to use when no other profiles are defined.
		 */
		defProperties.put(SPRING_PROFILE_DEFAULT, ApplicationConstants.SPRING_PROFILE_DEVELOPMENT);
		app.setDefaultProperties(defProperties);
	}

	/**
	 * Get the profiles that are applied else get default profiles.
	 */
	public static String[] getActiveProfiles(Environment env) {
		String[] profiles = env.getActiveProfiles();
		if (profiles.length == 0) {
			return env.getDefaultProfiles();
		}
		return profiles;
	}

}
