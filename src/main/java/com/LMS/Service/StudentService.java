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

    public Student partialUpdateStudent(Long id, Student student) {
        Student studentById = getStudentById(id);

        if (student.getName() != null) student.setName(student.getName());
        if (student.getAddress() != null) student.setAddress(student.getAddress());
        if (student.getMobileNo() != null) student.setMobileNo(student.getMobileNo());
        if (student.getEmailId() != null) student.setEmailId(student.getEmailId());
        if (student.getAdmissionDate() != null) student.setAdmissionDate(student.getAdmissionDate());
        if (student.getCourse() != null) student.setCourse(student.getCourse());
        if (student.getBranch() != null) student.setBranch(student.getBranch());

        return studentRepository.save(studentById);
    }

    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }
}
