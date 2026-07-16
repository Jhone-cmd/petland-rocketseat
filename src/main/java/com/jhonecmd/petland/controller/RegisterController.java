package com.jhonecmd.petland.controller;

import com.jhonecmd.petland.model.Register;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @PostMapping()
    public Register register(@RequestBody Register register){
        return register;
    }
}
