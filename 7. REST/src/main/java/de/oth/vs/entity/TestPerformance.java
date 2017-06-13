package de.oth.vs.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by stt44293 on 13.06.2017.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TestPerformance {

    private String examId;
    private int matrikelNr;
    private int tries;
    private double grade;


    public TestPerformance(String examId, int matrikelNr, int tries, double grade) {
        this.examId = examId;
        this.matrikelNr = matrikelNr;
        this.tries = tries;
        this.grade = grade;
    }

    public TestPerformance() {
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public int getMatrikelNr() {
        return matrikelNr;
    }

    public void setMatrikelNr(int matrikelNr) {
        this.matrikelNr = matrikelNr;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Id: ")
                .append(examId)
                .append("MatrikelNr: ")
                .append(matrikelNr)
                .append("Tries: ")
                .append(tries)
                .append("Grade: ")
                .append(grade);
        return builder.toString();
    }
}
