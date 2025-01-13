package com.secure.jwt.springsecurity.controller;

import com.secure.jwt.springsecurity.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sec-app")
public class StudentContrl {


    private List<Student> liftOfStudent = new ArrayList<>(List.of(new Student(1,30, "akash"),
            new Student(2,20,"rabi"),
            new Student(3,10, "kiran")));


    @GetMapping("/stdlist")
    public List<Student> getAllStudents(){
        return liftOfStudent;
    }


    @PostMapping("/save-student")
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        try{
            liftOfStudent.add(student);
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e,HttpStatus.BAD_REQUEST);
        }
    }
}
