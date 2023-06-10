package com.karthikn.springdemo.student;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryStudentDao{
    private final List<Student> STUDENT = new ArrayList<>();
    public Student save(Student s) {
         STUDENT.add(s);
        return s;
    }
    public List<Student> findAllStudents() {
        return STUDENT;
//        return List.of(
//                new Student(1,"Karthi","kn", LocalDate.of(2001,9,11),"karthikn@gmail.com",21)
//                ,new Student(2,"Virat","kohli", LocalDate.of(1995,11,5),"viratk@gmail.com",29)
//        );
    }
public Student findByEmail(String email){
        return STUDENT.stream()
                .filter(s -> email.equals(s.getEmail()))
                .findFirst()
                .orElse(null);
}
public Student findById(int id){
        return STUDENT.stream()
                .filter(i -> id == i.getId())
                .findFirst()
                .orElse(null);
}

    public Student update(Student s) {
        var studentIndex = IntStream.range(0,STUDENT.size())
                .filter(index -> STUDENT.get(index).getEmail().equals(s.getEmail()))
                .findFirst()
                .orElse(-1);
        if ((studentIndex > -1)){
            STUDENT.set(studentIndex,s);
            return s;
        }
        return null;
    }
    public void delete(int id){
        var student = findById(id);
        if (student != null){
            STUDENT.remove(student);
        }
    }
}