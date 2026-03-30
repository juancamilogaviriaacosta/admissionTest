package com.sprint3.admission_test.application.ports.in;

import com.sprint3.admission_test.domain.dtos.MedicationDto;
import com.sprint3.admission_test.domain.model.Medication;

public interface IMedicationUseCase {
    Medication getMedicationById(Long id);
    MedicationDto createMedication(MedicationDto dto);
}
