package org.campus02.hoedl;

import java.util.Objects;

public class Person {

    private String name;
    private int alter;
    private boolean bezahlt;

    public Person(String name, int alter, boolean bezahlt) {
        this.name = name;
        this.alter = alter;
        this.bezahlt = bezahlt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public boolean isBezahlt() {
        return bezahlt;
    }

    public void setBezahlt(boolean bezahlt) {
        this.bezahlt = bezahlt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return alter == person.alter && bezahlt == person.bezahlt && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, alter, bezahlt);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", alter=" + alter +
                ", bezahlt=" + bezahlt +
                '}';
    }
}
