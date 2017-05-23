package de.oth.vs.entity;

/**
 * Created by Jon on 23.05.2017.
 */
public class Student {
    private int id;
    private String name;
    private int ects;
    private Address address;


    public Student(int id, String name, int ects, Address address) {
        this.id = id;
        this.name = name;
        this.ects = ects;
        this.address = address;
    }


    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id == student.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
