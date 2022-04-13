package com.sambit.Controller;

import com.sambit.Model.Student;
import com.sambit.Repository.StudentRepository;
import com.sambit.Service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/studentAPI")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @GetMapping(value = "/getAllStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

}
