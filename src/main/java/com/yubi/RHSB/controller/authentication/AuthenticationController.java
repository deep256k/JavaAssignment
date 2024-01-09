package com.yubi.RHSB.controller.authentication;

import com.yubi.RHSB.model.AuthRequest;
import com.yubi.RHSB.service.authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@RequestMapping("/api")
public class AuthenticationController  {

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) {
        try{
            final String jwt = authenticationService.generateToken(authRequest.getUsername(), authRequest.getPassword());
            return ResponseEntity.ok(jwt);
        }catch(Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
