package com.clinica.aura.models.medical_notes.dtoRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalNotesRequestDto {

    @Positive(message = "El ID del historial médico debe ser un número positivo")
    @NotNull(message = "El ID del historial médico es obligatorio")
    @Schema(description = "ID del historial médico al que pertenece esta nota", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long medicalRecordId;

    @NotNull(message = "La fecha de la nota es obligatoria")
    @Schema(description = "Fecha y hora en que se realizó la nota médica", example = "2024-05-04T10:30:00")
    private LocalDateTime date;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(max = 2000, message = "La descripción no puede tener más de 2000 caracteres")
    @Schema(description = "Descripción de la nota médica", example = "El paciente presenta mejoría en su estado general.")
    private String description;
}
