package com.sdjz.cqbms.entity.ao;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginBody {
    private String username;

    private String password;

    private String code;

    private String uuid;
}
