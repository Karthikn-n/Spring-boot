package com.karthikn.springdemo.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("in")
public class InMemoryStudentService implements StudentService{
    private final InMemoryStudentDao inMemoryStudentDao;
    public InMemoryStudentService(InMemoryStudentDao inMemoryStudentDao) {
        this.inMemoryStudentDao = inMemoryStudentDao;
    }
    @Override
    public Student save(Student s) {
        return inMemoryStudentDao.save(s);
    }
    @Override
    public List<Student> findAllStudents() {
        return inMemoryStudentDao.findAllStudents();
//        return List.of(
//                new Student(1,"Karthi","kn", LocalDate.of(2001,9,11),"karthikn@gmail.com",21)
//                ,new Student(2,"Virat","kohli", LocalDate.of(1995,11,5),"viratk@gmail.com",29)
//        );
    }
    @Override
    public Student findByEmail(String email) {
        return inMemoryStudentDao.findByEmail(email);
    }
    @Override
    public Student findById(int id){
        return inMemoryStudentDao.findById(id);
    }
    @Override
    public Student update(Student s) {
        return inMemoryStudentDao.update(s);
    }
    @Override
    public void delete(int id){
        inMemoryStudentDao.delete(id);
    }
}
