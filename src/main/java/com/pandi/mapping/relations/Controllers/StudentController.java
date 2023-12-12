package com.pandi.mapping.relations.Controllers;


import com.pandi.mapping.relations.Dto.StudentModel;
import com.pandi.mapping.relations.Entities.Student;
import com.pandi.mapping.relations.Entities.StudentDetails;
import com.pandi.mapping.relations.Services.StudentDetailService;
import com.pandi.mapping.relations.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

//onetoone Biidirectional controller

    @Autowired
    StudentService studentService;

    @Autowired
    StudentDetailService studentDetailService;
    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody StudentModel clientModel){

        HashMap<String,Object> model = new HashMap<>();

        Student student = new Student();
        student.setName(clientModel.getName());


        StudentDetails studentDetails = new StudentDetails();
        studentDetails.setHobby(clientModel.getCity());
        studentDetails.setCity(clientModel.getHobby());
        studentDetails.setStudent(student);

        studentDetailService.save(studentDetails);


        model.put("message","createdSuccessfully");
        return new ResponseEntity < > (model, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<?> getStudents() {
        HashMap<String, Object> model = new HashMap<>();
        List<Student> studentList = studentService.getStudents();
        List<StudentModel> clientModelList = new ArrayList<>();

        if (!studentList.isEmpty()) {
            studentList.forEach(student -> {
                StudentModel clientModel = new StudentModel();
                clientModel.setName(student.getName());
                clientModel.setCity(student.getStudentDetails().getCity());
                clientModel.setHobby(student.getStudentDetails().getHobby());
                clientModelList.add(clientModel);
            });

            model.put("data", clientModelList);
        } else {
            return new ResponseEntity<>(model, HttpStatus.NO_CONTENT);
        }


        return new ResponseEntity<>(model, HttpStatus.OK);
    }


    @GetMapping("/details")
    public ResponseEntity<?> getStudentDetails(){

        HashMap<String, Object> model = new HashMap<>();
        List<StudentDetails> studentList = studentDetailService.getStudentDetails();
        List<StudentModel> clientModelList = new ArrayList<>();

        if (!studentList.isEmpty()) {
            studentList.forEach(student -> {
                StudentModel clientModel = new StudentModel();
                clientModel.setName(student.getStudent().getName());
                clientModel.setCity(student.getCity());
                clientModel.setHobby(student.getHobby());
                clientModelList.add(clientModel);
            });

            model.put("data", clientModelList);
        } else {
            return new ResponseEntity<>(model, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PutMapping("/{studentId}/{cityName}")
    public ResponseEntity updateStudent(@PathVariable Integer studentId,@PathVariable String cityName){

        Student student = studentService.updateCityName(studentId,cityName);
        return new ResponseEntity(student.getStudentDetails().getCity(),HttpStatus.OK);

    }

    @PutMapping("/details/{studentDetailsId}/{name}")
    public ResponseEntity updateStudentDetails(@PathVariable Integer studentDetailsId,@PathVariable String name){

        StudentDetails student = studentDetailService.updateName(studentDetailsId,name);
        return new ResponseEntity(student.getStudent().getName(),HttpStatus.OK);

    }

}
