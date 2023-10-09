package com.mleiva.relacionesjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    // Relacion muchos a muchos con la Clase Course
    @ManyToMany
    @JoinTable( // JoinTable se usa del lado propietario de la relacion para setear la tabla intermedia
            name="course_like", // nombre de la nueva tabla
            joinColumns = @JoinColumn(name = "student_id"), // se usa para definir la columna en la tabla externa que apunta al id de la clase propietaria
            inverseJoinColumns = @JoinColumn(name = "course_id") // define la columna en la tabla externa que apunta al id de la tabla inversa de la asociacion
    )
    private Set<Course> likedCourses;
}
