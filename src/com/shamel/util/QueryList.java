package com.shamel.util;

import java.util.ArrayList;
import java.util.List;

//      Explanations:
// this is a QueryList class, which is purposed to search through a list
// of objects that are instances (or subclasses) of QueryItem, and return
// the objects/instances that contains the field that has value specified

public class QueryList<T extends  QueryItem> extends ArrayList<T> {

    // this method is called from an instance of QueryList

    public List<T> getMatches(String fieldName, String value){
        List<T> items = new ArrayList<>();
        for(var item : this){
            if(item.matchFieldValue(fieldName, value)){
                items.add(item);
            }
        }
        return items;
    }

    // this is a static implementation called from the Class name (no instantiation needed):

    public static <T extends QueryItem> List<T> getMatches(List<T> itemsToSearch,
                                                           String fieldName, String value){
        List<T> items = new ArrayList<>();
        for(var item : itemsToSearch){
            if(item.matchFieldValue(fieldName, value)){
                items.add(item);
            }
        }
        return items;
    }

}
