package com.abhishek.journalApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Health {

    @GetMapping (path = "/check")
    public String chek(){
        return "ok";
    }
}
