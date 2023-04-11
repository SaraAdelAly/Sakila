package gov.iti.jets.sakila.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", columnDefinition = "SMALLINT UNSIGNED not null")
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToMany(mappedBy = "actor")
    private Set<FilmActor> filmActors = new LinkedHashSet<>();

}