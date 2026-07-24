package com.kiran.Service;

import com.kiran.DTO.StudentDTO;
import com.kiran.DTO.response.StudentResponseDTO;

public interface StudentService {

    StudentResponseDTO save(StudentDTO student);
}
