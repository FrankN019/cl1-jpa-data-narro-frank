package pe.edu.i202220098.cl1_jpa_data_narro_frank.Repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.i202220098.cl1_jpa_data_narro_frank.Entity.City;
import pe.edu.i202220098.cl1_jpa_data_narro_frank.Entity.CountryLanguage;
import pe.edu.i202220098.cl1_jpa_data_narro_frank.Entity.Country;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, String> {

}
