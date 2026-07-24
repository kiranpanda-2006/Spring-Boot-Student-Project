package com.kiran.Exception;

import com.kiran.Exception.responseDTO.ExceptionResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<ExceptionResponseDTO> handleInvalidUserException(
            InvalidUserException e,
            HttpServletRequest request
    ){
        ExceptionResponseDTO response = new ExceptionResponseDTO(
                LocalTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI()
        );
        request.getPathInfo();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleResourceNotFoundException(
            ResourceNotFoundException e,
            HttpServletRequest request
    ){


        ExceptionResponseDTO response = new ExceptionResponseDTO(
                LocalTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI()
        );
        request.getPathInfo();
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDTO> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException e,
            HttpServletRequest request
            ){
        String message = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() +" : "+error.getDefaultMessage())
                .collect(Collectors.joining(" , "));

        ExceptionResponseDTO response = new ExceptionResponseDTO(
                LocalTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                message,
                request.getRequestURI()
        );

        System.out.println(response);
        request.getPathInfo();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponseDTO> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException e,
            HttpServletRequest request){

        ExceptionResponseDTO response = new ExceptionResponseDTO(
                LocalTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "give the value of the branch and course in upper letter.",
                request.getRequestURI()

        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }


//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<ExceptionResponseDTO> handleRuntimeException(
//            RuntimeException e,
//            HttpServletRequest request){
//        ExceptionResponseDTO response = new ExceptionResponseDTO(
//                LocalTime.now(),
//                HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
//                e.getMessage(),
//                request.getRequestURI()
//        );
//        request.getPathInfo();
//
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(response);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ExceptionResponseDTO> handleGenericException(
//            Exception e,
//            HttpServletRequest request){
//        ExceptionResponseDTO response = new ExceptionResponseDTO(
//                LocalTime.now(),
//                HttpStatus.INTERNAL_SERVER_ERROR.value(),
//                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
//                "Something went wrong, Try again Later",
//                request.getRequestURI()
//
//        );
//        request.getPathInfo();
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(response);
//    }



}
