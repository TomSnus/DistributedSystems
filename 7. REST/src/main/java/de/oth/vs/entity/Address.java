package de.oth.vs.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Jon on 23.05.2017.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    private String str;
    private String place;


    public Address() {
    }

    public Address(String str, String place) {
        this.str = str;
        this.place = place;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (str != null ? !str.equals(address.str) : address.str != null) return false;
        return place != null ? place.equals(address.place) : address.place == null;
    }

    @Override
    public int hashCode() {
        int result = str != null ? str.hashCode() : 0;
        result = 31 * result + (place != null ? place.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n")
                .append("Street ")
                .append(str)
                .append("Place ")
                .append(place);
        return builder.toString();
    }
}
