package com.pandi.mapping.relations.Repository;

import com.pandi.mapping.relations.Entities.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentDetailsRepo extends JpaRepository<StudentDetails,Integer> {
}
