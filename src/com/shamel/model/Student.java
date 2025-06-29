package com.shamel.model;

import com.shamel.util.QueryItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student implements Comparable<Student>, QueryItem {

    final String name;
    final int yearStarted;
    final String course;

    private static int IDmaker = 1000;
    private final int studentID;

     static Random random =new Random();
    private static String[] firstNames = {"Andres", "Omar", "Mathew", "Dan", "Abby", "Han"};
    private static String[] courses = {"Java", "Calculus", "C++", "C#", "RF design"};


    public Student() {

        this.name = firstNames[random.nextInt(firstNames.length -1)];
        this.course = courses[random.nextInt(courses.length -1)];
        this.yearStarted = random.nextInt(2019, 2023);
        this.studentID = IDmaker++;

    }


    @Override
    public int compareTo(Student other) {
        return ((Integer) (this.studentID)).compareTo((Integer) (other.studentID));
    }


    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fieldNameCapitalised = fieldName.toUpperCase();
        return switch (fieldNameCapitalised){
            case "NAME" -> this.name.equalsIgnoreCase(value);
            case "YEARSTARTED" -> this.yearStarted == Integer.parseInt(value);
            case "COURSE" -> this.course.equalsIgnoreCase(value);
            default -> false;
        };
    }

    @Override
    public String toString() {
        return "{%-10s %-10d %-10s".formatted(name, yearStarted, course+"}");
    }

    // this is a static method to generate a Randomized Student databased written into a
    // List, we will use this method to test our methods and classes in this package:

    public static List<Student> generateRandomStudentDataBase(int size){
        List<Student> data = new ArrayList<>();
        for(int i =1; i<= size; i++){
            data.add(new Student());
        }
        return data;
    }

}
