package com.sebli;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String gender;
    private List<Person> dates;




    public Person(String name, String gender) {
        this.name = name;
        this.gender = gender;
        dates=new ArrayList<>();

    }

    public Person() {
        dates=new ArrayList<>();

    }

    public List<Person> getDates() {
        return dates;
    }

    public void setDates(List<Person> dates) {
        this.dates = dates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}
