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
public class CustomerService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;
    private LocalDate date;
    private LocalTime time;
    private Double price;
    private Boolean emergency;

}
