package com.example.relacionesjpa.dto.ManyToMany;

import com.example.relacionesjpa.entity.ManyToMany.Course;
import lombok.Data;

import java.util.Set;

@Data
public class StudentDTO {
    private Long id;
    private Set<CourseDTO> linkedCourses;
}
