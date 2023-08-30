package com.icc.daelimbada.user.service;

import com.icc.daelimbada.user.domain.User;
import com.icc.daelimbada.user.dto.LoginDTO;

public interface UserService {
    LoginDTO saveUser(User user);

}
