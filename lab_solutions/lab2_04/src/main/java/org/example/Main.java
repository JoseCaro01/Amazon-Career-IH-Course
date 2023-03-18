package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Person person = new Person("Jose",10,"TA");
        Person person1 = new Person("Adrian",18,"None");
        person.writePerson("hola.txt");
        person1.writePerson("hola.txt");
        Person.writePerson(person,"hola.txt");
    }


}