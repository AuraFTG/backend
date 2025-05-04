package com.clinica.aura.models.medical_notes.repository;

import com.clinica.aura.models.medical_notes.model.MedicalNotesModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalNotesRepository extends JpaRepository<MedicalNotesModel, Long> {

    List<MedicalNotesModel> findByMedicalRecordId(Long medicalRecordId);
}
