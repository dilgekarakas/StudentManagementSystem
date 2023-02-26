package edu.sabanciuniv.controller;

import edu.sabanciuniv.service.StudentService;
import edu.sabanciuniv.model.Student;

import java.util.List;

public class StudentController {

    public StudentService service = new StudentService();

    public List<Student> findAllStudents() {
        return service.findAll();
    }

    public Student findStudent(int id) {
        return service.find(id);
    }

    public void saveStudent(Student Student) {
        service.save(Student);
    }

    public void deleteStudent(Student Student) {
        service.delete(Student);
    }


}
