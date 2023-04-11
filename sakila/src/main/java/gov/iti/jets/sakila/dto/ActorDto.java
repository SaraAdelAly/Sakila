package gov.iti.jets.sakila.dto;

import gov.iti.jets.sakila.dto.FilmActorDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class ActorDto implements Serializable{
    private Integer id;
    private String firstName;
    private String lastName;
    private Instant lastUpdate;
    private Set<FilmActorDto> filmActors = new LinkedHashSet<>();

}
