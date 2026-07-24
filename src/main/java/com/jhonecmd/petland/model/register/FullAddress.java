package com.jhonecmd.petland.model.register;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class FullAddress {

    @Column(length = 50)
    private String address;

    @Column(name = "nr", length = 50)
    private String number;

    public FullAddress(String address, String number) {
        this.address = address;
        this.number = number;
    }
}
