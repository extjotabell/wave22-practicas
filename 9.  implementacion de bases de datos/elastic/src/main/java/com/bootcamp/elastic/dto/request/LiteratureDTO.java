package com.bootcamp.elastic.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LiteratureDTO {
    private String id;

    private String name;

    private String author;

    private int pages;

    private String publisher;

    private int firstPublicationYear;
}
