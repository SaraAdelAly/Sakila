package gov.iti.jets.sakila.dto;

import gov.iti.jets.sakila.dto.CategoryDto;
import gov.iti.jets.sakila.dto.FilmDto;
import gov.iti.jets.sakila.dto.FilmCategoryIdDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
public class FilmCategoryDto implements Serializable {
    private FilmCategoryIdDto id;
    private FilmDto film;
    private CategoryDto category;
    private Instant lastUpdate;

}
