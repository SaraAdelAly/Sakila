package gov.iti.jets.sakila.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
@Data
@NoArgsConstructor
public class FilmActorDto implements Serializable {
    private FilmActorIdDto id;
    private ActorDto actor;
    private FilmDto film;
    private Instant lastUpdate;

}
