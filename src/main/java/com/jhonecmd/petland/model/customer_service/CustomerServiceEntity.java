package com.jhonecmd.petland.model.customer_service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "customer_service")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;
    private LocalDate date;
    private LocalTime time;
    private Double price;
    private Boolean emergency;

    @Enumerated(EnumType.STRING)
    private CustomerServiceStatus status;

    @Enumerated(EnumType.STRING)
    private  CustomerServiceType type;

    @Column(name = "client_id", nullable = false)
    private Integer client;

    @Column(name = "animal_id", nullable = false)
    private Integer animal;

    @Column(name = "service_id", nullable = false)
    private Integer service;

    public CustomerServiceEntity(String description, LocalDate date, LocalTime time,
                                 Double price, Boolean emergency, CustomerServiceStatus status, CustomerServiceType type,
                                 Integer client, Integer animal, Integer service) {
        this.description = description;
        this.date = date;
        this.time = time;
        this.price = price;
        this.emergency = emergency;
        this.status = status;
        this.type = type;
        this.client = client;
        this.animal = animal;
        this.service = service;

    }
}
