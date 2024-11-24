package pe.edu.i202220098.cl1_jpa_data_narro_frank.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "countrylanguage")
@IdClass(CountryLanguageId.class)
public class CountryLanguage {
    @Id
    @Column(name = "CountryCode", columnDefinition = "CHAR(3)")
    private String countryCode;

    @Id
    @Column(name = "Language", length = 30)
    private String language;

    @Column(name = "IsOfficial", columnDefinition = "CHAR(1)")
    private String isOfficial;

    @Column(nullable = false)
    private Float percentage;

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", insertable = false, updatable = false)
    private Country country;
}