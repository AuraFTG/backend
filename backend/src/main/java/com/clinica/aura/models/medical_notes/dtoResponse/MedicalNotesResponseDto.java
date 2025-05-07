package com.clinica.aura.models.medical_notes.dtoResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalNotesResponseDto {

    @Schema(description = "ID de la nota médica", example = "1001")
    private Long id;

    @Schema(description = "ID del historial médico relacionado", example = "1")
    private Long medicalRecordId;

    @Schema(description = "Fecha de la nota médica", example = "2024-05-04T10:30:00")
    private LocalDateTime date;

    @Schema(description = "Descripción de la nota médica", example = "Se realizó control de presión arterial y signos vitales.")
    private String description;

    @Schema(description = "Fecha de creación del registro", example = "2024-05-04T10:31:00")
    private LocalDateTime createdAt;

    @Schema(description = "Fecha de la última actualización del registro", example = "2024-05-04T11:00:00")
    private LocalDateTime updatedAt;
}
