package com.pandi.mapping.relations.Controllers;

import com.pandi.mapping.relations.Dto.EmployeeModel;
import com.pandi.mapping.relations.Entities.Employee;
import com.pandi.mapping.relations.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//onetoone unidirectional controller
@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity saveEmployee(@RequestBody EmployeeModel employeeModel){

       Employee employee = employeeService.save(employeeModel);
       return new ResponseEntity(employee, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity getEmployees(){

        List<EmployeeModel> employeeList = employeeService.getEmployee();
        return new ResponseEntity(employeeList,HttpStatus.OK);
    }

}
