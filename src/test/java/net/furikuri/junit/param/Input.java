package net.furikuri.junit.param;


import java.util.*;

public class Input {

    List<Map<String, String>> iterator = new ArrayList<>();

    public Input add(String key, String... values) {
        List<Map<String, String>> newParameters = new ArrayList<>();

        for (String value : values) {
            if (iterator.isEmpty()) {
                Map<String, String> map = new HashMap<>();
                map.put(key, value);
                newParameters.add(map);
            } else {
                for (Map<String, String> currentValues : iterator) {
                    Map<String, String> map = new HashMap<>(currentValues);
                    map.put(key, value);
                    newParameters.add(map);
                }
            }
        }

        iterator = newParameters;

        return this;
    }

    public Iterator<Map<String, String>> generate() {
        return iterator.iterator();
    }

}
