package com.jhonecmd.petland.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class FullAddress {

    @Column(length = 50)
    private String address;

    @Column(name = "nr", length = 50)
    private String number;
}
