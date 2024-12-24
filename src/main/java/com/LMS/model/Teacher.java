package com.LMS.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "tbl_teacher")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 255)
    private String address;

    @Column(nullable = false)
    private LocalDate dob; // Date of Birth

    @Column(nullable = false)
    private LocalDate doj; // Date of Joining

    @Column(nullable = false, unique = true, length = 15)
    private String phoneNo;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 100)
    private String specialization; // Subject specialization

    @Column(nullable = false)
    private String designation; // Role like Professor, Lecturer, etc.

    @Column(nullable = false)
    private String department; // Department name

    private Double salary; // Monthly salary

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedBy;

    @Column(nullable = false)
    private Boolean isActive = true; // Active status of the teacher

    @PrePersist
    protected void onCreate() {
        this.createdBy = new Date();
        this.updatedBy = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedBy = new Date();
    }
}

