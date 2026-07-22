package com.jhonecmd.petland.model.animal;

import com.jhonecmd.petland.model.register.FullAddress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Column(name = "create_at")
    private LocalDateTime createAt;

    public AnimalEntity(String name, String description, AnimalSpecie specie, LocalDate birthday) {
        this.name = name;
        this.description = description;
        this.specie = specie;
        this.birthday = birthday;
    }

    @PrePersist
    protected void onCreate() {
        this.createAt = LocalDateTime.now();
    }

}
