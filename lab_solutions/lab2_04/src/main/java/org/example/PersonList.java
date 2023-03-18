package org.example;

import java.util.ArrayList;

public class PersonList {

     private  ArrayList<Person> personArrayList;


    public PersonList(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }

    public ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public Person clone(Person person) {
        int maxId = 0;
        for (Person persona : personArrayList){
            if(persona.getId()>maxId){
                maxId = persona.getId();
            }
        }
        return new Person(maxId, person.getName(),person.getAge(), person.getOccupation());
    }


    public void setPersonArrayList(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }
    //^[A-Za-z]{1,} [A-Za-z]{1,}$
    public Person findByName(String name) {
        if(name.split(" ").length != 2) {
            throw new IllegalArgumentException("El nombre debe tener un formato correcto");
        }
        for (Person person :personArrayList) {
            if(person.getName().equals(name)) {
                return person;
            }
        }
        throw new RuntimeException("Person not found");
    }


}
