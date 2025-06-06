package com.clinica.aura.modules.medical_records.repository;

import com.clinica.aura.modules.medical_records.model.MedicalRecordsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MedicalRecordsRepository extends JpaRepository<MedicalRecordsModel,Long> {
    @Modifying
    @Query("DELETE FROM MedicalRecordsModel m WHERE m.patients.id = :patientId")
    void deleteByPatientId(@Param("patientId") Long patientId);

    @Query("SELECT COUNT(m) > 0 FROM MedicalRecordsModel m WHERE m.patients.id = :patientId")
    boolean existsByPatientId(Long patientId);

    Optional<MedicalRecordsModel> findByPatientsId(Long patientId);

    List<MedicalRecordsModel> findAllByOrderByCreatedAtAsc();


    @Query(value = """
        SELECT mr.* 
        FROM medical_records mr
        JOIN professional p 
          ON p.id = mr.created_by_professional_id
        JOIN person per 
          ON per.id = p.id
        WHERE (:specialty IS NULL        OR p.specialty = :specialty)
          AND (:date IS NULL             OR DATE(mr.created_at) = :date)
          AND (:professionalName IS NULL 
               OR LOWER(CONCAT(per.name, ' ', per.last_name)) LIKE CONCAT('%', LOWER(:professionalName), '%'))
        """,
            nativeQuery = true)
    List<MedicalRecordsModel> filterClinicalHistory(
            @Param("specialty")        String specialty,
            @Param("date")             LocalDate date,
            @Param("professionalName") String professionalName
    );

}
