package com.sara.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @GetMapping("/")
    public ResponseEntity<?> home() {
        return new ResponseEntity<>("<h1> Hello Welcome! </h1>", HttpStatus.OK);
    }

    @GetMapping(path = "/secure/user")
    public ResponseEntity<?> user() {
        return new ResponseEntity<>("<h1> Hello Welcome User! </h1>", HttpStatus.OK);
    }

    @GetMapping(path = "/secure/admin")
    public ResponseEntity<?> admin() {
        return new ResponseEntity<>("<h1> Hello Welcome Admin! </h1>", HttpStatus.OK);
    }
}
