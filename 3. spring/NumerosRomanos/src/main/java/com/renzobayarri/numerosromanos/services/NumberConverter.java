package com.renzobayarri.numerosromanos.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@Service
public class NumberConverter {

    private int[] numbers = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};

    private String[] romanLetter = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String convert(int number) {

        int rest = number;
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < numbers.length; i++){
            while(rest >= numbers[i]){
                resultBuilder.append(romanLetter[i]);
                rest -= numbers[i];
            }
        }

        return resultBuilder.toString();
    }
}
