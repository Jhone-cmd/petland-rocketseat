package com.jhonecmd.petland.dto;

import com.jhonecmd.petland.model.customer_service.CustomerServiceStatus;
import com.jhonecmd.petland.model.customer_service.CustomerServiceType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CustomerServiceDTO {

    private String description;
    private LocalDate date;
    private LocalTime time;
    private Double price;
    private Boolean emergency;
    private CustomerServiceStatus status;
    private CustomerServiceType type;
    private Integer client;
    private Integer animal;
    private  Integer service;

}
