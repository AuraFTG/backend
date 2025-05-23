package com.clinica.aura.modules.patient.dto;

import com.clinica.aura.modules.patient.dto.valid.ValidInsurance;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

/**
 * DTO para recibir y validar datos de entrada al registrar o actualizar un paciente.
 * Este DTO contiene datos personales, información de contacto, datos del tutor,
 * datos de la obra social (si corresponde), y referencias a profesionales y escuela.
 * Aplica validaciones estándar y una validación personalizada con {@link com.clinica.aura.modules.patient.dto.valid.ValidInsurance}
 * para garantizar coherencia entre los campos de seguro médico.
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ValidInsurance
public class PatientRequestDto {
    @NotBlank
    @Email(message = "Formato de email inválido")
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}(\\.[A-Za-z]{2,})?$",
            message = "El email debe tener un dominio válido, como .com o .com.ar"
    )
    @Schema(description = "Email del paciente", example = "9k6w5@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    // Datos de la persona
    @Pattern(regexp = "^[1-9]\\d{7}$", message = "El DNI solo debe tener números y maximo 8 caracteres")
    @Size(min =8, max=8, message = "El dni debe 8 caracteres")
    @NotBlank(message = "El DNI es obligatorio")
    @Schema(description = "DNI del paciente", requiredMode = Schema.RequiredMode.REQUIRED, example = "40650777")
    private String dni;

    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El nombre solo debe contener letras")
    @NotBlank
    @Schema(description = "Nombre del paciente", example = "Juan Carlos", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El apellido solo debe contener letras")
    @NotBlank
    @Schema(description = "Apellido del paciente", example = "Pérez", requiredMode = Schema.RequiredMode.REQUIRED)
    private String lastName;

    @Schema(description = "Teléfono del tutor del paciente. El teléfono esta pensado en modo argentino, se permite el mínimo de 8 números en caso de no agregar el 011 ", example = "02320484070, 1155150791, 01144697500", requiredMode = Schema.RequiredMode.REQUIRED)
    @Pattern(regexp = "^\\d{8,11}$", message = "El teléfono del tutor debe tener entre 8 y 11 dígitos numéricos")
    @NotBlank(message = "El teléfono del tutor es obligatorio")
    private String phoneNumber;

    @Past
    @Schema(description = "Fecha de nacimiento del paciente", example = "2015-05-20")
    private LocalDate birthDate;


    @Schema(description = "Indica el genero del paciente ", example = "femenino/masculino/otro (no permite otras palabras)")
    @Pattern(regexp = "^(?i)(femenino|masculino|otro)$", message = "El sexo debe ser 'femenino', 'masculino' u 'otro'")
    private String genre;

    @Schema(description = "Indica si el paciente tiene seguro médico", example = "true")
    private boolean hasInsurance;

    @Schema(description = "Nombre de la obra social (si tiene). Si no tiene, debe ser 'Particular'", example = "OSDE")
    private String insuranceName;

    @Schema(description = "Nombre del plan obra social del paciente", example = "210")
    private String insurancePlan;

    @Schema(description = "Número de afiliado en la obra social. Ej: OSDE (156150-06), Swiss Medical (000012345678), etc.")
    private String memberShipNumber;


    @Schema(description = "Dirección del paciente", example = "Av. Libertador 1925, CABA")
    @Size(min = 5, max = 30, message = "La dirección del paciente debe tener entre 5 y 30 caracteres.")
    @NotBlank(message = "La dirección es obligatoria")
    private String address;

    @Schema(description = "Nombre del tutor paciente", example = "Mariela Peres")
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$", message = "El nombre del tutor solo debe contener letras")
    @NotBlank(message = "El nombre del tutor es obligatoria")
    private String tutorName;

    @Schema(description = "Vinculo del tutor con el paciente. Madre, padre y/o tutor.No acepta otras palabras solo esas 3", example = "Madre, padre y/o tutor.")
    @Pattern(regexp = "^(?i)(madre|padre|tutor)$", message = "El vínculo debe ser 'madre', 'padre' o 'tutor'")
    @NotBlank(message = "La relación  del tutor con el paciente es obligatoria")
    private String relationToPatient;

    @Schema(description = "Los IDs de los Profesionales asignados al paciente", example = "[1, 2, 3]")
    private List<Long> professionalIds;

    @Schema(description = "ID de la escuela. Este campo no es obligatio considerando que los pacientes tienen entre 3 y 13 años inclusive por lo cual, " +
            "si el menor si tiene 3 años podría no estar escolarizado. En caso de estar escolarizado, primero debe crearse la escuela " +
            "y luego añadir acá el Id de la escuela", example = "1")
    private Long schoolId;

}
