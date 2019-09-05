package com.sara.security.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    private static final Log logger = LogFactory.getLog(HomeResource.class);

    @GetMapping("/")
    public ResponseEntity<?> home() {
        return new ResponseEntity<>("<h1> Hello Welcome! </h1>", HttpStatus.OK);
    }

    @GetMapping(path = "/secure/user")
    public ResponseEntity<?> user() {
        if(logger.isDebugEnabled()) {
            logger.debug("**Authentication Object created : " + SecurityContextHolder.getContext().getAuthentication());
        }

        return new ResponseEntity<>("<h1> Hello Welcome User! </h1>", HttpStatus.OK);
    }

    @GetMapping(path = "/secure/admin")
    public ResponseEntity<?> admin() {
        return new ResponseEntity<>("<h1> Hello Welcome Admin! </h1>", HttpStatus.OK);
    }
}
