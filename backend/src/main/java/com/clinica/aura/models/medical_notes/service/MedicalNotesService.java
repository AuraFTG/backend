package com.clinica.aura.models.medical_notes.service;

import com.clinica.aura.models.medical_notes.dtoRequest.MedicalNotesRequestDto;
import com.clinica.aura.models.medical_notes.dtoResponse.MedicalNotesResponseDto;
import com.clinica.aura.models.medical_notes.model.MedicalNotesModel;
import com.clinica.aura.models.medical_notes.repository.MedicalNotesRepository;
import com.clinica.aura.models.medical_records.model.MedicalRecordsModel;
import com.clinica.aura.models.medical_records.repository.MedicalRecordsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class MedicalNotesService {

    private final MedicalNotesRepository medicalNotesRepository;
    private final MedicalRecordsRepository medicalRecordsRepository;

    public MedicalNotesResponseDto create(MedicalNotesRequestDto dto) {
        MedicalRecordsModel record = medicalRecordsRepository.findById(dto.getMedicalRecordId())
                .orElseThrow(() -> new EntityNotFoundException("Historia clínica con ID " + dto.getMedicalRecordId() + " no encontrada"));

        MedicalNotesModel note = MedicalNotesModel.builder()
                .medicalRecord(record)
                .date(dto.getDate())
                .description(dto.getDescription())
                .build();

        medicalNotesRepository.save(note);

        return mapToDto(note);
    }

    public MedicalNotesResponseDto findById(Long id) {
        MedicalNotesModel note = medicalNotesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nota médica con ID " + id + " no encontrada"));

        return mapToDto(note);
    }

    public List<MedicalNotesResponseDto> findAllByMedicalRecordId(Long medicalRecordId) {
        List<MedicalNotesModel> notes = medicalNotesRepository.findByMedicalRecordId(medicalRecordId);
        return notes.stream().map(this::mapToDto).toList();
    }

    public MedicalNotesResponseDto update(Long id, MedicalNotesRequestDto dto) {
        MedicalNotesModel note = medicalNotesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nota médica no encontrada"));

        note.setDate(dto.getDate());
        note.setDescription(dto.getDescription());

        medicalNotesRepository.save(note);

        return mapToDto(note);
    }

    public void delete(Long id) {
        MedicalNotesModel note = medicalNotesRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Nota médica no encontrada"));
        medicalNotesRepository.delete(note);
    }

    private MedicalNotesResponseDto mapToDto(MedicalNotesModel note) {
        return new MedicalNotesResponseDto(
                note.getId(),
                note.getMedicalRecord().getId(),
                note.getDate(),
                note.getDescription(),
                note.getCreatedAt(),
                note.getUpdatedAt()
        );
    }
}
