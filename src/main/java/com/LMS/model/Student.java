package com.LMS.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 255)
    private String address;

    @Column(nullable = false, unique = true, length = 15)
    private String mobileNo;

    @Column(nullable = false, unique = true, length = 100)
    private String emailId;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date admissionDate;

    @Column(nullable = false, length = 100)
    private String course;

    @Column(nullable = false, length = 100)
    private String branch;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedBy;

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
