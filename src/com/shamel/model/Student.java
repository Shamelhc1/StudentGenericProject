package com.shamel.model;

import com.shamel.util.QueryItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class Student implements Comparable<Student>, QueryItem {

    final String name;
    final int yearStarted;
    final String course;

    private static int IDmaker = 1000;
     final int studentID;

     static Random random =new Random();
    private static String[] firstNames = {"Andres", "Omar", "Mathew", "Dan", "Abby", "Han"};
    private static String[] courses = {"Java", "Calculus", "C++", "C#", "RF design", "Antenna Design"};


    public Student() {

        // this will initialize first name and last name initials:
        this.name = firstNames[random.nextInt(firstNames.length)]
                +" "+ "ABCDEFJHIJKLMNOPQRSTUVWXYZ".split("")[random.nextInt(0, 25)]
        +".";

        this.course = courses[random.nextInt(courses.length)];
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
        return "{%-10s %-10s %-10d %-10s".formatted(name, studentID, yearStarted, course+"}");
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

    // creating a static nested comparator subclass in order to encapsulate
    // the field inside Student class (optionally):

    public static class studentComparator<T extends Student> implements Comparator<Student> {

        private String fieldToCompare;

        // setting a default constructor,
        // with the student name as the default field to compare

        public studentComparator() {
            this("name");
        }

        public studentComparator(String fieldToCompare) {
            this.fieldToCompare = fieldToCompare;
        }

        @Override
        public int compare(Student o1, Student o2) {
            return switch (fieldToCompare.toLowerCase()){
                case "yearstarted" ->  ((Integer) o1.yearStarted).compareTo(o2.yearStarted);
                case "studenid" ->  ((Integer) o1.studentID).compareTo(o2.studentID);
                case "course" -> o1.course.compareTo(o2.course);
                default -> o1.name.compareTo(o2.name);
            };
        }
    }

}
