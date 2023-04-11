package gov.iti.jets.sakila;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.sakila.entities.FilmText} entity
 */
@Data
public class FilmTextDto implements Serializable {
    private final Short id;
    private final String title;
    private final String description;
}