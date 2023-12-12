package com.pandi.mapping.relations.Services;


import com.pandi.mapping.relations.Entities.Employee;
import com.pandi.mapping.relations.Entities.Student;
import com.pandi.mapping.relations.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    @Autowired
    private StudentRepo studentRepo;

    public void save(Student student) {
        studentRepo.save(student);
    }

    public List<Student> getStudents(){
        return studentRepo.findAll();
    }

    public Student updateCityName(Integer studentId,String cityName){
       Student student = studentRepo.findById(studentId).get();
       System.out.println(student.getStudentDetails().getCity());
       student.getStudentDetails().setCity(cityName);
       return studentRepo.save(student);
    }

}
