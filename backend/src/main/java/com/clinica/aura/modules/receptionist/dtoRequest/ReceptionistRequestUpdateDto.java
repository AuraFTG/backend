package com.clinica.aura.modules.receptionist.dtoRequest;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReceptionistRequestUpdateDto {

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El correo electrónica no es válido")
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}(\\.[A-Za-z]{2,})?$",
            message = "El email debe tener un dominio válido, como .com o .com.ar"
    )
    @Schema(description = "Correo electrónico del recepcionista", example = "juan.perez@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Schema(description = "Contraseña del recepcionista",requiredMode = Schema.RequiredMode.REQUIRED, example = "admin123")
    private String password;

    @NotBlank(message = "El DNI es obligatorio")
    @Pattern(regexp = "^\\d{8}$", message = "El DNI debe tener exactamente 8 dígitos numéricos")
    @Schema(description = "DNI del recepcionista", requiredMode = Schema.RequiredMode.REQUIRED, example = "12345678")
    private String dni;

    @NotBlank(message = "El nombre es obligatorio")
    @Schema(description = "Nombre del recepcionista", example = "Juan", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @NotBlank(message = "El apellido es obligatorio")
    @Schema(description = "Apellido del recepcionista", example = "Pérez", requiredMode = Schema.RequiredMode.REQUIRED)
    private String lastName;

    @Schema(description = "Número de teléfono del recepcionista", example = "+573001112233")
    private String phoneNumber;

    @NotBlank(message = "La localidad es obligatoria")
    @Schema(description = "Localidad del recepcionista", example = "Bogotá", requiredMode = Schema.RequiredMode.REQUIRED)
    private String locality;

    @NotBlank(message = "La dirección es obligatoria")
    @Schema(description = "Dirección del recepcionista", example = "Calle 1 # 1-1", requiredMode = Schema.RequiredMode.REQUIRED)
    private String address;

    @Past(message = "La fecha de nacimiento debe ser anterior a la fecha actual")
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Schema(description = "Fecha de nacimiento del recepcionista", example = "1990-05-20", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDate birthDate;

    @NotBlank(message = "El cuil es obligatorio")
    @Pattern(regexp = "^(20|23|24|27|30|33|34)-?\\d{8}-?\\d$", message = "CUIL inválido. Debe tener el formato XX-XXXXXXXX-X o 11 dígitos")
    @Schema(description = "Cuil del recepcionista", example = "20-12345678-9", requiredMode = Schema.RequiredMode.REQUIRED)
    private String cuil;
}
