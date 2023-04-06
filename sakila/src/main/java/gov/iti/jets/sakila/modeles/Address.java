package gov.iti.jets.sakila.modeles;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", columnDefinition = "SMALLINT UNSIGNED not null")
    private Integer id;

    @Column(name = "address", nullable = false, length = 50)
    private String address;

    @Column(name = "address2", length = 50)
    private String address2;

    @Column(name = "district", nullable = false, length = 20)
    private String district;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToMany(mappedBy = "address")
    private Set<Store> stores = new LinkedHashSet<>();
    @OneToMany(mappedBy = "address")
    private Set<Customer> customers = new LinkedHashSet<>();

/*
    TODO [JPA Buddy] create field to map the 'location' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "location", columnDefinition = "GEOMETRY(65535) not null")
    private Object location;
*/
}