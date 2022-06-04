package com.aptech.t2012a.springhello.controller;
import com.aptech.t2012a.springhello.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "api/hello")
public class helloController {
    @RequestMapping(path = "world", method = RequestMethod.GET)
    public String say() { return "Hello ";}

    @RequestMapping(path = "talk", method = RequestMethod.GET)
    public String talk(){ return "Talk to ";}

    @RequestMapping(path = "student", method = RequestMethod.GET)
    public Student GetStudent(){
        return Student.builder()
                .rollNumber("T1")
                .fullName("tuannguyen")
                .phone("0987654321")
                .address("sam son")
                .dob(LocalDateTime.of(1996, 12, 28, 12, 50))
                .build();
    }
    
}
