package com.example.snapshot.Repo;

import com.example.snapshot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
