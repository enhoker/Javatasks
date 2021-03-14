package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.company.ParserObject.collectionToMaps;

public class ParserObjectTest {

    @Test
    public void collectionToMapsOnEmptyCollection() throws IllegalAccessException {
        ArrayList<Object> arts = new ArrayList<>();
        ArrayList<HashMap<String, String>> exList = new ArrayList<>();
        ArrayList<HashMap<String, String>> actList = collectionToMaps(arts);
        Assert.assertEquals(exList, actList);
    }

    @Test
    public void collectionToMapsOnOneObject() throws IllegalAccessException {
        ArrayList<Object> arts = new ArrayList<>();
        Art art = new Art();
        art.putData("N", "A", 4, true);
        arts.add(art);
        ArrayList<HashMap<String, String>> exList = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "N");
        map.put("arter", "A");
        map.put("size", "4");
        map.put("ended", "true");
        exList.add(map);
        ArrayList<HashMap<String, String>> actList = collectionToMaps(arts);
        Assert.assertEquals(exList, actList);
    }

    @Test
    public void collectionToMapsOnLittleCollecion() throws IllegalAccessException {
        ArrayList<Object> arts = new ArrayList<>();
        Art art1 = new Art();
        Art art2 = new Art();
        Art art3 = new Art();
        art1.putData("Funny faces", "Asinastra", 2, true);
        art2.putData("Dragon", "Bart", 8, true);
        art3.putData("Lion", "Misha", 5, false);
        arts.add(art1);
        arts.add(art2);
        arts.add(art3);
        ArrayList<HashMap<String, String>> exList = new ArrayList<>();
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("name", "Funny faces");
        map1.put("arter", "Asinastra");
        map1.put("size", "2");
        map1.put("ended", "true");
        exList.add(map1);
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("name", "Dragon");
        map2.put("arter", "Bart");
        map2.put("size", "8");
        map2.put("ended", "true");
        exList.add(map1);
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("name", "Lion");
        map3.put("arter", "Misha");
        map3.put("size", "5");
        map3.put("ended", "false");
        exList.add(map3);
        ArrayList<HashMap<String, String>> actList = collectionToMaps(arts);
        Assert.assertEquals(exList, actList);
    }

    @Test
    public void objectToMapTest() throws IllegalAccessException {
        Art art = new Art();
        art.putData("N", "A", 4, true);
        HashMap<String, String> exec = new HashMap<>();
        exec.put("name", "N");
        exec.put("arter", "A");
        exec.put("size", "4");
        exec.put("ended", "true");
        HashMap<String, String> act = new HashMap<>();
        act = ParserObject.objectToMap(art);
        Assert.assertEquals(exec, act);
    }

    @Test
    public void objectOnFieldsTest() throws IllegalAccessException {
        Art art = new Art();
        art.putData("N", "A", 4, true);
        ArrayList<String> exec = new ArrayList<>();
        exec.add("name");
        exec.add("arter");
        exec.add("size");
        exec.add("ended");
        ArrayList<String> act = new ArrayList<>();
        act = ParserObject.objectOnFields(art);
        Collections.sort(exec);
        Collections.sort(act);

        Assert.assertEquals(exec, act);
    }

    @Test
    public void getClassTest() throws IllegalAccessException {
        Art art = new Art();
        art.putData("N", "A", 4, true);
        String exec = "com.company.Art";
        String act = ParserObject.getClass(art);
        Assert.assertEquals(exec, act);
    }


}



























