package service;

import models.Student;
import repository.StudentsRepository;

import java.util.List;

public class StudentService {
    private static StudentsRepository studentsRepository;

    public StudentService() {
        studentsRepository = new StudentsRepository();
    }

    public void save(Student student){
        studentsRepository.save(student);
    }

    public void update(Student student){
        studentsRepository.update(student);
    }

    public Student getById(int id ){
        return studentsRepository.findById(id);
    }

    public void delete(int id){
        Student student = studentsRepository.findById(id);
        studentsRepository.delete(student);
    }

    public List<Student> findAll(){
        return studentsRepository.findAll();
    }

    public void deleteAll(){
        studentsRepository.deleteAll();
    }


}
