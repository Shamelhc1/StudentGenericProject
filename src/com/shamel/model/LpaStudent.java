package com.shamel.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LpaStudent extends Student{

    private final double percentCompleted;

    private static Random random = new Random();

    public LpaStudent() {
        percentCompleted = random.nextDouble(30.00, 100.001);
    }


    // we will override the matchFieldValue method on the LPAStudent class,
    // so that the returned student is not matched on percent complete equal to a value,
    // but on percent less than or equal to a submitted value.



    @Override
    public boolean matchFieldValue(String fieldName, String value) {

        String fieldNameCapitalised = fieldName.toUpperCase();

        return switch (fieldNameCapitalised){
            case "NAME" -> super.getName().equalsIgnoreCase(value);
            case "YEARSTARTED" -> super.getYearStarted() == Integer.parseInt(value);
            case "COURSE" -> super.getCourse().equalsIgnoreCase(value);
            case "PERCENTCOMPLETED" -> this.percentCompleted <= Double.parseDouble(value);
            default -> false;
        };
    }

    @Override
    public String toString() {
        return "{%-10s %-10s %-10d %-10s %-10.2f".formatted(getName(), getYearStarted(),getStudentID(),
                getCourse(), percentCompleted).trim()+"}";
    }

    public static List<LpaStudent> generateRandomLPADataBase(int size){
        List<LpaStudent> data = new ArrayList<>();
        for(int i =1; i<= size; i++){
            data.add(new LpaStudent());
        }
        return data;
    }

}
