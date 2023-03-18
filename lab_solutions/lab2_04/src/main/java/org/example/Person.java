package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Person {

    private int id;

    private static int counterId=0;
    private String name;
    private int age;
    private String occupation;

    public Person( String name, int age, String occupation) {
        this.id = counterId++;
        this.name = name;
        setAge(age);
        this.occupation = occupation;
    }

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("La edad no puede ser menor de 0");
        }
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public static Person clone(Person person1) {
        return new Person( person1.getName(), person1.getAge(), person1.getOccupation());
    }

    public Person clone() {
        return new Person( this.getName(), this.getAge(), this.getOccupation());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(occupation, person.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, occupation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
    }

    public void writePerson(String path)  {
        FileWriter writer = null;
        try {
            writer = new FileWriter(path,true);
            writer.write(toString());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Ha ocurrido un problema al escribir el archivo");
        }
    }

    public static void writePerson(Person person, String path)  {
        FileWriter writer = null;
        try {
            writer = new FileWriter(path,true);
            writer.write(person.toString());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Ha ocurrido un problema al escribir el archivo");
        }
    }
}
