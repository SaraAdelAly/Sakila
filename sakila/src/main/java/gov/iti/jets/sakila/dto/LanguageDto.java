package gov.iti.jets.sakila.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
@Data
@NoArgsConstructor
public class LanguageDto implements Serializable {
    private final Set<FilmDto> films = new LinkedHashSet<>();
    private Short id;
    private String name;
    private Instant lastUpdate;

}
