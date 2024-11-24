package pe.edu.i202220098.cl1_jpa_data_narro_frank;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202220098.cl1_jpa_data_narro_frank.Entity.Country;
import pe.edu.i202220098.cl1_jpa_data_narro_frank.Entity.CountryLanguage;
import pe.edu.i202220098.cl1_jpa_data_narro_frank.Repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataNarroFrankApplication implements CommandLineRunner {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataNarroFrankApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

 // CONSULTA 1 ifPresentOrElse()
		Optional<List<CountryLanguage>> languagesInArgentina = getLanguagesByCountryCode("ARG");

		Optional<List<CountryLanguage>> languagesInPeru = languagesInArgentina.or(() -> getLanguagesByCountryCode("PER"));

		languagesInPeru.ifPresent(languages -> languages.forEach(language -> System.out.println(language.getLanguage())));

// CONSULTA 2 deleteAllById()

		System.out.println("\n=== Eliminando Países y sus datos asociados ===");

		try {
			entityManager.createNativeQuery("DELETE FROM city WHERE CountryCode IN ('COL', 'ARG')")
					.executeUpdate();

			entityManager.createNativeQuery("DELETE FROM countrylanguage WHERE CountryCode IN ('COL', 'ARG')")
					.executeUpdate();

			countryRepository.deleteById("COL");
			countryRepository.deleteById("ARG");

			System.out.println("Países y sus relaciones eliminadas exitosamente.");
		} catch (Exception e) {
			System.out.println("Error al eliminar los países: " + e.getMessage());
		}
	}

	private Optional<List<CountryLanguage>> getLanguagesByCountryCode(String countryCode) {

		Country country = countryRepository.findById(countryCode).orElse(null);

		if (country == null || country.getLanguages() == null || country.getLanguages().isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(country.getLanguages());
	}
}
