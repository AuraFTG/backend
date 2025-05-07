package com.clinica.aura.models.medical_notes.model;

import com.clinica.aura.models.medical_records.model.MedicalRecordsModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "medical_notes")
public class MedicalNotesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false) // not null
    @JoinColumn(name = "medical_record_id", nullable = false)
    private MedicalRecordsModel medicalRecord;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(columnDefinition = "TEXT")
    private String description;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
