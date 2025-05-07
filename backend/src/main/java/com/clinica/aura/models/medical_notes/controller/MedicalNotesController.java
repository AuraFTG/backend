package com.clinica.aura.models.medical_notes.controller;

import com.clinica.aura.models.medical_notes.dtoRequest.MedicalNotesRequestDto;
import com.clinica.aura.models.medical_notes.dtoResponse.MedicalNotesResponseDto;
import com.clinica.aura.models.medical_notes.service.MedicalNotesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical-notes")
@RequiredArgsConstructor
@Tag(name = "Medical Notes", description = "Notas médicas asociadas a un historial clínico")
public class MedicalNotesController {

    private final MedicalNotesService service;

    @Operation(summary = "Crear una nota médica",
            description = "Crea una nueva nota médica asociada a un historial clínico existente.")
    @PostMapping("/create")
    public ResponseEntity<MedicalNotesResponseDto> create(@RequestBody MedicalNotesRequestDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @Operation(summary = "Obtener una nota médica por ID",
            description = "Devuelve una nota médica por su ID.")
    @GetMapping("/{id}")
    public ResponseEntity<MedicalNotesResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(summary = "Listar todas las notas médicas de un historial",
            description = "Obtiene todas las notas médicas asociadas a un historial clínico por su ID.")
    @GetMapping("/by-medical-record/{medicalRecordId}")
    public ResponseEntity<List<MedicalNotesResponseDto>> findAllByMedicalRecordId(@PathVariable Long medicalRecordId) {
        return ResponseEntity.ok(service.findAllByMedicalRecordId(medicalRecordId));
    }

    @Operation(summary = "Actualizar una nota médica",
            description = "Actualiza el contenido de una nota médica existente.")
    @PutMapping("/{id}")
    public ResponseEntity<MedicalNotesResponseDto> update(@PathVariable Long id, @RequestBody MedicalNotesRequestDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @Operation(summary = "Eliminar una nota médica",
            description = "Elimina una nota médica del sistema.")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Nota médica con ID " + id + " eliminada exitosamente.");
    }
}
