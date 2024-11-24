package pe.edu.i202220098.cl1_jpa_data_narro_frank.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 35, nullable = false)
    private String name;

    @Column(name = "CountryCode", columnDefinition = "CHAR(3)")
    private String countryCode;

    @Column(length = 20, nullable = false)
    private String district;

    @Column(nullable = false)
    private Integer population;

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", insertable = false, updatable = false)
    private Country country;
}
