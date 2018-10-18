package com.sebli;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        ArrayList<String> scenarios = new ArrayList<>();
        Person person1 = new Person("Sarah","F");
        people.add(person1);
        Person person2 = new Person("Michael","M");
        people.add(person2);
        Person person3 = new Person("Lisa","F");
        people.add(person3);
        Person person4 = new Person("Simon","M");
        people.add(person4);
        Person person5 = new Person("Natan","M");
        people.add(person5);
        Person person6 = new Person("Ednah","F");
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
            int index1 = rd.nextInt(6);
            int index2 = rd.nextInt(6);
            Person firstPerson = people.get(index1);
            Person secondPerson = people.get(index2);

            int random1 = rd.nextInt(scenarios.size());
            String firstScenario = scenarios.get(random1);
            scenarios.remove(scenarios.get(random1));

            int random2 = rd.nextInt(scenarios.size());
            String secondScenario = scenarios.get(random2);
            scenarios.remove(scenarios.get(random2));

            int random3 = rd.nextInt(scenarios.size());
            String thirdScenario = scenarios.get(random3);
            scenarios.remove(scenarios.get(random3));
            scenarios.add(firstScenario);
            scenarios.add(secondScenario);
            scenarios.add(thirdScenario);

            if (firstPerson == secondPerson && people.get(index1).getGender().equals("F")) {
                System.out.printf("\n\n%d. %s was free on Saturday.No dates for her \n",iteration,people.get(index1).getName());
            if (firstPerson == secondPerson && people.get(index1).getGender().equals("M")) {
                System.out.printf("\n\n%d. %s was free on Saturday.No dates for him \n", iteration,people.get(index1).getName());
            }
            } else {
                firstPerson.getDates().add(secondPerson);
                secondPerson.getDates().add(firstPerson);
                System.out.printf("\n%d. %s asked %s and %s accepted", iteration,firstPerson.getName(), secondPerson.getName(), secondPerson.getName());
                System.out.printf("\n  -%s%s%s",firstPerson.getName(),firstScenario,secondPerson.getName());

                System.out.printf("\n  -%s%s%s",firstPerson.getName(),secondScenario,secondPerson.getName());

                System.out.printf("\n  -%s%s%s",firstPerson.getName(),thirdScenario,secondPerson.getName());


            }
            iteration++;
        } while (iteration <= 10);

        System.out.println("\n***--- Summary ---***");
        for (Person eachPerson : people) {
            for (Person eachDate : eachPerson.getDates()) {
                if (eachDate == null) {
                    eachPerson.getDates().remove(eachDate);
                }
            }
            if(eachPerson.getDates().size()==0){
                System.out.printf("No dates for %s",eachPerson.getName());
            }
            else
            System.out.println(eachPerson.getName() + " Got " + eachPerson.getDates().size() + " Dates ");
        }
    }
}
