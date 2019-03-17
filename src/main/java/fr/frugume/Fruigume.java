package fr.frugume;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import fr.frugume.config.DefaultProfileUtil;

@EnableAutoConfiguration 
@Configuration
@ComponentScan({"fr.frugume"})
public class Fruigume {
	
	/** Logger. */
	private static final Logger LOGGER = LogManager.getLogger(Fruigume.class);
	
	
	/**
	 * Methode d'execution locale.
	 * @param args Arguements.
	 * @throws UnknownHostException Hote inconnu.
	 */
	public static void main(String[] args) throws UnknownHostException {
		// SpringApplication.run(Application.class, args);
		SpringApplication app = new SpringApplication(Fruigume.class);
		DefaultProfileUtil.addDefaultProfile(app);
		Environment env = app.run(args).getEnvironment();
		String port = env.getProperty("server.port");
		String host = InetAddress.getLocalHost().getHostAddress();
		String vegetable = env.getProperty("server.vegetable.context-path");
		String user = env.getProperty("server.user.context-path");
		String cart = env.getProperty("server.cart.context-path");

		LOGGER.info("\n--------------------------------------------------------------------\n"
				+ "\tApplication '{}' is running for '{}' !\n\n"
				+ "\tVegetable API access URLs:\n" 
				+ "\t\tLocal: \t\thttp://localhost:{}{}\n"
				+ "\t\tExternal: \thttp://{}:{}{}\n"
				+ "\tUsers API access URLs:\n"
				+ "\t\tLocal: \t\thttp:/localhost:{}{}\n"
				+ "\t\tExternal: \thttp://{}:{}{}\n"
				+ "\tCart API access URLs:\n"
				+ "\t\tLocal: \t\thttp:/localhost:{}{}\n"
				+ "\t\tExternal: \thttp://{}:{}{}\n"
				+ "\n--------------------------------------------------------------------",
				env.getProperty("spring.application.name"),
				String.join(", ", Arrays.asList(DefaultProfileUtil.getActiveProfiles(env))),
				port, vegetable,
				host, port, vegetable, 
				port, user,
				host, port,	user, 
				port, cart,
				host, port,	cart);
	}
}
