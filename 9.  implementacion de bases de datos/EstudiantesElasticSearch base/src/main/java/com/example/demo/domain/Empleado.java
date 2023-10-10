package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Document(indexName = "empleados")
@TypeAlias("empleado")
public class Empleado {
    @Id
    private String id;

    @Field(fielddata = true, type = FieldType.Text)
    private String nombre;

    @Field(type = FieldType.Text)
    private String edad;

    @Field(type = FieldType.Text)
    private String ciudad;

    @Field(type = FieldType.Text)
    private String email;

    @Field(type = FieldType.Text)
    private List<String> mascotas;
}
