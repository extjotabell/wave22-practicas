package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

@Service
public class ObtenerDiplomaService implements IObtenerDiplomaService {

    @Override
    public StudentDTO analyzeScores(StudentDTO rq) {
        rq.setAverageScore(calculateAverage(rq.getSubjects()));
        rq.setMessage(getGreetingMessage(rq.getStudentName(), rq.getAverageScore()));

        return rq;
    }

    private String getGreetingMessage(String studentName, BigDecimal average) {
        return "El alumno " + studentName + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(average)
                + ((average.doubleValue() > 9) ? ". Felicitaciones!" : ". Puedes mejorar.");
    }

    private BigDecimal calculateAverage(List<SubjectDTO> scores) {
        return scores.stream()
                .map(s -> BigDecimal.valueOf(s.getScore()))
                .reduce(BigDecimal::add).orElseGet(() -> BigDecimal.ZERO).divide(BigDecimal.valueOf(scores.size()), 2, RoundingMode.HALF_UP);

    }
}
