package com.jhonecmd.petland.dto;

import com.jhonecmd.petland.model.Address;
import com.jhonecmd.petland.model.Profile;
import lombok.Data;

@Data
public class RegisterDTO {

    private String name;
    private String email;
    private Address address;
    private Profile profile;

}
