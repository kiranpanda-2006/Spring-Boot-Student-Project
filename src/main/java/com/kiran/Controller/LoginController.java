package com.kiran.Controller;

import com.kiran.DTO.LoginDTO;
import com.kiran.DTO.login.UpdateLoginDTO;
import com.kiran.DTO.response.ResponseDTO;
import com.kiran.Exception.InvalidUserException;
import com.kiran.Exception.ResourceNotFoundException;
import com.kiran.Service.LoginService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {


    private final LoginService loginService;

    LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    private static final Logger log =
            LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@Valid @RequestBody LoginDTO user){
       ResponseDTO response =  loginService.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("/update")
    public ResponseEntity<String> update(@Valid @RequestBody UpdateLoginDTO user,
                                         @RequestParam("email") String email)
        throws ResourceNotFoundException {
        System.out.println("password controller: "+user.getPassword());
        loginService.update(email,user);
        return ResponseEntity.status(HttpStatus.OK).body("Password Updated Successfully.");
    }


    @DeleteMapping("/delete-permanent")
    public ResponseEntity<String> delete(@RequestParam("email") String email) throws InvalidUserException {
       String response =  loginService.deleteByEmail(email);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PatchMapping("/delete-temporary")
    public ResponseEntity<String> clearUser(String email) throws ResourceNotFoundException{
        loginService.clear(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User cleared Successfully.");
    }
}
