package gov.iti.jets.sakila.dto;

import gov.iti.jets.sakila.dto.AddressDto;
import gov.iti.jets.sakila.dto.CountryDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
@Data
@NoArgsConstructor
public class CityDto implements Serializable{

    private Integer id;

    private String city;

    private CountryDto country;

    private Instant lastUpdate;

    private Set<AddressDto> addresses = new LinkedHashSet<>();

}