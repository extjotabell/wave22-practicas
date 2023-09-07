package com.example.covid19.model;

public class Symptom {
    private String name;
    private SeverityLevel severityLevel;

    public Symptom(String name, SeverityLevel severityLevel) {
        this.name = name;
        this.severityLevel = severityLevel;
    }

    public String getName() {
        return name;
    }

    public SeverityLevel getSeverityLevel() {
        return severityLevel;
    }

    @Override
    public String toString() {
        return "Symptom{" +
                "name='" + name + '\'' +
                ", severityLevel=" + severityLevel +
                '}';
    }
}
