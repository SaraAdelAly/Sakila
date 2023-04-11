package gov.iti.jets.sakila.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
@Data
@NoArgsConstructor
public class StoreDto implements Serializable {
    private Short id;
    private StaffDto managerStaffDto;
    private AddressDto address;
    private Instant lastUpdate;
    private Set<InventoryDto> inventories = new LinkedHashSet<>();
    private Set<StaffDto> staffDtos = new LinkedHashSet<>();
    private Set<CustomerDto> customerDtos = new LinkedHashSet<>();

}

