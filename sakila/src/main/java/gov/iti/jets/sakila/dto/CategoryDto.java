package gov.iti.jets.sakila.dto;

import gov.iti.jets.sakila.dto.FilmCategoryDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
@Data
@NoArgsConstructor
public class CategoryDto implements Serializable {
    private final Set<FilmCategoryDto> filmCategories = new LinkedHashSet<>();
    private Short id;
    private String name;
    private Instant lastUpdate;

}
