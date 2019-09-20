package com.students.catalog.repository.repo;

import com.students.catalog.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepo extends JpaRepository<Student, Long> {

    @Modifying
    @Transactional
    long deleteStudentById(Long id);
}
