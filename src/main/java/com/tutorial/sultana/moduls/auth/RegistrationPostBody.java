package com.tutorial.sultana.moduls.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationPostBody {
    private String username;
    private String password;
    private String email;


}
