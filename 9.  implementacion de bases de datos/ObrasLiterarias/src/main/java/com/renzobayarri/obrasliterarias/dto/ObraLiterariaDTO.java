package com.renzobayarri.obrasliterarias.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObraLiterariaDTO {

    private String id;

    private String name;

    private String author;

    private int pages;

    private String publisher;

    private int firstPublicationYear;
}
