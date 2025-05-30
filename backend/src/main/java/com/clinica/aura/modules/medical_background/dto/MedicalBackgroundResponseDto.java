package com.clinica.aura.modules.medical_background.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MedicalBackgroundResponseDto {

    @Schema(description = "ID del antecedente médico", example = "1")
    private Long id;

    @Schema(description = "ID del paciente asociado", example = "1")
    private Long patientId;


    @Schema(description = "Lista de alergias del paciente", example = "[\"Polen\", \"Penicilina\"]")
    private List<String> allergies;

    @Schema(description = "Lista de discapacidades del paciente", example = "[\"Dislexia\"]")
    private List<String> disabilities;

    @Schema(description = "Fecha de creación")
    private LocalDateTime createdAt;

    @Schema(description = "Fecha de modificación")
    private LocalDateTime updatedAt;

}
