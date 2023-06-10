package com.karthikn.springdemo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


public interface StudentService {

    Student save(Student s);
     List<Student> findAllStudents();
    Student findByEmail(String email);
    Student findById(int id);
    Student update(Student s);

    void delete(int id);
//    public List<Student> findAllStudents()
//    {
//        return List.of(
//                new Student("Karthi","kn", LocalDate.of(2001,9,11),"karthikn@gmail.com",21)
//                ,new Student("Virat","kohli", LocalDate.of(1995,11,5),"viratk@gmail.com",29)
//        );
    }

