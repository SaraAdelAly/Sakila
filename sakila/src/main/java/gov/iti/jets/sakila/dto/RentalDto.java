package gov.iti.jets.sakila.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
@Data
@NoArgsConstructor
public class RentalDto implements Serializable {
    private final Set<PaymentDto> payments = new LinkedHashSet<>();
    private Integer id;
    private Instant rentalDate;
    private InventoryDto inventoryDto;//??
    private CustomerDto customerDto;
    private Instant returnDate;
    private StaffDto staff;
    private Instant lastUpdate;

}
