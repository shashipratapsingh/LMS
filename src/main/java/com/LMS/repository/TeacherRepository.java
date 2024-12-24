package com.LMS.repository;

import com.LMS.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByDepartment(String department);
    List<Teacher> findByNameContaining(String name);
    List<Teacher> findByDesignation(String designation);
}
