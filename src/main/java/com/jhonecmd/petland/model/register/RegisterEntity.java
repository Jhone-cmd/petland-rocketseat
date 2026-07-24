package com.jhonecmd.petland.model.register;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
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
@Table(name = "register")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Embedded
    private FullAddress fullAddress;

    @Enumerated(EnumType.STRING)
    private Profile profile;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    public RegisterEntity(String name, String email, FullAddress fullAddress, Profile profile) {
        this.name = name;
        this.email = email;
        this.fullAddress = fullAddress;
        this.profile = profile;
    }

    @PrePersist
    protected void onCreate() {
        this.createAt = LocalDateTime.now();

    }
}
