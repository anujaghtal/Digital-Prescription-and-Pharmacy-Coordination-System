package com.dpcs.service;

import com.dpcs.dto.UserRequest;
import com.dpcs.entity.User;

public interface UserService {

    User registerUser(UserRequest request);

}