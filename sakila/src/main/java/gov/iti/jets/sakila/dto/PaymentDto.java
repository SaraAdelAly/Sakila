package gov.iti.jets.sakila.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
@Data
@NoArgsConstructor
public class PaymentDto implements Serializable {
    private Integer id;
    private CustomerDto customerDto;
    private StaffDto staff;
    private RentalDto rental;
    private BigDecimal amount;
    private Instant paymentDate;
    private Instant lastUpdate;

}
