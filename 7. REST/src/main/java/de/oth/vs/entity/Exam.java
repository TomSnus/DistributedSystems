package de.oth.vs.entity;

/**
 * Created by stt44293 on 13.06.2017.
 */
public class Exam {
    public String id;
    public String bezeichnung;
    public int ects;

    public Exam(String id, String bezeichnung, int ects) {
        this.id = id;
        this.bezeichnung = bezeichnung;
        this.ects = ects;
    }

    public Exam() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Id: ")
                .append(id)
                .append("Bezeichnung: ")
                .append(bezeichnung)
                .append("ECTS: ")
                .append(ects);
        return builder.toString();
    }
}
