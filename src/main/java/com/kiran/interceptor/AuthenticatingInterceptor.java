package com.kiran.interceptor;

import com.kiran.Exception.responseDTO.ExceptionResponseDTO;
import com.kiran.repository.LoginUserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class AuthenticatingInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginUserRepository loginUserRepository;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)
            throws Exception {

        String email  = request.getHeader("email");

        if (request.getHeader("email") == null || email.isBlank()){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(
                    "{\n" +
                            "    \"Warning\":\"please give email in header.\n" +
                            "}"
            );
            return  false;
        }
       boolean exist = loginUserRepository.existsByEmailAndDeletedIsFalse(email);
        if (!exist){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(
                    "{\n" +
                            "    \"message\":\"Login first.\n" +
                            "}"
            );
            return false;
        }



        return true;
    }
}
