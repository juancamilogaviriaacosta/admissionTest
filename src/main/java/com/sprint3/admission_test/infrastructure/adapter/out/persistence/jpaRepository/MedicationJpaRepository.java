package com.sprint3.admission_test.infrastructure.adapter.out.persistence.jpaRepository;

import com.sprint3.admission_test.domain.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MedicationJpaRepository extends JpaRepository<Medication, Long> {

    @Query(value = "SELECT m.id, m.name, m.description, m.price, m.expiration_date, m.category_id\n" +
            "FROM medications m\n" +
            "INNER JOIN categories c ON m.category_id = c.id\n" +
            "WHERE c.name = :name\n" +
            "AND m.expiration_date >= :expirationAfter", nativeQuery = true)
    //@Query("SELECT m FROM Medication m WHERE m.category.name = :name AND m.expiration > :expirationAfter")
    List<Medication> findMedicationByCategory(
            @Param("name") String name, @Param("expirationAfter")  LocalDate expirationAfter);
}
