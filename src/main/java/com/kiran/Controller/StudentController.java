package com.kiran.Controller;

import com.kiran.DTO.StudentDTO;
import com.kiran.DTO.response.StudentResponseDTO;
import com.kiran.Entity.Student;
import com.kiran.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping("/admit")
    public ResponseEntity<StudentResponseDTO> addStudent(@RequestBody StudentDTO student){

       StudentResponseDTO response = studentService.save(student);

//        System.out.println(student.getName());
//        System.out.println(student.getEmail());
//        System.out.println(student.getDob());
//        System.out.println(student.getCourses());
//        System.out.println(student.getBranch());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
