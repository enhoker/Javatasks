package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.lang.reflect.Field;

public class ParserObject {

    static ArrayList<HashMap<String, String>> collectionToMaps(Collection<Object> objects) throws IllegalAccessException {
        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

        for (Object object:objects) {
            Field[] fields = object.getClass().getDeclaredFields();
            HashMap<String, String> map = new HashMap<>();
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(object).toString());
            }
            list.add(map);
        }
            return list;
    }

    static HashMap<String, String> objectToMap(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        HashMap<String, String> map = new HashMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(object).toString());
        }
        return map;
    }

    static ArrayList<String> objectOnFields(Object object) throws IllegalAccessException {
        ArrayList<String> stringFields = new ArrayList<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field f:fields) {
            stringFields.add(f.getName());
        }
        return stringFields;
    }

    static String getClass(Object object) {
        String nameClass = object.getClass().getName();
        return  nameClass;
    }




}
