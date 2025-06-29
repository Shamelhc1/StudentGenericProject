package com.shamel.util;

// A Class that implements this interface is searchable using
// the QueryList Class in the com.shamel.util package

public interface QueryItem {

    public boolean matchFieldValue(String fieldName, String Value);

}
