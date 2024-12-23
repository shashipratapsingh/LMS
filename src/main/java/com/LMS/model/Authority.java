package com.LMS.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tbl_authority")
@Setter
@NoArgsConstructor
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
