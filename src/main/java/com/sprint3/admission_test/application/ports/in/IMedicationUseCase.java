package com.sprint3.admission_test.application.ports.in;

import com.sprint3.admission_test.domain.dtos.MedicationDto;
import com.sprint3.admission_test.domain.model.Medication;

import java.time.LocalDate;
import java.util.List;

public interface IMedicationUseCase {
    Medication getMedicationById(Long id);
    MedicationDto createMedication(MedicationDto dto);
    List<Medication> findMedicationByCategory(String category, LocalDate expirationAfter);

}
