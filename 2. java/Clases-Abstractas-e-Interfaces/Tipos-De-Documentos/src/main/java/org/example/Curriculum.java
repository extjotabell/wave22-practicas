package org.example;

import java.util.List;

public class Curriculum implements Imprimible<Curriculum>{
    private String fullname;
    private List<String> skillsList;

    public Curriculum(String fullname, List<String> skillsList) {
        this.fullname = fullname;
        this.skillsList = skillsList;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public List<String> getSkillsList() {
        return skillsList;
    }

    public void setSkillsList(List<String> skillsList) {
        this.skillsList = skillsList;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "fullname='" + fullname + '\'' +
                ", skillsList=" + skillsList +
                '}';
    }

    @Override
    public void imprimir(Curriculum cv) {
        System.out.println("Imprimiendo el curriculum: " + cv.toString());
    }
}
