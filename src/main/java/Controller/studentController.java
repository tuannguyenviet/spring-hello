package com.aptech.t2012a.springhello.controller;
import com.aptech.t2012a.springhello.entity.Student;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * http://localhost:8080/api/V1/students      |   GET     |
 * http://localhost:8080/api/V1/students      |   POST    |
 * http://localhost:8080/api/V1/students/1    |   DELETE  |
 * http://localhost:8080/api/V1/students/1    |   GET     |
 * http://localhost:8080/api/V1/students/1    |   PUT     |
 */
@RestController
@RequestMapping(path = "api/v1/students")
public class studentController {
    //CRUD
    private static List<Student> list;
    public studentController(){
        list = new ArrayList<>();
        list.add(Student.builder().rollNumber("T1").fullName("TUAN").build());

        list.add(Student.builder().rollNumber("T2").fullName("NGUYEN").build());
        list.add(Student.builder().rollNumber("T3").fullName("VIET").build());
        list.add(Student.builder().rollNumber("T4").fullName("TU").build());
        list.add(Student.builder().rollNumber("T5").fullName("NAM").build());
    }
    @RequestMapping(method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
        list.add(student);
        return student;
    }
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public Student findById(@PathVariable String id){
        int foundIndex = -1;
        for (int i = 0; i < list.size(); i++){
            foundIndex = i;
            break;
        }
        if (foundIndex == -1){
            return null;
        }
        return list.get(foundIndex);
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public boolean deleteById( @PathVariable String id){
        int foundIndex = -1;
        for (int i = 0; i < list.size(); i++){
            foundIndex = i;
            break;
        }
        if (foundIndex == -1){
            return false;
        }
        list.remove(foundIndex);
        return true;
    }
    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public Student update(@PathVariable String id, @RequestBody Student updateStudent){
        int foundIndex = -1;
        for (int i = 0; i < list.size(); i++){
            foundIndex = i;
            break;
        }
        if (foundIndex == -1){
            return null;
        }
        Student exiting = list.get(foundIndex);
        exiting.setFullName(updateStudent.getFullName());
        return exiting;
    }
}