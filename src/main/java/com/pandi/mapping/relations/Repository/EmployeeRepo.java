package com.pandi.mapping.relations.Repository;

import com.pandi.mapping.relations.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {


    @Query(nativeQuery = true,value = "SELECT * FROM mappingpractice.employee LEFT JOIN mappingpractice.address ON employee.emp_id = address.aid")
    public List<Employee> findallemp();


}
