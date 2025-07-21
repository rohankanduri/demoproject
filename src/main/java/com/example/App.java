package com.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class Person {
    String name;
    int age;
    double balanceAmount;
    List<String> interests;

    public Person(String name, int age, double balanceAmount, List<String> interests) {
        this.name = name;
        this.age = age;
        this.balanceAmount = balanceAmount;
        this.interests = interests;
    }

}

public class App {
    public static void main(String[] args) {
        Person person = new Person(
            "Rohan",
            22,
            1500.75,
            Arrays.asList("coding", "photography", "traveling")
        );

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter("person.json")) {
            gson.toJson(person, writer);
            System.out.println(" JSON written to person.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader("person.json")) {
            Person loadedPerson = gson.fromJson(reader, Person.class);
            System.out.println(" Person loaded from JSON:");
            System.out.println("Name: " + loadedPerson.name);
            System.out.println("Age: " + loadedPerson.age);
            System.out.println("Balance: " + loadedPerson.balanceAmount);
            System.out.println("Interests: " + loadedPerson.interests);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
