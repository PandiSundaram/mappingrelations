package com.pandi.mapping.relations.Services;


import com.pandi.mapping.relations.Dto.EmployeeModel;
import com.pandi.mapping.relations.Entities.Address;
import com.pandi.mapping.relations.Entities.Employee;
import com.pandi.mapping.relations.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepo employeeRepo;
    public Employee save(EmployeeModel employeeModel){
        Employee employee = new Employee();
        employee.setEmpName(employeeModel.getEmpName());
        Address address = new Address();
        address.setCity(employeeModel.getCity());
        employee.setAddress(address);
        return employeeRepo.save(employee);
    }

    public List<EmployeeModel> getEmployee(){

        List<Employee> employeeList = employeeRepo.findAll();
        System.out.println("pandi"+ employeeList.isEmpty());
        List<EmployeeModel> employeeModelList = new ArrayList<>();

        if(!employeeList.isEmpty()){
            employeeList.forEach(employee -> {
                EmployeeModel employeeModel = new EmployeeModel();
                employeeModel.setEmpName(employee.getEmpName());
                employeeModel.setCity(employee.getAddress().getCity());
                employeeModelList.add(employeeModel);
            });
        }

        return employeeModelList;
    }

}
