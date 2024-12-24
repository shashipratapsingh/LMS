package com.LMS.Service;

import com.LMS.GlobleExceptions.ResourceNotFoundException;
import com.LMS.model.Teacher;
import com.LMS.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id: " + id));
    }

    public List<Teacher> getAllTeachers(Pageable pageable) {
        return teacherRepository.findAll(pageable).getContent();
    }

    public Teacher updateTeacher(Long id, Teacher updatedTeacher) {
        Teacher teacher = getTeacherById(id);
        teacher.setName(updatedTeacher.getName());
        teacher.setAddress(updatedTeacher.getAddress());
        teacher.setDob(updatedTeacher.getDob());
        teacher.setDoj(updatedTeacher.getDoj());
        teacher.setPhoneNo(updatedTeacher.getPhoneNo());
        teacher.setEmail(updatedTeacher.getEmail());
        teacher.setSpecialization(updatedTeacher.getSpecialization());
        teacher.setDesignation(updatedTeacher.getDesignation());
        teacher.setDepartment(updatedTeacher.getDepartment());
        teacher.setSalary(updatedTeacher.getSalary());
        teacher.setIsActive(updatedTeacher.getIsActive());
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        Teacher teacher = getTeacherById(id);
        teacherRepository.delete(teacher);
    }
}
