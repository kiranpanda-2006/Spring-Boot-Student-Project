package com.kiran.Service;

import com.kiran.DTO.LoginDTO;
import com.kiran.DTO.login.UpdateLoginDTO;
import com.kiran.DTO.response.ResponseDTO;
import com.kiran.Exception.InvalidUserException;
import com.kiran.Exception.ResourceNotFoundException;

public interface LoginService {

     ResponseDTO save(LoginDTO user);

     String deleteByEmail(String email) throws InvalidUserException;

     void update(String email, UpdateLoginDTO loginDTO) throws ResourceNotFoundException;

     void clear(String email) throws ResourceNotFoundException;
}
