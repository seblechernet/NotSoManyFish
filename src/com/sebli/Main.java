package com.sebli;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        ArrayList<String> scenarios = new ArrayList<>();
        Person person1 = new Person("Sarah");
        people.add(person1);
        Person person2 = new Person("Michael");
        people.add(person2);
        Person person3 = new Person("Lisa");
        people.add(person3);
        Person person4 = new Person("Simon");
        people.add(person4);
        Person person5 = new Person("Natan");
        people.add(person5);
        Person person6 = new Person("Ednah");
        people.add(person6);

        scenarios.add(" tipped over a glass during a date with ");
        scenarios.add(" visited ");
        scenarios.add(" went to a meetup with ");
        scenarios.add(" saw a movie with ");
        scenarios.add(" played chess with ");
        scenarios.add(" went to a meetup with ");
        scenarios.add(" had lunch with ");


        Random rd = new Random();
        int iteration = 1;
        do {
            int index1 = rd.nextInt(5);
            int index2 = rd.nextInt(5);
            Person firstPerson = people.get(index1);
            Person secondPerson = people.get(index2);

            int random1 = rd.nextInt(scenarios.size()-1);
            String firstScenario = scenarios.get(random1);
            scenarios.remove(scenarios.get(random1));

            int random2 = rd.nextInt(scenarios.size()-1);
            String secondScenario = scenarios.get(random2);
            scenarios.remove(scenarios.get(random2));

            int random3 = rd.nextInt(scenarios.size()-1);
            String thirdScenario = scenarios.get(random3);
            scenarios.remove(scenarios.get(random3));


            if (firstPerson == secondPerson) {
                System.out.println(people.get(index1).getName() + " was free on Saturday");
            } else {
                firstPerson.getDates().add(secondPerson);
                secondPerson.getDates().add(firstPerson);
                System.out.printf("\n%s asked %s and %s accepted", firstPerson.getName(), secondPerson.getName(), secondPerson.getName());
                System.out.printf("\n  -%s%s%S",firstPerson.getName(),firstScenario,secondPerson.getName());
                scenarios.add(firstScenario);
                System.out.printf("\n  -%s%s%S",firstPerson.getName(),secondScenario,secondPerson.getName());
                scenarios.add(secondScenario);
                System.out.printf("\n  -%s%s%S",firstPerson.getName(),thirdScenario,secondPerson.getName());
                scenarios.add(thirdScenario);

            }
            iteration++;
        } while (iteration < 10);

        System.out.println("\n***--- Summary ---***");
        for (Person eachPerson : people) {
            for (Person eachDate : eachPerson.getDates()) {
                if (eachDate == null) {
                    eachPerson.getDates().remove(eachDate);
                }
            }

            System.out.println(eachPerson.getName() + " Got " + eachPerson.getDates().size() + " Dates ");
        }
    }
}
