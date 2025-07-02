package com.shamel;

import com.shamel.model.LpaStudent;
import com.shamel.model.Student;
import com.shamel.util.QueryList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class studentComparator<T extends Student> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }
}

public class Main {



    public static void main(String[] args) {

//        //Generating a list of 25 random students:
//        List<Student> randomStudents = Student.generateRandomStudentDataBase(25);
//        randomStudents.forEach(System.out::println);
//
//        System.out.print("\n".repeat(3));
//
//        QueryList<Student> studentsTobeSearched = new QueryList<>();
//        studentsTobeSearched.addAll(randomStudents);
//
//        // Obtaining the list of student enrolled in Java
//        List<Student> JavaStudents =studentsTobeSearched.getMatches("course","Java");
//
//        // we will print the list of Java Students here:
//        JavaStudents.forEach(System.out::println);

        System.out.println("Full list of Students" +"\n");
        //Generating a list of 25 random students: //
        List<LpaStudent> randLpa = LpaStudent.generateRandomLPADataBase(30);
        randLpa.forEach(System.out::println);


        // adding the list to the QueryList:
        QueryList<LpaStudent> studentsTobeSearched = new QueryList<>();
        studentsTobeSearched.addAll(randLpa);

        System.out.println("\n"+"list of student enrolled in Java");
        // Obtaining the list of student enrolled in Java:
        List<LpaStudent> JavaStudents =studentsTobeSearched.getMatches("course","Java");
        JavaStudents.forEach(System.out::println);


        System.out.println("\n"+"list of student enrolled in Java by ID sorted by ID");
        // Sorting the list of student enrolled in Java by ID -- Using the nested Comparator on Student Class:
        var LpaStudentComparator= new Student.studentComparator<>("studentID");

        JavaStudents.sort(LpaStudentComparator);
        JavaStudents.forEach(System.out::println);

        // Using Lambda expression to filter through the lists:
        //  removing all students enrolled in 2019:

        JavaStudents.removeIf(s -> s.getYearStarted() == 2019);
        System.out.println("\nremoving all students enrolled in 2019:");
        JavaStudents.forEach(System.out::println);


        // now lets get a list of 2020 students using lambda expressions:

        List<Student> list2020 = new ArrayList<>();
        randLpa.forEach(s->{
            if(s.getYearStarted() == 2020){
                list2020.add(s);
            }
        });

        System.out.println("\nOnly students enrolled in 2020:");
        list2020.forEach(System.out::println);


    }
}
