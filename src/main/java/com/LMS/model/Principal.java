package com.LMS.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_principal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Principal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 15)
    private String phoneNo;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private Date dob; // Date of Birth

    @Column(nullable = false)
    private Date doj; // Date of Joining

    @Column(nullable = false, length = 100)
    private String qualifications; // Academic qualifications

    @Column(nullable = false, length = 50)
    private String specialization; // Subject or area of expertise

    @Column(nullable = false)
    private Double salary; // Monthly salary

    @Column(nullable = false)
    private String department; // Department they oversee

    @Column(nullable = false)
    private String designation; // Role (e.g., "Principal", "Head Principal")

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(nullable = false)
    private Boolean isActive = true; // Status of the principal

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}