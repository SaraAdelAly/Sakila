package gov.iti.jets.sakila.dto;

import gov.iti.jets.sakila.dto.FilmDto;
import gov.iti.jets.sakila.dto.RentalDto;
import gov.iti.jets.sakila.dto.StoreDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
@Data
@NoArgsConstructor
public class InventoryDto implements Serializable {

    private final Set<RentalDto> rentals = new LinkedHashSet<>();
    private Integer id;
    private FilmDto film;
    private StoreDto store;
    private Instant lastUpdate;

}
