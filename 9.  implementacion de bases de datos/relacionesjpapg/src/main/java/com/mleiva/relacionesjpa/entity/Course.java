package com.mleiva.relacionesjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    // es usada para la relacion muchos a muchos con Student
    @ManyToMany(mappedBy = "likedCourses")
    private Set<Student> likes;
}
