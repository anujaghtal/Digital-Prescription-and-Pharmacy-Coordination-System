package com.dpcs.controller;

import com.dpcs.dto.LoginRequest;
import com.dpcs.dto.LoginResponse;
import com.dpcs.security.JwtService;
import com.dpcs.service.AuthService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    
    //with authservice.java
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
    
   /* without authservice.java
  private final AuthenticationManager authenticationManager;
  private final JwtService jwtService;

  public AuthController(
          AuthenticationManager authenticationManager,
          JwtService jwtService) {

      this.authenticationManager = authenticationManager;
      this.jwtService = jwtService;
  }

  @PostMapping("/login")
  public LoginResponse login(@RequestBody LoginRequest request) {

      authenticationManager.authenticate(

              new UsernamePasswordAuthenticationToken(

                      request.getEmail(),
                      request.getPassword()

              )

      );

      String token = jwtService.generateToken(request.getEmail());

      return new LoginResponse(token, "Login Successful");
  }

 */

}