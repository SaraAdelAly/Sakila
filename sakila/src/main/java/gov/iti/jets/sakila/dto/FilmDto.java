package gov.iti.jets.sakila.dto;

import gov.iti.jets.sakila.dto.FilmActorDto;
import gov.iti.jets.sakila.dto.FilmCategoryDto;
import gov.iti.jets.sakila.dto.InventoryDto;
import gov.iti.jets.sakila.dto.LanguageDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class FilmDto implements Serializable {
    private final Set<InventoryDto> inventories = new LinkedHashSet<>();
    private final Set<FilmActorDto> filmActors = new LinkedHashSet<>();
    private final Set<FilmCategoryDto> filmCategories = new LinkedHashSet<>();
    private Integer id;
    private String title;
    private String description;
    private Integer releaseYear;
    private LanguageDto language;
    private LanguageDto originalLanguage;
    private Short rentalDuration;
    private BigDecimal rentalRate;
    private Integer length;
    private BigDecimal replacementCost;
    private String rating;
    private String specialFeatures;
    private Instant lastUpdate;


}
