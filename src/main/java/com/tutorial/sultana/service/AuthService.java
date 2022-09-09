package com.tutorial.sultana.service;

import com.tutorial.sultana.moduls.auth.AuthResponse;
import com.tutorial.sultana.moduls.auth.LoginPostBody;
import com.tutorial.sultana.moduls.auth.RegistrationPostBody;

public interface AuthService {
    AuthResponse registration(RegistrationPostBody registrationPostBody);

    AuthResponse login(LoginPostBody loginPostBody);
}
