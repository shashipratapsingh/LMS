package com.LMS.Service;

import com.LMS.GlobleExceptions.ResourceNotFoundException;
import com.LMS.model.Student;
import com.LMS.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Page<Student> getStudentsWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return studentRepository.findAll(pageable);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = getStudentById(id);

        student.setName(studentDetails.getName());
        student.setAddress(studentDetails.getAddress());
        student.setMobileNo(studentDetails.getMobileNo());
        student.setEmailId(studentDetails.getEmailId());
        student.setAdmissionDate(studentDetails.getAdmissionDate());
        student.setCourse(studentDetails.getCourse());
        student.setBranch(studentDetails.getBranch());

        return studentRepository.save(student);
    }

    public Student partialUpdateStudent(Long id, Student partialDetails) {
        Student student = getStudentById(id);

        if (partialDetails.getName() != null) student.setName(partialDetails.getName());
        if (partialDetails.getAddress() != null) student.setAddress(partialDetails.getAddress());
        if (partialDetails.getMobileNo() != null) student.setMobileNo(partialDetails.getMobileNo());
        if (partialDetails.getEmailId() != null) student.setEmailId(partialDetails.getEmailId());
        if (partialDetails.getAdmissionDate() != null) student.setAdmissionDate(partialDetails.getAdmissionDate());
        if (partialDetails.getCourse() != null) student.setCourse(partialDetails.getCourse());
        if (partialDetails.getBranch() != null) student.setBranch(partialDetails.getBranch());

        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }
}
