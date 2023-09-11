package com.bootcamp.calories.service;

import com.bootcamp.calories.dto.CalorieReportDTO;

public interface ICaloricService {
    CalorieReportDTO getCalorieReport(String dish, int grams);
}
