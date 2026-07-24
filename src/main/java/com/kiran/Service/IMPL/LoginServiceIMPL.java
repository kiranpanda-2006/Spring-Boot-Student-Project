package com.kiran.Service.IMPL;

import com.kiran.DTO.LoginDTO;
import com.kiran.DTO.login.UpdateLoginDTO;
import com.kiran.DTO.response.ResponseDTO;
import com.kiran.Entity.LoginEntity.User;
import com.kiran.Exception.InvalidUserException;
import com.kiran.Exception.ResourceNotFoundException;
import com.kiran.Service.LoginService;
import com.kiran.mapper.ModelMapper;
import com.kiran.repository.LoginUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LoginServiceIMPL implements LoginService {

    private final LoginUserRepository loginRepository;
    LoginServiceIMPL(LoginUserRepository loginRepository){
        this.loginRepository = loginRepository;
    }
    @Override
    public ResponseDTO save(LoginDTO user) {
       User savetoDB = ModelMapper.mapToEntity(user);

       User responseUser = loginRepository.save(savetoDB);

       return  ModelMapper.mapToDto(responseUser);
    }

    @Override
    public String deleteByEmail(String email) throws InvalidUserException {
        boolean deleted = false;
        Optional<User> responseUser = loginRepository.findByEmail(email);
        if (responseUser.isEmpty()){
            throw new InvalidUserException("No user found of "+email);
        }
        loginRepository.delete(responseUser.get());

        deleted = true;

        if (!deleted){
            return "Some Error Occurred during deletion";
        }
        return "User Deleted Successfully.";
    }

    @Override
    public void update(String email, UpdateLoginDTO loginDTO) throws ResourceNotFoundException {
       Optional<User> optUser =  loginRepository.findByEmailAndDeletedIsFalse(email);
       if (optUser.isEmpty()){
           throw new ResourceNotFoundException("No user found With email "+email);
       }

       User user = optUser.get();

       user.setPassword(loginDTO.getPassword());
       user.setUpdatedAt(LocalDateTime.now());

        System.out.println("Password: "+loginDTO.getPassword());
       loginRepository.save(user);
    }

    @Override
    public void clear(String email) throws ResourceNotFoundException {
        Optional<User> optUser = loginRepository.findByEmailAndDeletedIsFalse(email);
        if (optUser.isEmpty()){
            throw new ResourceNotFoundException("No user exist with this email "+email);
        }
        User user  = optUser.get();
        user.setDeleted(true);
        loginRepository.save(user);
    }
}
