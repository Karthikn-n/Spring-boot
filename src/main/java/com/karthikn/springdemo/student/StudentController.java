package com.karthikn.springdemo.student;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    /*    @Autowired
    private StudentService studentService; this a field injection.
    @Autowired //this is constructor type injection
    It is inside the bean annotation it will
    automatically injected once it find the service
    */
    public StudentController(@Qualifier("db") StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student save(@RequestBody Student student)
    {
        return studentService.save(student);
    }
    @GetMapping("/email/{email}")
    public Student findByEmail(@PathVariable("email") String email){
        return studentService.findByEmail(email);
    }
    @GetMapping("/id/{id}")
    public Student findById(@PathVariable("id") int id){
        return studentService.findById(id);
    }
    @GetMapping
    public List<Student> findAllStudents(){

        return  studentService.findAllStudents();
    }
    @PutMapping
    public Student updateStudent(@RequestBody Student student){
        return studentService.update(student);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id)
    {
        studentService.delete(id);
    }
}
