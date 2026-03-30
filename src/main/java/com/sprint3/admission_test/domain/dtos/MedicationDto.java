package com.sprint3.admission_test.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicationDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate expiration_date;
    private String category_name;
    private CategoryDto category;

}
