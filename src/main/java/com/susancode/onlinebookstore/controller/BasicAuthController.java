package com.susancode.onlinebookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
@RestController
public class BasicAuthController {
    @GetMapping("/public/secureAPI")
    public ResponseEntity securedApi(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
            return new ResponseEntity<>("Authentication passed", HttpStatus.OK);
        }
        return new ResponseEntity("Unauthorized", HttpStatus.UNAUTHORIZED);
    }
}


