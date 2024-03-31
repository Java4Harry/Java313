package lessons.src.Homework;

import java.util.HashMap;
import java.util.Map;

public class Homework_34 {
    public static void main(String[] args) {
        Map<String, Integer> mapBase = new HashMap<>(3, 0.75f);
        mapBase.put("X", 1);
        mapBase.put("Y", 2);
        mapBase.put("Z", 3);
        System.out.println("Исходный Map: " + mapBase);
        System.out.println("Измененный Map: " + ReverseMap(mapBase));
    }
    public static Map ReverseMap(Map map) {
        Map<String, Integer> mapBase = map;
        Map<Integer, String> mapChanged = new HashMap<>(3, 0.75f);
        for (Map.Entry<String, Integer> entry : mapBase.entrySet()) {
            mapChanged.put(entry.getValue(), "[" + entry.getKey() + "]");
        }
        return mapChanged;
    }
}
