package com.kiran.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class LoggingFilter implements Filter {


    private final Logger log = LoggerFactory.getLogger(LoggingFilter.class);

    static int count = 0;
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        if (request.getMethod().equals("POST") && request.getRequestURI().equals("/student/admit")){
            count++;
            if (count >=3){
                response.setStatus(429);
                response.getWriter()
                        .write(
                                "{\n" +
                                        "    \"Warning\":\"Too Many Requests," +
                                        " Try Again After sometime..\n" +
                                        "}"
                        );

                try {
                    Thread.sleep(2000);
                    return;
                }catch (Exception e){}
            }
        }

        log.info("Remote Address:"+servletRequest.getRemoteAddr());
        log.info("Request Method"+request.getMethod()+ LocalDateTime.now());
        log.info("Path info:"+request.getRequestURI()+LocalDateTime.now());

        System.out.println(count);

        chain.doFilter(servletRequest,servletResponse);
    }
}
