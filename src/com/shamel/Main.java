package com.shamel;

import com.shamel.model.Student;
import com.shamel.util.QueryList;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Generating a list of 25 random students:
        List<Student> randomStudents = Student.generateRandomStudentDataBase(25);
        randomStudents.forEach(System.out::println);

        System.out.print("\n".repeat(3));

        QueryList<Student> studentsTobeSearched = new QueryList<>();
        studentsTobeSearched.addAll(randomStudents);

        // Obtaining the list of student enrolled in Java
        List<Student> JavaStudents =studentsTobeSearched.getMatches("course","Java");

        // we will print the list of Java Students here:
        JavaStudents.forEach(System.out::println);

    }


}
