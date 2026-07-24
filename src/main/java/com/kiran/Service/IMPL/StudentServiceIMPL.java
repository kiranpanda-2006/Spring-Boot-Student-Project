package com.kiran.Service.IMPL;

import com.kiran.DTO.StudentDTO;
import com.kiran.DTO.response.StudentResponseDTO;
import com.kiran.Entity.Student;
import com.kiran.Service.StudentService;
import com.kiran.mapper.ModelMapper;
import com.kiran.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceIMPL implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceIMPL(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponseDTO save(StudentDTO student) {
        return ModelMapper
                .mapToDtoStudent(
                        studentRepository.save(
                ModelMapper
                        .mapToEntityStudent(student)));
    }
}
