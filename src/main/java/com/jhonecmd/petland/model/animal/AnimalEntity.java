package com.jhonecmd.petland.model.animal;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "animal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100)
    private String description;

    @Enumerated(EnumType.STRING)
    private AnimalSpecie specie;

    private LocalDate birthday;

    @Column(name = "tutor_id", nullable = false)
    private Integer tutor;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    public AnimalEntity(String name, String description, AnimalSpecie specie, LocalDate birthday, Integer tutor) {
        this.name = name;
        this.description = description;
        this.specie = specie;
        this.birthday = birthday;
        this.tutor = tutor;
    }

    @PrePersist
    protected void onCreate() {
        this.createAt = LocalDateTime.now();
    }

}
