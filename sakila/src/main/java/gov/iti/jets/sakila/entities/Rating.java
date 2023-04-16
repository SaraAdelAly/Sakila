package gov.iti.jets.sakila.entities;

import gov.iti.jets.sakila.entities.enums.RatingType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id", columnDefinition = "TINYINT UNSIGNED not null")
    private Short id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ratingType", unique = true, nullable = false, length = 5)
    private RatingType ratingType;

    @OneToMany(mappedBy = "rating")
    private Set<Film> films = new LinkedHashSet<>();

}
