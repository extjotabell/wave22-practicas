package com.renzobayarri.obrasliterarias.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "obras_literarias")
@Getter
@Setter
public class ObraLiteraria {

    @Id
    private String id;

    @Field
    private String name;

    @Field
    private String author;

    @Field
    private int pages;

    @Field
    private String publisher;

    @Field
    private int firstPublicationYear;

}
