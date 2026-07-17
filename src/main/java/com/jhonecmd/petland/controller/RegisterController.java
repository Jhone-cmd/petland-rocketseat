package com.jhonecmd.petland.controller;

import com.jhonecmd.petland.model.RegisterEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @PostMapping()
    public RegisterEntity register(@RequestBody RegisterEntity registerEntity){
        return registerEntity;
    }
}
