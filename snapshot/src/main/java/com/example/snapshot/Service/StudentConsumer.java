package com.example.snapshot.Service;

import com.example.snapshot.Repo.StudentRepo;
import com.example.snapshot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentConsumer {

    @Autowired
    private StudentRepo studentRepo;

    public void handleMessage(Object msg) {
        String s = msg.toString();
        Student student = new Student();
        student.setMessage(s);
        studentRepo.save(student);
    }
}
