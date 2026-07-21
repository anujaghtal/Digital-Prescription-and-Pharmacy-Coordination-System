package com.dpcs.service;

import com.dpcs.dto.LoginRequest;
import com.dpcs.dto.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);

}