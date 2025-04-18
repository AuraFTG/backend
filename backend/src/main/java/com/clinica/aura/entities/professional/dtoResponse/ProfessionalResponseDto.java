package com.clinica.aura.entities.professional.dtoResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Getter


@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalResponseDto {

    @Schema(description = "ID del profesional", example = "1")
    private Long id;



    @Schema(description = "DNI del profesional", example = "12345678A")
    private String dni;

    @Schema(description = "Nombre del profesional", example = "John")
    private String name;

    @Schema(description = "Apellido del profesional", example = "Doe")
    private String lastName;

    @Schema(description = "Teléfono del profesional", example = "123456789")
    private String phoneNumber;

    @Schema(description = "País del profesional", example = "Spain")
    private String country;

    @Schema(description = "URL de la foto del profesional", example = "https://example.com/photo.jpg")
    private String photoUrl;

    @Schema(description = "Fecha de nacimiento del profesional", example = "1990-01-01")
    private LocalDate birthDate;

    @Schema(description = "Número de licencia del profesional", example = "12345678")
    private String licenseNumber;

    @Schema(description = "Especialidad del profesional", example = "Medicina")
    private String specialty;
}
