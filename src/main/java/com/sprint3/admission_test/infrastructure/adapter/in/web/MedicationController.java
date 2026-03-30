package com.sprint3.admission_test.infrastructure.adapter.in.web;

import com.sprint3.admission_test.application.ports.in.IMedicationUseCase;
import com.sprint3.admission_test.domain.dtos.MedicationDto;
import com.sprint3.admission_test.domain.model.Medication;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    @Autowired
    private IMedicationUseCase medicationUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(medicationUseCase.getMedicationById(id));
    }

    @PostMapping
    public ResponseEntity<MedicationDto> createMedication(@RequestBody MedicationDto dto) {
        medicationUseCase.createMedication(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Medication>> getMedicationByCategory(
            @PathVariable String category, @RequestParam("expiration-after") LocalDate expirationAfter) {
        System.out.println("category " + category + " - " + "expirationAfter " + expirationAfter);
        List<Medication> medications = medicationUseCase.findMedicationByCategory(category, expirationAfter);
        return ResponseEntity.status(HttpStatus.OK).body(medications);
    }

}
