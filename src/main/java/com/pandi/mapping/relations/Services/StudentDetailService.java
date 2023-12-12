package com.pandi.mapping.relations.Services;


import com.pandi.mapping.relations.Entities.Student;
import com.pandi.mapping.relations.Entities.StudentDetails;
import com.pandi.mapping.relations.Repository.StudentDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDetailService {

    @Autowired
    private StudentDetailsRepo studentDetailsRepo;


    public List<StudentDetails> getStudentDetails(){
        return studentDetailsRepo.findAll();
    }

    public void save(StudentDetails student) {
        studentDetailsRepo.save(student);
    }

    public StudentDetails updateName(Integer studentDetailsId,String name){
        StudentDetails student = studentDetailsRepo.findById(studentDetailsId).get();
        System.out.println(student.getStudent().getName());
        student.getStudent().setName(name);
        return studentDetailsRepo.save(student);
    }

}
