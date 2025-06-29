package com.shamel.model;

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
            case "NAME" -> super.name.equalsIgnoreCase(value);
            case "YEARSTARTED" -> super.yearStarted == Integer.parseInt(value);
            case "COURSE" -> super.course.equalsIgnoreCase(value);
            case "PERCENTCOMPLETED" -> this.percentCompleted <= Double.parseDouble(value);
            default -> false;
        };

    }
}
