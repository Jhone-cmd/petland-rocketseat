package com.jhonecmd.petland.dto;

import com.jhonecmd.petland.model.FullAddress;
import com.jhonecmd.petland.model.Profile;
import lombok.Data;

@Data
public class RegisterDTO {

    private String name;
    private String email;
    private FullAddress fullAddress;
    private Profile profile;

}
