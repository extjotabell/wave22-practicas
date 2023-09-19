package com.example.be_java_hisp_w22_g02.validations;

public interface IValidator<T> {
    boolean valid(T entity);
}
