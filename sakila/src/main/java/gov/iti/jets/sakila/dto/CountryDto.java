package gov.iti.jets.sakila.dto;

import gov.iti.jets.sakila.dto.CityDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
@Data
@NoArgsConstructor
public class CountryDto implements Serializable {

    private Integer id;
    private String country;
    private Instant lastUpdate;
    private Set<CityDto> cities = new LinkedHashSet<>();

}
