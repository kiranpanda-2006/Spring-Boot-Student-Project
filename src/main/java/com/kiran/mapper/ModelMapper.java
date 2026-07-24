package com.kiran.mapper;

import com.kiran.DTO.LoginDTO;
import com.kiran.DTO.StudentDTO;
import com.kiran.DTO.response.ResponseDTO;
import com.kiran.DTO.response.StudentResponseDTO;
import com.kiran.Entity.LoginEntity.User;
import com.kiran.Entity.Student;

import java.time.LocalDateTime;
import java.util.UUID;

public class ModelMapper {

    public static User mapToEntity(LoginDTO loginDTO){

        User user = new User();

        user.setName(loginDTO.getName());
        user.setEmail(loginDTO.getEmail());
        user.setPassword(loginDTO.getPassword());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        user.setDeleted(false);

        return user;
    }

    public static ResponseDTO mapToDto(User user){

        ResponseDTO respopnse = new ResponseDTO();

        respopnse.setName(user.getName());
        respopnse.setEmail(user.getEmail());
        respopnse.setPassword(user.getPassword());
        respopnse.setUpdatedAt(user.getUpdatedAt());
        respopnse.setCreatedAt(user.getCreatedAt());

        return respopnse;

    }

    public static Student mapToEntityStudent(StudentDTO student){
        Student oStudent = new Student();
        oStudent.setName(student.getName());
        oStudent.setEmail(student.getEmail());
        oStudent.setAcademicYear(student.getAcademicYear());
        oStudent.setCourses(student.getCourses());
        oStudent.setBranch(student.getBranch());
        oStudent.setRollNo(generateRollnumber());
        oStudent.setCreatedAt(LocalDateTime.now());
        oStudent.setUpdateAt(LocalDateTime.now());
        oStudent.setDob(student.getDob());
        return oStudent;
    }

    public static StudentResponseDTO mapToDtoStudent(Student student){

        StudentResponseDTO response = new StudentResponseDTO();

        response.setName(student.getName());
        response.setEmail(student.getEmail());
        response.setAcademicYear(student.getAcademicYear());
        response.setCourses(student.getCourses());
        response.setRollNo(student.getRollNo());
        response.setBranch(student.getBranch());
        response.setCreatedAt(student.getCreatedAt());
        response.setUpdateAt(student.getUpdateAt());
        response.setDob(student.getDob());


        return response;
    }



    private static String generateRollnumber(){
        Student student = new Student();
        String prefix = "240132";
        return prefix+String.format("%04d",student.getId());
    }
}
