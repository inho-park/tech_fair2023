package com.icc.daelimbada.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JoinDTO {
    private String username;
    private String password;
    private String email;
}
