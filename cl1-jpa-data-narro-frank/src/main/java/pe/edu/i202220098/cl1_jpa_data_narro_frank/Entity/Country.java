package pe.edu.i202220098.cl1_jpa_data_narro_frank.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "Code", columnDefinition = "CHAR(3)")
    private String code;

    @Column(length = 52, nullable = false)
    private String name;

    @Column(length = 13, nullable = false)
    private String continent;

    @Column(length = 26, nullable = false)
    private String region;

    @Column(name = "SurfaceArea", nullable = false)
    private Float surfaceArea;

    @Column(name = "IndepYear")
    private Short indepYear;

    @Column(nullable = false)
    private Integer population;

    @Column(name = "LifeExpectancy")
    private Float lifeExpectancy;

    @Column(nullable = false)
    private Float gnp;

    @Column(name = "GNPOld")
    private Float gnpOld;

    @Column(name = "LocalName", length = 45, nullable = false)
    private String localName;

    @Column(name = "GovernmentForm", length = 45, nullable = false)
    private String governmentForm;

    @Column(name = "HeadOfState", length = 60)
    private String headOfState;

    @Column(nullable = true)
    private Integer capital;

    @Column(name = "Code2", length = 2)
    private String code2;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CountryLanguage> languages;

}
