package com.sprint3.admission_test.infrastructure.adapter.out.persistence.repositoryImpl;

import com.sprint3.admission_test.application.ports.out.IMedicationRepository;
import com.sprint3.admission_test.domain.dtos.CategoryDto;
import com.sprint3.admission_test.domain.dtos.MedicationDto;
import com.sprint3.admission_test.domain.model.Category;
import com.sprint3.admission_test.domain.model.Medication;
import com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository.CategoryJpaRepository;
import com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository.MedicationJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class MedicationRepositoryImpl implements IMedicationRepository {

    @Autowired
    private MedicationJpaRepository medicationJpaRepository;

    @Autowired
    private CategoryJpaRepository categoryJpaRepository;

    @Override
    public Optional<Medication> findById(Long id) {
        return medicationJpaRepository.findById(id);
    }

    @Override
    public MedicationDto createMedication(MedicationDto dto) {
        Medication med = new Medication();
        med.setName(dto.getName());
        med.setPrice(dto.getPrice());
        med.setDescription(dto.getDescription());
        med.setExpirationDate(dto.getExpiration_date());

        Category cat = categoryJpaRepository.findByName(dto.getCategory_name()).get(0);
        med.setCategory(cat);
        medicationJpaRepository.save(med);
        dto.setId(med.getId());

        CategoryDto catDto = new CategoryDto();
        catDto.setId(cat.getId());
        catDto.setName(cat.getName());
        dto.setCategory(catDto);
        return dto;
    }

    @Override
    public List<Medication> findMedicationByCategory(String category, LocalDate expirationAfter) {
        return medicationJpaRepository.findMedicationByCategory(category, expirationAfter);
    }

}
